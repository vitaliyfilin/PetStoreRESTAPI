package com.example.petstore.controller;

import com.example.petstore.model.Pet;
import com.example.petstore.model.Purchase;
import com.example.petstore.model.User;
import com.example.petstore.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class PurchaseController {
    @Autowired
    PurchaseRepository purchaseRepository;


    @PostMapping("/postPurchase")
    public String postPurchase(User user, List<Pet> petList) {
        Purchase purchase = new Purchase();
        List<Pet> petList1 = new ArrayList<>();
        purchase.setUser(user);
        purchase.setPetList(petList1);
        purchase.setDate(new Date());
        purchaseRepository.save(purchase);
        return "Success";
    }
    @GetMapping("/getAllPurchases")
    public List<Purchase> getAllPurchases() throws Exception {
        List<Purchase> purchaseList = new ArrayList<>();
        purchaseList.addAll(purchaseRepository.findAll());
        return purchaseList;

    }
}
