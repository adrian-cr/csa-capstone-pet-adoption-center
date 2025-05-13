package com.cognizant.exceptions;

public class AlreadyAdoptedException extends RuntimeException {
  public AlreadyAdoptedException(int id) {
    super("Pet with ID " + id + " is already adopted.");
  }
}
