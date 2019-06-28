package com.guilherme.ezentis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilherme.ezentis.model.Profile;
import com.guilherme.ezentis.model.User;
import com.guilherme.ezentis.repository.ProfileRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ProfileService {

	@Autowired
	private ProfileRepository proRepo;
	
	public List<Profile> listProfiles(){
		return proRepo.findAll();
		
	}
	public Profile searchProfile (Integer id) throws ObjectNotFoundException {
		Optional<Profile> objProfileDB = proRepo.findById(id);
		return objProfileDB.orElseThrow(() -> new ObjectNotFoundException(
				"Profile não encontrada ! Id: " + id +", Tipo " + User.class.getName()));
	}
	

	public void delete (Integer idProfile) {
		//estou colocando um objeto novo então o id precisa ser null
		proRepo.deleteById(idProfile);
	}
	
	public Profile update(Profile objProfile) throws ObjectNotFoundException {
		Profile objProfileDB = searchProfile(objProfile.getId());
		objProfileDB.setName(objProfile.getName());
		return proRepo.save(objProfileDB);
	
	}
	
	public Profile save (Profile objProfile) {
		//estou colocando um objeto novo então o id precisa ser null
		objProfile.setId(null);
		return proRepo.save(objProfile);
	}
	
	

	
}
