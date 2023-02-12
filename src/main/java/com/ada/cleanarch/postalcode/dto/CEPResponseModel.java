package com.ada.cleanarch.postalcode.dto;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class CEPResponseModel {

  String postalCode;
  String address;
  String neighbourhood;
  String city;
  String state;
}
