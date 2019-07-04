package br.com.guilherme.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.guilherme.dominio.Acessorio;
import br.com.guilherme.repository.AcessorioRepository;

@Service
public class AcessorioService {

	@Autowired
	private AcessorioRepository acessorioRepository;
	
	public Acessorio save(Acessorio acessorio) {
		return acessorioRepository.save(acessorio);
	}
	
	public List<Acessorio> saveAll(List<Acessorio> acessorios){
		return acessorioRepository.saveAll(acessorios);
	}
	
	public List<Acessorio> listaAcessorios(){
		return acessorioRepository.findAll();
	}
	
	public Acessorio inserir(Acessorio acessorio) {
		acessorio.setId(null);
		return acessorioRepository.save(acessorio);
	}
	
	public Acessorio busca(Integer id) {
		Optional<Acessorio> objAcessorio = acessorioRepository.findById(id);
		return objAcessorio.orElseThrow(() -> new ObjectNotFoundException("Acessorio não encontrada. Id: " + id));	
	}
	
	public void excluir(Integer id) {
		
		acessorioRepository.deleteById(id);
	}
	
	public Acessorio alterar(Acessorio acessorio) {
		Acessorio acessorioEncontrada = busca(acessorio.getId());
		acessorioEncontrada.setNome(acessorio.getNome());
		return acessorioRepository.save(acessorioEncontrada);
		
	}
	
}
