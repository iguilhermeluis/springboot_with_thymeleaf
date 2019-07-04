package br.com.guilherme.init;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.guilherme.dominio.Acessorio;
import br.com.guilherme.dominio.Carro;
import br.com.guilherme.dominio.Chave;
import br.com.guilherme.dominio.Documento;
import br.com.guilherme.dominio.Fabricante;
import br.com.guilherme.repository.AcessorioRepository;
import br.com.guilherme.repository.CarroRepository;
import br.com.guilherme.repository.ChaveRepository;
import br.com.guilherme.repository.DocumentoRepository;
import br.com.guilherme.repository.FabricanteRepository;

@Component
public class InitDados implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private FabricanteRepository fabricanteRepo;
	
	
	@Autowired
	private AcessorioRepository acessorioRepo;
	
	@Autowired
	private DocumentoRepository documentoRepo;
	
	@Autowired
	private ChaveRepository chaveRepo;
	
	@Autowired
	private CarroRepository carroRepo;
	
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		
		Fabricante fb1 = new Fabricante();
		fb1.setNome("Nissan");
		
		Fabricante fb2 = new Fabricante();
		fb2.setNome("Renault");
		
		fabricanteRepo.saveAll(Arrays.asList(fb1, fb2));
		
		Documento doc1 = new Documento();
		doc1.setNumero("ABC-1234");
		
		Documento doc2 = new Documento();
		doc2.setNumero("SDS-4123");
		
		Documento doc3 = new Documento();
		doc3.setNumero("DSA-2312");
		
		documentoRepo.saveAll(Arrays.asList(doc1,doc2,doc3));
		Acessorio ace1 = new Acessorio();
		ace1.setNome("camera de ré");
		ace1.setPreco(new Float(3212));
		
		Acessorio ace2 = new Acessorio();
		ace2.setNome("ar");
		ace2.setPreco(new Float(3212));
		
		acessorioRepo.saveAll(Arrays.asList(ace2, ace1));
		
		Chave cha1 = new Chave();
		cha1.setCodigo("1221");
		
		Chave cha2 = new Chave();
		cha2.setCodigo("312");

		chaveRepo.saveAll(Arrays.asList(cha1, cha2));
		
		
		Carro car1 = new Carro();
		car1.setAcessorios(Arrays.asList(ace2, ace1));
		car1.setChave(cha1);
		car1.setFabricante(fb1);
		car1.setModelo("GOL");
		car1.setChassi(1234);
		carroRepo.saveAll(Arrays.asList(car1));
		
		Fabricante fabricante1 = new Fabricante();
		fabricante1.setNome("Honda");
		Fabricante fabricante2 = new Fabricante();
		fabricante2.setNome("Renault");
		fabricanteRepo.saveAll(Arrays.asList(fabricante1,fabricante2));
		
		Chave chave1 = new Chave();
		chave1.setCodigo("3234-7893458");
		Chave chave2 = new Chave();
		chave2.setCodigo("43-2783728379");
		Chave chave3 = new Chave();
		chave3.setCodigo("sr3243093");
		chaveRepo.saveAll(Arrays.asList(chave1,chave2,chave3));
		
		
		Carro carro1 = new Carro();
		carro1.setModelo("Civic");
		carro1.setFabricante(fabricante1);
		carro1.setChave(chave1);
		carro1.setAcessorios(Arrays.asList(ace1,ace2));
		
		Carro carro2 = new Carro();
		carro2.setModelo("Logan");
		carro2.setFabricante(fabricante2);
		carro2.setChave(chave2);
		carro2.setAcessorios(Arrays.asList(ace1));
		
		carroRepo.save(carro1);
		carroRepo.save(carro2);
		
	}

}
