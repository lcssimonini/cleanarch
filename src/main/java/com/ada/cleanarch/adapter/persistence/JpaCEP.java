package com.ada.cleanarch.adapter.persistence;

import com.ada.cleanarch.postalcode.datasource.CEPDSRequestModel;
import com.ada.cleanarch.postalcode.datasource.CEPRegisterDSGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JpaCEP implements CEPRegisterDSGateway {

  private final JpaCEPDataRepository repository;

  @Override
  public boolean existsByPostalCode(String postalCode) {
    return repository.existsByPostalCode(postalCode);
  }

  @Override
  public void save(CEPDSRequestModel requestModel) {
    CEPDataModel dataMapper =
        CEPDataModel.builder()
            .postalCode(requestModel.getPostalCode())
            .address(requestModel.getAddress())
            .neighbourhood(requestModel.getNeighbourhood())
            .city(requestModel.getCity())
            .state(requestModel.getState())
            .insertedAt(requestModel.getInsertedAt())
            .build();
    repository.save(dataMapper);
  }
}
