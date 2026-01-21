package com.example.Module5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Module5.entities.User;

public interface UserRepository extends JpaRepository<User,Long>  {

}
