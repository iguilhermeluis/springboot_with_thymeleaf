package br.com.guilherme.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.guilherme.dominio.Fabricante;
import br.com.guilherme.repository.FabricanteRepository;

@Service
public class FabricanteService {
	
	@Autowired
	private FabricanteRepository fabricanteRepository;
	
	public Fabricante save(Fabricante fabricante) {
		return fabricanteRepository.save(fabricante);
	}
	
	public List<Fabricante> saveAll(List<Fabricante> fabricantes) {
		return fabricanteRepository.saveAll(fabricantes);
	}
	
	public List<Fabricante> listaFabricantes(){
		return fabricanteRepository.findAll();
	}
	

	public Fabricante inserir(Fabricante fabricante) {
		fabricante.setId(null);
		return fabricanteRepository.save(fabricante);
	}
	
	public Fabricante busca(Integer id) {
		Optional<Fabricante> objFabricante = fabricanteRepository.findById(id);
		return objFabricante.orElseThrow(() -> new ObjectNotFoundException("Fabricante não encontrada. Id: " + id));	
	}
	
	public void excluir(Integer id) {
		
		fabricanteRepository.deleteById(id);
	}
	
	public Fabricante alterar(Fabricante fabricante) {
		Fabricante fabricanteEncontrada = busca(fabricante.getId());
		fabricanteEncontrada.setNome(fabricante.getNome());
		return fabricanteRepository.save(fabricanteEncontrada);
		
	}
	
}
