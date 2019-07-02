package com.guilherme.ezentis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guilherme.ezentis.model.Acessorio;

@Repository
public interface AcessorioRepository extends JpaRepository<Acessorio, Integer>{

}
