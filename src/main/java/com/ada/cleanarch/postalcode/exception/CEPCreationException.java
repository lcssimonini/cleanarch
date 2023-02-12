package com.ada.cleanarch.postalcode.exception;

import lombok.Getter;

public class CEPCreationException extends RuntimeException {
  @Getter private final int httpStatus;

  public CEPCreationException(int httpStatus, String errorMessage) {
    super(errorMessage);
    this.httpStatus = httpStatus;
  }
}
