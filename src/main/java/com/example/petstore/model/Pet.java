package com.example.petstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String species;
    private String name;
    private BigDecimal price;

    public Pet(Long id, String species, String name, BigDecimal price) {
        this.id = id;
        this.species = species;
        this.name = name;
        this.price = price;
    }

    public Pet() {
    }

    public Pet(String species, String name, BigDecimal price) {
        this.species = species;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", species='" + species + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
