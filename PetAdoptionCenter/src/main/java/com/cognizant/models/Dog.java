package com.cognizant.models;

import com.cognizant.exceptions.AlreadyAdoptedException;
import com.cognizant.exceptions.FailedVaccinationException;
import com.cognizant.interfaces.Vaccinable;

import java.util.HashSet;
import java.util.Set;
import static java.util.Arrays.asList;

public class Dog extends Pet implements Vaccinable {
  public static Set<String> vaccines = new HashSet<>(asList("rabies", "distemper", "adenovirus", "parvovirus", "parainfluenza"));
  private boolean isTrained;
  
  public Dog(int petId, String name, int age, String breed, boolean isTrained) {
    super(petId, name, "dog", age, breed);
    this.isTrained = isTrained;
  }//Dog - constructor
  
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
  
}//Dog