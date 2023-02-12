package com.ada.cleanarch.postalcode.datasource;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class CEPDSModel {

  String postalCode;
  String address;
  String neighbourhood;
  String city;
  String state;
  LocalDateTime insertedAt;
}
