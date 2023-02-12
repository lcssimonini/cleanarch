package com.ada.cleanarch.postalcode;

import com.ada.cleanarch.postalcode.dto.CEPCreateRequestModel;
import com.ada.cleanarch.postalcode.dto.CEPResponseModel;

public interface CEPInputBoundary {

  CEPResponseModel create(CEPCreateRequestModel requestModel);
}
