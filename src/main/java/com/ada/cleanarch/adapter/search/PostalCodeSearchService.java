package com.ada.cleanarch.adapter.search;

import com.ada.cleanarch.postalcode.dto.CEPResponseModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class PostalCodeSearchService {

  private final PostalCodeClient postalCodeClient;

  public CEPResponseModel searchPostalCode(String postalCode) {
    PostalSearchModel searchModel = postalCodeClient.getPostalCodeData(postalCode);
    log.info("found cep data {}", searchModel);
    return CEPResponseModel.builder()
        .postalCode(searchModel.getPostalCode())
        .address(searchModel.getAddress())
        .neighbourhood(searchModel.getNeighbourhood())
        .city(searchModel.getCity())
        .state(searchModel.getState())
        .build();
  }
}
