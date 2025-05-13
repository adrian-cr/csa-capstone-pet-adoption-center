package com.cognizant.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Adopter implements Serializable {
  private int id;
  private String name;
  private String email;
  private List<Pet> adoptedPets = new ArrayList<>();
  
  public Adopter(int id, String name, String contactInfo) {
    this.id = id;
    this.name = name;
    this.email = contactInfo;
  }
  
  public void adoptPet(Pet pet) {
    adoptedPets.add(pet);
  }
  
  public String getInfo() {
    return name + " (" + email + "), Pets Adopted: " + adoptedPets.size();
  }
  
  public int getId() {
    return id;
  }
}
