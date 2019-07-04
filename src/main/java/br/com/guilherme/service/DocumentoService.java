package br.com.guilherme.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.guilherme.dominio.Documento;
import br.com.guilherme.repository.DocumentoRepository;

@Service
public class DocumentoService {

	@Autowired
	private DocumentoRepository documentoRepository;
	
	
	public Documento save(Documento documento) {
		return documentoRepository.save(documento);
	}
	
	public List<Documento> saveAll(List<Documento> documentos){
		return documentoRepository.saveAll(documentos);
	}
	
	public List<Documento> listaDocumentos(){
		return documentoRepository.findAll();
	}
	
	public Documento inserir(Documento documento) {
		documento.setId(null);
		return documentoRepository.save(documento);
	}
	
	public Documento busca(Integer id) {
		Optional<Documento> objDocumento = documentoRepository.findById(id);
		return objDocumento.orElseThrow(() -> new ObjectNotFoundException("Documento não encontrado. Id: " + id));	
	}
	
	public void excluir(Integer id) {
		
		documentoRepository.deleteById(id);
	}
	
	public Documento alterar(Documento documento) {
		Documento documentoEncontrado = busca(documento.getId());
		documentoEncontrado.setNumero(documento.getNumero());
		return documentoRepository.save(documentoEncontrado);
		
	}
	
	
}
