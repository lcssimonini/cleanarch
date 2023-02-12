package com.ada.cleanarch.postalcode.datasource;

public interface CEPRegisterDSGateway {

  boolean existsByPostalCode(String postalCode);

  void save(CEPDSRequestModel cepDSModel);
}
