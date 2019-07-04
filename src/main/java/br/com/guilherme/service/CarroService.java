package br.com.guilherme.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.guilherme.dominio.Acessorio;
import br.com.guilherme.dominio.Carro;
import br.com.guilherme.dominio.Chave;
import br.com.guilherme.dominio.Fabricante;
import br.com.guilherme.repository.CarroRepository;

@Service
public class CarroService {

	@Autowired
	private CarroRepository carroRepository;

	@Autowired
	FabricanteService fabricanteService;

	@Autowired
	DocumentoService documentoService;
	
	@Autowired
	AcessorioService acessorioService;
	
	@Autowired
	ChaveService chaveService;
	
	
	public Carro save(Carro carro) {
		carro.setChassi(null);
		Fabricante fabricante = fabricanteService.busca(carro.getIdTempFabricante());
		Acessorio acessorio = acessorioService.busca(carro.getIdTempAcessorio());
		Chave chave = chaveService.busca(carro.getIdTempChave());
		
		carro.setFabricante(fabricante);
		carro.setAcessorios(Arrays.asList(acessorio));
		carro.setChave(chave);
		
		return carroRepository.save(carro);
	}
	
	public List<Carro> saveAll(List<Carro> carros){
		return carroRepository.saveAll(carros);
	}
	
	public List<Carro> listaCarros(){
		return carroRepository.findAll();
	}
	
	public Carro inserir(Carro carro) {
		carro.setChassi(null);
		return carroRepository.save(carro);
	}
	
	public Carro busca(Integer chassi) {
		Optional<Carro> objCarro = carroRepository.findById(chassi);
		return objCarro.orElseThrow(() -> new ObjectNotFoundException("Carro não encontrada. Id: " + chassi));	
	}
	
	public void excluir(Integer chassi) {
		Carro carroEncontrado = busca(chassi);
		carroRepository.delete(carroEncontrado);
	}
	
	public Carro alterar(Carro carro) {
		Carro carroEncontrado = busca(carro.getChassi());
		carroEncontrado.setIdTempAcessorio(carro.getIdTempChave());
		carroEncontrado.setIdTempDocumento(carro.getIdTempDocumento());
		carroEncontrado.setIdTempChave(carro.getIdTempChave());
		carroEncontrado.setModelo(carro.getModelo());
		
		/*Fabricante fabricante = fabricanteService.busca(carroEncontrado.getIdTempFabricante());
		System.out.println(fabricante.toString());
		Acessorio acessorio = acessorioService.busca(carroEncontrado.getIdTempAcessorio());
		Chave chave = chaveService.busca(carroEncontrado.getIdTempChave());
		
		carroEncontrado.setFabricante(fabricante);
		carroEncontrado.setAcessorios(Arrays.asList(acessorio));
		carroEncontrado.setChave(chave); */
		System.out.println(carroEncontrado.toString());
		return carroRepository.save(carroEncontrado);
		
	}
	
	
	
}
