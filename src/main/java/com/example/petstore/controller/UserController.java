package com.example.petstore.controller;

import com.example.petstore.model.Pet;
import com.example.petstore.model.User;
import com.example.petstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("/postUser")
    public String postUser(@RequestBody User user) {
        userRepository.save(user);

        return "Success";
    }
    @DeleteMapping("/deleteUser")
    @Transactional
    public String deleteUser(Long id) {
        userRepository.deleteById(id);
        return "Success";
    }
    @GetMapping("/getUserById")
    public User getUserById(Long id) throws Exception {
        return userRepository.findById(id).get();

    }
    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() throws Exception {
        List<User> userList = new ArrayList<>();
        userList.addAll(userRepository.findAll());
        return userList;

    }
}
