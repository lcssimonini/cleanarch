package com.ada.cleanarch.adapter.controller.exception;

import com.ada.cleanarch.postalcode.exception.CEPCreationException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.Builder;
import lombok.Value;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;

@Value
@Builder
public class ApiErrorModel {
  String title;
  Integer status;
  Map<String, List<String>> errors;

  public static ApiErrorModel notFound(NotFoundException e) {
    return ApiErrorModel.builder()
        .title(e.getMessage())
        .status(HttpStatus.NOT_FOUND.value())
        .build();
  }

  public static ApiErrorModel serverError(Exception e) {
    return ApiErrorModel.builder()
        .title(e.getMessage())
        .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
        .build();
  }

  public static ApiErrorModel validationError(BindingResult bindingResult) {
    return validationError(getErrors(bindingResult));
  }

  public static ApiErrorModel validationError(Map<String, List<String>> errors) {
    return ApiErrorModel.builder()
        .title("One or more validation errors occurred.")
        .status(HttpStatus.BAD_REQUEST.value())
        .errors(errors)
        .build();
  }

  private static Map<String, List<String>> getErrors(BindingResult bindingResult) {
    return bindingResult.getFieldErrors().stream()
        .collect(
            Collectors.groupingBy(
                v -> "$." + v.getField(),
                Collectors.mapping(
                    DefaultMessageSourceResolvable::getDefaultMessage, Collectors.toList())));
  }

  public static ApiErrorModel cedCreationException(CEPCreationException e) {
    return ApiErrorModel.builder().title(e.getMessage()).status(e.getHttpStatus()).build();
  }

  public static ApiErrorModel handleValidationException(MethodArgumentNotValidException e) {
    return validationError(e.getBindingResult());
  }
}
