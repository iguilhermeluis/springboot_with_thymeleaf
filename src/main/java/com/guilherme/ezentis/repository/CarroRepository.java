package com.guilherme.ezentis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guilherme.ezentis.model.Carro;



@Repository
public interface CarroRepository extends JpaRepository<Carro, Integer>{

}
