package com.ada.cleanarch.adapter.controller.exception;

import com.ada.cleanarch.postalcode.exception.CEPCreationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class ExceptionHandlingConfig {

  @ExceptionHandler(NotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ResponseBody
  public ApiErrorModel onNotFoundException(NotFoundException exception) {
    return ApiErrorModel.notFound(exception);
  }

  @ExceptionHandler(CEPCreationException.class)
  @ResponseStatus(HttpStatus.CONFLICT)
  @ResponseBody
  public ApiErrorModel onNotFoundException(CEPCreationException exception) {
    return ApiErrorModel.cedCreationException(exception);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ApiErrorModel handleValidationException(MethodArgumentNotValidException exception) {
    return ApiErrorModel.handleValidationException(exception);
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ResponseBody
  public ApiErrorModel onException(Exception exception) {
    log.error("unhandled exception: {}", exception.getMessage(), exception);
    return ApiErrorModel.serverError(exception);
  }
}
