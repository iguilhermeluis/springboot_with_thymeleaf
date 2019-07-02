package com.guilherme.ezentis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guilherme.ezentis.model.Documento;

@Repository
public interface DocumentoRepository  extends JpaRepository<Documento, Integer>{

}
