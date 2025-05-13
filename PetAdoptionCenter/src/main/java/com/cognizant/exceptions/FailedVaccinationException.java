package com.cognizant.exceptions;

public class FailedVaccinationException extends RuntimeException {
  public FailedVaccinationException(String message) {
    super(message);
  }
}
