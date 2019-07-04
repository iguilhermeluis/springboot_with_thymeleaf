package br.com.guilherme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.guilherme.dominio.Chave;

@Repository
public interface ChaveRepository extends JpaRepository<Chave, Integer>{

}
