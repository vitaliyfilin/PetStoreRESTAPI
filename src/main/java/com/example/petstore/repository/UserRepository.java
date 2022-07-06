package com.example.petstore.repository;

import com.example.petstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User,Long> {
public User removeUserById (Long id);
public User deleteUserById (Long id);
    public User findUserByUsername (String username);
}
