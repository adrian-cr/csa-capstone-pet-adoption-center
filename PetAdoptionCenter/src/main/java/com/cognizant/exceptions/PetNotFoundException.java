package com.cognizant.exceptions;

public class PetNotFoundException extends RuntimeException {
  public PetNotFoundException(int id) {
    super("Pet with ID " + id + " not found.");
  }
}
