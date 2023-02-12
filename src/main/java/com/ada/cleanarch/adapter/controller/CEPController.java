package com.ada.cleanarch.adapter.controller;

import com.ada.cleanarch.postalcode.CEPInputBoundary;
import com.ada.cleanarch.postalcode.CEPSearchBoundary;
import com.ada.cleanarch.postalcode.dto.CEPCreateRequestModel;
import com.ada.cleanarch.postalcode.dto.CEPResponseModel;
import com.ada.cleanarch.postalcode.dto.CEPSearchRequestModel;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/cep")
public class CEPController {

  private final CEPInputBoundary cepInputBoundary;
  private final CEPSearchBoundary cepSearchBoundary;

  @PostMapping
  CEPResponseModel create(@RequestBody @Valid CEPCreateRequestModel requestModel) {
    log.info("request to save new CEP: {}", requestModel);
    return cepInputBoundary.create(requestModel);
  }

  @GetMapping
  CEPResponseModel search(@RequestParam String postalCode) {
    log.info("request to search CEP: {}", postalCode);
    return cepSearchBoundary.search(CEPSearchRequestModel.builder().postalCode(postalCode).build());
  }
}
