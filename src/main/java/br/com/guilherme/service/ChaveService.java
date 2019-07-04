package br.com.guilherme.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.guilherme.dominio.Chave;
import br.com.guilherme.repository.ChaveRepository;


@Service
public class ChaveService {
	
	
	
	@Autowired
	private ChaveRepository chaveRepository;
	
	
	public Chave save(Chave chave) {
		return chaveRepository.save(chave);
	}
	
	public List<Chave> saveAll(List<Chave> chaves){
		return chaveRepository.saveAll(chaves);
	}
	
	public List<Chave> listaChaves(){
		return chaveRepository.findAll();
	}
	
	public Chave inserir(Chave chave) {
		chave.setId(null);
		return chaveRepository.save(chave);
	}
	
	public Chave busca(Integer id) {
		Optional<Chave> objChave = chaveRepository.findById(id);
		return objChave.orElseThrow(() -> new ObjectNotFoundException("Chave não encontrada. Id: " + id));	
	}
	
	public void excluir(Integer id) {
		
		chaveRepository.deleteById(id);
	}
	
	public Chave alterar(Chave chave) {
		Chave chaveEncontrada = busca(chave.getId());
		chaveEncontrada.setCodigo(chave.getCodigo());
		return chaveRepository.save(chaveEncontrada);
		
	}
	
	
	
}
