package com.cognizant;

import com.cognizant.models.*;
import com.cognizant.service.PetAdoptionCenter;
import com.cognizant.exceptions.*;

public class AdoptionApp {
  public static void main(String[] args) {
    PetAdoptionCenter center = new PetAdoptionCenter();
    
    try {
      /* LOAD DATA: */
      center.loadData("center.dat");
    } catch (Exception e) {
      System.out.println("No saved data found. Starting fresh.");
    }
    
    try {
      /* ADD A PET: */
      center.addPet(new Dog(1, "Rex", 3, "German Shepherd", true));
      center.addPet(new Cat(2, "Whiskers", 2, "Siamese"));
      
      /* REGISTER AN ADOPTER: */
      Adopter alice = new Adopter(100, "Alice", "alice@email.com");
      center.registerAdopter(alice);
      
      /* LIST AVAILABLE PETS: */
      System.out.println("Available Pets:");
      center.viewAvailablePets();
      
      /* ADOPT PET */
      center.adoptPet(1, 100);
      
      /* HANDLE REQUEST-RELATED ERRORS */
      center.adoptPet(1, 100);//Should throw "AlreadyAdoptedException."
      
    } catch (AlreadyAdoptedException | PetNotFoundException e) {
      System.err.println("Adoption error: " + e.getMessage());
    } catch (Exception e) {
      System.err.println("Unexpected error: " + e.getMessage());
    } finally {
      try {
        center.saveData("center.dat");
        System.out.println("System state saved.");
      } catch (Exception e) {
        System.err.println("Failed to save data: " + e.getMessage());
      }//try-catch
    }//try-catch-finally
  }//main()
  
}//AdoptionApp
