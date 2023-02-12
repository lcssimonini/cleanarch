package com.ada.cleanarch.postalcode;

import com.ada.cleanarch.postalcode.dto.CEPResponseModel;
import com.ada.cleanarch.postalcode.dto.CEPSearchRequestModel;

public interface CEPSearchBoundary {

  CEPResponseModel search(CEPSearchRequestModel requestModel);
}
