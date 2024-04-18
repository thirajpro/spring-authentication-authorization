package com.springSecurity.Spring.Security.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MyUserRepository extends JpaRepository<MyUser,Long> {
    Optional<MyUser> findByUserName(String userName);



}
