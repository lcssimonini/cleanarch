package com.ada.cleanarch.postalcode;

import com.ada.cleanarch.postalcode.datasource.CEPDSRequestModel;
import com.ada.cleanarch.postalcode.datasource.CEPRegisterDSGateway;
import com.ada.cleanarch.postalcode.domain.CEP;
import com.ada.cleanarch.postalcode.domain.CEPFactory;
import com.ada.cleanarch.postalcode.dto.CEPCreateRequestModel;
import com.ada.cleanarch.postalcode.dto.CEPResponseModel;
import com.ada.cleanarch.postalcode.presenter.CEPPresenter;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CEPRegisterInteractor implements CEPInputBoundary {

  final CEPRegisterDSGateway cepDSGateway;
  final CEPPresenter cepPresenter;
  final CEPFactory cepFactory;

  @Override
  public CEPResponseModel create(CEPCreateRequestModel requestModel) {
    if (cepDSGateway.existsByPostalCode(requestModel.getPostalCode())) {
      return cepPresenter.prepareFailView("CEP already exists.");
    }
    CEP cep =
        cepFactory.create(
            requestModel.getPostalCode(),
            requestModel.getAddress(),
            requestModel.getNeighbourhood(),
            requestModel.getCity(),
            requestModel.getState());
    if (!cep.isValidPostalCode()) {
      return cepPresenter.prepareFailView("CEP should be a 8 digits string");
    }

    cepDSGateway.save(getRequestModel(requestModel));

    CEPResponseModel cepResponseModel =
        CEPResponseModel.builder()
            .postalCode(requestModel.getPostalCode())
            .address(requestModel.getAddress())
            .neighbourhood(requestModel.getNeighbourhood())
            .city(requestModel.getCity())
            .state(requestModel.getState())
            .build();
    return cepPresenter.prepareSuccessView(cepResponseModel);
  }

  private static CEPDSRequestModel getRequestModel(CEPCreateRequestModel requestModel) {
    LocalDateTime now = LocalDateTime.now();
    return CEPDSRequestModel.builder()
        .postalCode(requestModel.getPostalCode())
        .address(requestModel.getAddress())
        .neighbourhood(requestModel.getNeighbourhood())
        .city(requestModel.getCity())
        .state(requestModel.getState())
        .insertedAt(now)
        .build();
  }
}
