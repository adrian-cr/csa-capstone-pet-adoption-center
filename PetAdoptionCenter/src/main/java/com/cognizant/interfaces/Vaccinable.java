package com.cognizant.interfaces;

import java.util.Set;

public interface Vaccinable {
  void vaccinate(String vaccine, Set<String> validVaccines);
}
