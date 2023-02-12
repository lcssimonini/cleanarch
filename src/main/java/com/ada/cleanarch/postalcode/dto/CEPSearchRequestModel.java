package com.ada.cleanarch.postalcode.dto;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class CEPSearchRequestModel {

  String postalCode;
}
