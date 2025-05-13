package com.cognizant.models;

import com.cognizant.interfaces.Adoptable;
import com.cognizant.interfaces.Vaccinable;

import java.io.Serializable;
import java.util.*;

public abstract class Pet implements Adoptable, Vaccinable, Serializable {
  protected int id;
  protected String name;
  protected String species;
  protected int age;
  protected String breed;
  protected boolean isAdopted;
  protected final Set<String> vaccinesGiven = new HashSet<>();
  
  public Pet(int id, String name, String species, int age, String breed) {
    this.id = id;
    this.name = name;
    this.species = species;
    this.age = age;
    this.breed = breed;
    this.isAdopted = false;
  }
  
  public String getSpecies() {
    return species;
  }
  
  public int getAge() {
    return age;
  }
  
  public String getBreed() {
    return breed;
  }
  
  public boolean isAdopted() {
    return isAdopted;
  }
  
  public boolean isAvailable() {
    return !isAdopted;
  }
  
  public int getId() {
    return id;
  }//getId()
  
  @Override
  public String toString() {
    return
      "Name: " + name.toUpperCase() +
      "\nSpecies: " + species +
      "\nBreed: " + breed +
      "\nAge: " + age + " years" +
      "\nStatus: " + (isAdopted? "Adopted" : "Available");
  }//toString()
}


