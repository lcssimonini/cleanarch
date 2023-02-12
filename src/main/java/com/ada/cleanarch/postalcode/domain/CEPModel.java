package com.ada.cleanarch.postalcode.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CEPModel implements CEP {

  public static final int BRAZILIAN_POSTAL_CODE_LENGTH = 8;
  public static final String ONLY_NUMERIC_PATTERN = "[0-9]+";
  private final String postalCode;
  private final String address;
  private final String neighbourhood;
  private final String city;
  private final String state;

  @Override
  public boolean isValidPostalCode() {
    return postalCode != null
        && !postalCode.isBlank()
        && postalCode.length() == BRAZILIAN_POSTAL_CODE_LENGTH
        && postalCode.matches(ONLY_NUMERIC_PATTERN);
  }
}
