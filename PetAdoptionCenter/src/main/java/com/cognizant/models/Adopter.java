package com.cognizant.models;

import java.io.Serializable;

public class Adopter implements Serializable {
  private int adopterId;
  private String name;
  private String contactInfo;
  private List<Pet> adoptedPets = new ArrayList<>();
  
  public Adopter(int adopterId, String name, String contactInfo) {
    this.adopterId = adopterId;
    this.name = name;
    this.contactInfo = contactInfo;
  }
  
  public void adoptPet(Pet pet) {
    adoptedPets.add(pet);
  }
  
  public String getInfo() {
    return name + " (" + contactInfo + "), Pets Adopted: " + adoptedPets.size();
  }
  
  public int getAdopterId() {
    return adopterId;
  }
}
