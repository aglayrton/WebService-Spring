package com.example.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.webservice.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
}
