package com.ada.cleanarch.postalcode.domain;

public interface CEPFactory {

  CEP create(String postalCode, String address, String neighbourhood, String city, String state);
}
