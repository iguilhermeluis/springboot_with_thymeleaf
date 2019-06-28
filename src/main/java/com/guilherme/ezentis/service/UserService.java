package com.guilherme.ezentis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilherme.ezentis.model.User;
import com.guilherme.ezentis.repository.UserRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service 
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	/*
	 public User login (User objUser) {
		//estou colocando um objeto novo então o id precisa ser null
		objUser.setId(null);
		return UserRepository.save(objUser);
	}
	
	public User logout (User objUser) {
		//estou colocando um objeto novo então o id precisa ser null
		objUser.setId(null);
		return UserRepository.save(objUser);
	}
	*/
	
	public User signup (User objUser) {
		//estou colocando um objeto novo então o id precisa ser null
		objUser.setId(null);
		return userRepository.save(objUser);
	}
	
	public void delete (Integer idUser) {
		//estou colocando um objeto novo então o id precisa ser null
		userRepository.deleteById(idUser);
	}
	
	public User update(User objUser) throws ObjectNotFoundException {
		User objUserBD = searchUser(objUser.getId());
		objUserBD.setName(objUser.getName());
		objUserBD.setEmail(objUser.getEmail());
		return userRepository.save(objUserBD);
	
	}
	
	public User searchUser (Integer id) throws ObjectNotFoundException {
		Optional<User> objUserBD = userRepository.findById(id);
		return objUserBD.orElseThrow(() -> new ObjectNotFoundException(
				"Usuario não encontrada ! Id: " + id +", Tipo " + User.class.getName()));
	}
	
	public User signin (User objUser) {
		//estou colocando um objeto novo então o id precisa ser null
		objUser.setId(null);
		return userRepository.findByEmailAndPassword(objUser.getEmail(), objUser.getPassword());
	}
	
	public List<User> listUsers(){
		return userRepository.findAll();
		
	}
}
