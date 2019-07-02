package com.guilherme.ezentis.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilherme.ezentis.model.Acessorio;
import com.guilherme.ezentis.repository.AcessorioRepository;


@Service
public class AcessorioService {
	
	@Autowired
	AcessorioRepository repoAcessorio;
	
	public Acessorio cadastrar(Acessorio acessorio) {
		acessorio.setId(null);
		return repoAcessorio.save(acessorio);
	}
	
	public Acessorio buscar(Integer id) throws ObjectNotFoundException{
		Optional<Acessorio> objAcessorio = repoAcessorio.findById(id);
		return objAcessorio.orElseThrow(() -> new ObjectNotFoundException("Acessorio não encontrado! id: " + id + ", Tipo: " + Acessorio.class.getName(), null));
	}
	
	public Acessorio alterar(Acessorio objAcessorio) throws ObjectNotFoundException{
		Acessorio objAcessorioEncontrado = buscar(objAcessorio.getId());
		objAcessorioEncontrado.setDescricao(objAcessorio.getDescricao());		
		return repoAcessorio.save(objAcessorioEncontrado);
	}
	
	public void excluir(Integer id) {
		repoAcessorio.deleteById(id);
	}
	
	public List<Acessorio> listaUsuario(){
		return repoAcessorio.findAll();
	}

}