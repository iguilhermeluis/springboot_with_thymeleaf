package com.guilherme.ezentis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guilherme.ezentis.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	User findByEmailAndPassword(String email, String senha);
	
}
