package com.ada.cleanarch.postalcode;

import com.ada.cleanarch.adapter.search.PostalCodeSearchService;
import com.ada.cleanarch.postalcode.dto.CEPResponseModel;
import com.ada.cleanarch.postalcode.dto.CEPSearchRequestModel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CEPSearchInteractor implements CEPSearchBoundary {

  private final PostalCodeSearchService postalCodeSearchService;

  @Override
  public CEPResponseModel search(CEPSearchRequestModel requestModel) {
    return postalCodeSearchService.searchPostalCode(requestModel.getPostalCode());
  }
}
