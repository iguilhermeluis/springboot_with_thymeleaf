package br.com.guilherme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.guilherme.dominio.Documento;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Integer>{

}
