package com.guilherme.ezentis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guilherme.ezentis.model.Fabricante;

@Repository
public interface FabricanteRepository extends JpaRepository<Fabricante, Integer>{

}
