package com.ada.cleanarch.postalcode.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class CEPCreateRequestModel {

  @NotBlank String postalCode;
  String address;
  String neighbourhood;
  String city;
  String state;
}
