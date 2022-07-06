package com.example.petstore.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Entity
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    @OneToMany
    private List<Pet> petList;
    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Pet> getPetList() {
        return petList;
    }

    public void setPetList(List<Pet> petList) {
        this.petList = petList;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Purchase(Long id, User user, List<Pet> petList, Date date) {
        this.id = id;
        this.user = user;
        this.petList = petList;
        this.date = date;
    }
    public Purchase(User user, List<Pet> petList, Date date) {
        this.user = user;
        this.petList = petList;
        this.date = date;
    }

    public Purchase() {
    }
}

