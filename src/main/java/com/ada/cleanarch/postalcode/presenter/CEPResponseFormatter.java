package com.ada.cleanarch.postalcode.presenter;

import com.ada.cleanarch.postalcode.dto.CEPResponseModel;
import com.ada.cleanarch.postalcode.exception.CEPCreationException;

public class CEPResponseFormatter implements CEPPresenter {
  @Override
  public CEPResponseModel prepareFailView(String errorMessage) {
    throw new CEPCreationException(409, errorMessage);
  }

  @Override
  public CEPResponseModel prepareSuccessView(CEPResponseModel cepResponseModel) {
    return cepResponseModel;
  }
}
