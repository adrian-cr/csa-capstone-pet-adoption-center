# Capstone Project: Pet Adoption Center

This Java project contains the structure and code
necessary to run a user-friendly management system for a pet
adoption center, which allows for seamless handling
of pet records and adoptions, while adequately
addressing runtime errors during requests.

The application can be run from its `AdoptionApp`
class, which showcases its core functionality
through a series of method calls and console
printings from its `main()` method.

Below are the project's key features:

## Model Classes
### `Adopter`
* **Fields:** `id`, `name`, `email`, and `adoptedPets`


* **Methods:** `adoptPet()`, `getInfo()`, and `getId()`.
### `Pet`
* **Fields:** `id`, `name`, `species`, `age`, `breed`, `isAdopted`, and `vaccinesGiven`.


* **Methods:** `getId()`, `getSpecies()`, `getBreed()`, `isAvailable()`, and `toString()`.


* **Subclasses:** `Dog` and `Cat`.

## Model Interfaces
### `Adoptable`
* **Abstract method:** `adopt()`.
### `Vaccinable`
* **Abstract method:** `vaccinate()`.

## Exceptions
* `AlreadyAdoptedException`: thrown when a `Pet`'s `isAdopted` field is `true`.


* `FailedVaccinationException`: thrown when...
  * a `Pet`'s `vaccinesGiven` set already contains the vaccine entered.
  * the vaccine to administer is not included in the class's `validVaccines` set.


* `PetNotFoundException`: thrown the `Pet` entered does not match any `Pet`s in `PetAdoptionCenter`'s `pets` list.

## Business Logic Class (`PetAdoptionCenter`)
* **Fields:** `pets` and `adopters`.


* **Methods:**
  * **Addition:** `addPet()` and `registerAdopter()`.
  * **Search:** `findPetById()` and `findAdopterById()`.
  * **Visualization:** `viewAvailablePets()` and `viewFilteredPets()`.
  * **Adoption:** `adoptPet()`.
  * **Data handling:** `saveData()` and `loadData()`.

## Main Class (`AdoptionApp`)
Its `main()` method provides the necessary
commands to...
* **add** a pet.
* **register** an adopter.
* **list** all available pets.
* **adopt** a pet
* **handle** request-related errors.