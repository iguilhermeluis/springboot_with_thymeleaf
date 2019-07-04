package br.com.guilherme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.guilherme.dominio.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Integer>{

}
