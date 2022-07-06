package com.example.petstore.controller;

import com.example.petstore.model.Pet;
import com.example.petstore.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PetController {
    @Autowired
    PetRepository petRepository;

    @GetMapping("/getPetById")
    public Pet getPetById(Long id) throws Exception {
        return petRepository.findById(id).get();

    }

    @GetMapping("/getPetBySpecies")
    public List<Pet> getPetBySpecies(String species) throws Exception {
        return petRepository.findAllBySpecies(species);

    }

    @PostMapping("/postPet")
    public String postPet(@RequestBody Pet pet) {
        petRepository.save(pet);
        return "Success";
    }

    @GetMapping("/getAllPets")
    public List<Pet> getAllPets() throws Exception {
        List<Pet> petList = new ArrayList<>();
        petList.addAll(petRepository.findAll());
        return petList;

    }
    @DeleteMapping("/deletePet")
    @Transactional
    public String deletePet(Long id) {
        petRepository.deleteById(id);
        return "Success";
    }
}
