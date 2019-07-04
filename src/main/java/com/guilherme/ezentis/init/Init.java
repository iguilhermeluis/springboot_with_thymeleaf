package com.guilherme.ezentis.init;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.guilherme.ezentis.model.Acessorio;
import com.guilherme.ezentis.model.Carro;
import com.guilherme.ezentis.model.Chave;
import com.guilherme.ezentis.model.Documento;
import com.guilherme.ezentis.model.Fabricante;
import com.guilherme.ezentis.model.Profile;
import com.guilherme.ezentis.model.User;
import com.guilherme.ezentis.repository.AcessorioRepository;
import com.guilherme.ezentis.repository.CarroRepository;
import com.guilherme.ezentis.repository.ChaveRepository;
import com.guilherme.ezentis.repository.DocumentoRepository;
import com.guilherme.ezentis.repository.FabricanteRepository;
import com.guilherme.ezentis.repository.ProfileRepository;
import com.guilherme.ezentis.repository.UserRepository;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private ProfileRepository proRepo;
	
	@Autowired
	private UserRepository userRepo;
	
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
		// TODO Auto-generated method stub
		Profile pf1 = new Profile(); 
		pf1.setName("admin");
		pf1.setId(1);
		
		Profile pf2 = new Profile(); 
		pf2.setName("collaborator");
		pf2.setId(2);
		
		User user1 = new User();
		
		proRepo.saveAll(Arrays.asList(pf1, pf2));
		
		Fabricante fb1 = new Fabricante();
		fb1.setNome("Nissan");
		
		Fabricante fb2 = new Fabricante();
		fb2.setNome("Renault");
		
		fabricanteRepo.saveAll(Arrays.asList(fb1, fb2));
		
		Documento doc1 = new Documento();
		doc1.setPlaca("ABC-1234");
		
		Documento doc2 = new Documento();
		doc2.setPlaca("SDS-4123");
		
		documentoRepo.saveAll(Arrays.asList(doc1,doc2));
		
		Acessorio ace1 = new Acessorio();
		ace1.setDescricao("ar condicionado");
		
		Acessorio ace2 = new Acessorio();
		ace2.setDescricao("camera de ré");
		
		acessorioRepo.saveAll(Arrays.asList(ace2, ace1));
		
		Chave cha1 = new Chave();
		cha1.setCodigo(1545);
		
		Chave cha2 = new Chave();
		cha2.setCodigo(3245);

		chaveRepo.saveAll(Arrays.asList(cha1, cha2));
		
		
		Carro car1 = new Carro();
		car1.setAcessorios(Arrays.asList(ace2, ace1));
		car1.setAno("2014");
		car1.setDocumento(doc1);
		car1.setChave(cha1);
		car1.setFabricante(fb1);
		car1.setNome("CARRO ABC");
		car1.setPreco(1455);
		carroRepo.saveAll(Arrays.asList(car1));
		
	}

}
