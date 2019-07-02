package com.guilherme.ezentis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilherme.ezentis.model.Chave;
import com.guilherme.ezentis.model.User;
import com.guilherme.ezentis.repository.ChaveRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ChaveService {
	@Autowired
	private ChaveRepository chaveRepo;
	
	public List<Chave> list(){
		return chaveRepo.findAll();
		
	}
	
	public Chave searchChave (Integer id) throws ObjectNotFoundException {
		Optional<Chave> objChaveDB = chaveRepo.findById(id);
		return objChaveDB.orElseThrow(() -> new ObjectNotFoundException(
				"Chave não encontrada ! Id: " + id +", Tipo " + User.class.getName()));
	}
	
	public void delete (Integer idChave) {
		chaveRepo.deleteById(idChave);
	}
	
	public Chave update(Chave objChave) throws ObjectNotFoundException {
		Chave objChaveDB = searchChave(objChave.getId());
		objChaveDB.setCarro(objChave.getCarro());
		objChaveDB.setCodigo(objChave.getCodigo());
		return chaveRepo.save(objChaveDB);
	
	}
	
	public Chave save (Chave objChave) {
		//estou colocando um objeto novo então o id precisa ser null
		objChave.setId(null);
		return chaveRepo.save(objChave);
	}
	
}
