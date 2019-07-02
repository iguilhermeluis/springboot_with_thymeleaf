package com.guilherme.ezentis.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilherme.ezentis.model.Carro;
import com.guilherme.ezentis.repository.CarroRepository;

@Service
public class CarroService {
	
	@Autowired
	CarroRepository repoCarro;

	public Carro cadastrar(Carro carro) {
		carro.setId(null);
		return repoCarro.save(carro);
	}
	
	public Carro buscar(Integer id) throws ObjectNotFoundException{
		Optional<Carro> objCarro = repoCarro.findById(id);
		return objCarro.orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado! id: " + id + ", Tipo: " + Carro.class.getName(), null));
	}
	
	public Carro alterar(Carro objCarro) throws ObjectNotFoundException{
		Carro objCarroEncontrado = buscar(objCarro.getId());
		objCarroEncontrado.setNome(objCarro.getNome());
		objCarroEncontrado.setPreco(objCarro.getPreco());
		objCarroEncontrado.setAno(objCarro.getAno());
		
		return repoCarro.save(objCarroEncontrado);
	}
	
	public void excluir(Integer id) {
		repoCarro.deleteById(id);
	}
	
	public List<Carro> listaCarros(){
		return repoCarro.findAll();
	}

}
