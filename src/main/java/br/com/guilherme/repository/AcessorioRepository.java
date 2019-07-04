package br.com.guilherme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.guilherme.dominio.Acessorio;

@Repository
public interface AcessorioRepository extends JpaRepository<Acessorio, Integer>{

}
