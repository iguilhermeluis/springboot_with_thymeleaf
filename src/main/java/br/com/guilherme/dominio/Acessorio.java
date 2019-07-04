package br.com.guilherme.dominio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity /* TRANFORMO A CLASSE EM UMA ENTIDADE PARA BD */
public class Acessorio implements Serializable {

	private static final long serialVersionUID = -1449367915375296271L; 
	 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) /* COMO SE FOSSE UM AUTO_INCREMENT  */
	private Integer id;
	private String nome;
	private Float preco;
	
	@ManyToMany(mappedBy = "acessorios") /* CRIA UMA TERNARIA LIGANDO CARRO E ACESSORIOS  */
	private List<Carro> carros;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Carro> getCarros() {
		return carros;
	}
	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}
	public Float getPreco() {
		return preco;
	}
	public void setPreco(Float preco) {
		this.preco = preco;
	}
	
	
	
	

}
