package com.guilherme.ezentis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.guilherme.ezentis.model.Chave;

@Repository
public interface ChaveRepository extends JpaRepository<Chave, Integer>{

}
