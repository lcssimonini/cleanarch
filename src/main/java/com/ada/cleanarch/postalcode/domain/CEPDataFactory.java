package com.ada.cleanarch.postalcode.domain;

public class CEPDataFactory implements CEPFactory {
  @Override
  public CEP create(
      String postalCode, String address, String neighbourhood, String city, String state) {
    return CEPModel.builder()
        .postalCode(postalCode)
        .address(address)
        .neighbourhood(neighbourhood)
        .city(city)
        .state(state)
        .build();
  }
}
