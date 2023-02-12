package com.ada.cleanarch.postalcode.domain;

public interface CEP {

  String getPostalCode();

  String getAddress();

  String getNeighbourhood();

  String getCity();

  String getState();

  boolean isValidPostalCode();
}
