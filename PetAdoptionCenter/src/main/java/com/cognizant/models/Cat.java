package com.cognizant.models;

import com.cognizant.exceptions.AlreadyAdoptedException;
import com.cognizant.exceptions.FailedVaccinationException;

import java.util.HashSet;
import java.util.Set;
import static java.util.Arrays.asList;

public class Cat extends Pet {
  public static Set<String> vaccines = new HashSet<>(asList("rabies", "distemper", "fvrcp", "fpv", "fvr", "fcv", "felv"));
  
  public Cat(int id, String name, int age, String breed) {
    super(id, name, "cat", age, breed);
  }//Cat - constructor
  
  /* Implemented methods: */
  public void vaccinate(String vaccine, Set<String> validVaccines) {
    vaccine = vaccine.toLowerCase();
    if (!validVaccines.contains(vaccine)) throw new FailedVaccinationException("Not a valid vaccine for this species.");
    if (vaccinesGiven.contains(vaccine)) throw new FailedVaccinationException(name + " has already been vaccinated against " + vaccine + ".");
    vaccinesGiven.add(vaccine);
    System.out.println(name + " has been vaccinated.");
  }//vaccinate()
  public void adopt() {
    if (isAdopted) throw new AlreadyAdoptedException(id);
    isAdopted = true;
  }//adopt()
  
}//Cat
