package com.guilherme.ezentis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilherme.ezentis.model.Documento;
import com.guilherme.ezentis.model.User;
import com.guilherme.ezentis.repository.DocumentoRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class DocumentoService {
	@Autowired
	private DocumentoRepository documentoRepo;
	
	public List<Documento> list(){
		return documentoRepo.findAll();
		
	}
	
	public Documento searchDocumento (Integer id) throws ObjectNotFoundException {
		Optional<Documento> objDocumentoDB = documentoRepo.findById(id);
		return objDocumentoDB.orElseThrow(() -> new ObjectNotFoundException(
				"Documento não encontrada ! Id: " + id +", Tipo " + User.class.getName()));
	}
	
	public void delete (Integer idDocumento) {
		documentoRepo.deleteById(idDocumento);
	}
	
	public Documento update(Documento objDocumento) throws ObjectNotFoundException {
		Documento objDocumentoDB = searchDocumento(objDocumento.getId());
		objDocumentoDB.setCarro(objDocumentoDB.getCarro());
		objDocumentoDB.setPlaca(objDocumento.getPlaca());
		return documentoRepo.save(objDocumento);
	}
	
	public Documento save (Documento objDocumento) {
		objDocumento.setId(null);
		return documentoRepo.save(objDocumento);
	}
	
}
