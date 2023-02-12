package com.ada.cleanarch.postalcode.presenter;

import com.ada.cleanarch.postalcode.dto.CEPResponseModel;

public interface CEPPresenter {

  CEPResponseModel prepareFailView(String errorMessage);

  CEPResponseModel prepareSuccessView(CEPResponseModel cepResponseModel);
}
