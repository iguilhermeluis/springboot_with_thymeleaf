package com.guilherme.ezentis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilherme.ezentis.model.Fabricante;
import com.guilherme.ezentis.model.User;
import com.guilherme.ezentis.repository.FabricanteRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class FabricanteService {
	@Autowired
	private FabricanteRepository fabricanteRepo;
	
	public List<Fabricante> list(){
		return fabricanteRepo.findAll();
		
	}
	
	public Fabricante searchFabricante (Integer id) throws ObjectNotFoundException {
		Optional<Fabricante> objFabricanteDB = fabricanteRepo.findById(id);
		return objFabricanteDB.orElseThrow(() -> new ObjectNotFoundException(
				"fabricante não encontrada ! Id: " + id +", Tipo " + User.class.getName()));
	}
	
	public void delete (Integer idFabricante) {
		fabricanteRepo.deleteById(idFabricante);
	}
	
	public Fabricante update(Fabricante objFabricante) throws ObjectNotFoundException {
		Fabricante objFabricanteDB = searchFabricante(objFabricante.getIid());
		objFabricanteDB.setNome(objFabricante.getNome());
		return fabricanteRepo.save(objFabricanteDB);
	}
	
	public Fabricante save (Fabricante objFabricante) {
		objFabricante.setId(null);
		return fabricanteRepo.save(objFabricante);
	}
}
