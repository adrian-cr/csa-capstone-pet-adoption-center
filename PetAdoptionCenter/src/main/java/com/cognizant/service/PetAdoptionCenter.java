package com.cognizant.service;

import com.cognizant.exceptions.AlreadyAdoptedException;
import com.cognizant.exceptions.PetNotFoundException;
import com.cognizant.models.Adopter;
import com.cognizant.models.Pet;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PetAdoptionCenter {
  private List<Pet> pets = new ArrayList<>();
  private List<Adopter> adopters = new ArrayList<>();
  
  public void addPet(Pet pet) {
    pets.add(pet);
  }//addPet()
  public void registerAdopter(Adopter adopter) {
    adopters.add(adopter);
  }//registerAdopter()
  
  public Pet findPetById(int id) throws PetNotFoundException {
    return pets.stream()
      .filter(p -> p.getId() == id)
      .findFirst()
      .orElseThrow(() -> new PetNotFoundException(id));
  }//findPetById()
  public Adopter findAdopterById(int id) {
    return adopters.stream()
      .filter(a -> a.getId() == id)
      .findFirst()
      .orElse(null);
  }//findAdopterById()
  
  public void viewAvailablePets() {
    pets.stream()
            .filter(Pet::isAvailable)
            .forEach(System.out::println);
  }//listAvailablePets()
  public void viewFilteredPets(String species, String breed) {
    pets.stream()
            .filter(Pet::isAvailable)
            .filter(p -> p.getSpecies().equalsIgnoreCase(species))
            .filter(p -> p.getBreed().equalsIgnoreCase(breed))
            .forEach(System.out::println);
  }//searchPet()
  
  public void adoptPet(int petId, int adopterId) throws Exception {
    Pet pet = findPetById(petId);
    Adopter adopter = findAdopterById(adopterId);
    
    if (pet.isAvailable()) {
      pet.adopt();
      adopter.adoptPet(pet);
      System.out.println(adopter.getInfo() + " adopted " + pet);
    } else {
      throw new AlreadyAdoptedException(petId);
    }//if-else
  }//adoptPet()
  
  public void saveData(String filename) throws IOException {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
      oos.writeObject(pets);
      oos.writeObject(adopters);
    }//try
  }//saveData()
  public void loadData(String filename) throws IOException, ClassNotFoundException {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
      pets = (List<Pet>) ois.readObject();
      adopters = (List<Adopter>) ois.readObject();
    }//try
  }//loadData()
  
}//PetAdoptionCenter

