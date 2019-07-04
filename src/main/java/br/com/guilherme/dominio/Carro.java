package br.com.guilherme.dominio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;


@Entity /* TRANSFORMA A CLASSE EM ENTIDADE DE BD  */
public class Carro implements Serializable{

	private static final long serialVersionUID = -4528117813267091640L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer chassi;
	private String modelo;
	
	@Transient
	private Integer idTempFabricante;
	
	@Transient
	private Integer idTempChave;
	
	@Transient
	private Integer idTempDocumento;
	
	@Transient
	private Integer idTempAcessorio;
	
	public Integer getIdTempFabricante() {
		return idTempFabricante;
	}
	public void setIdTempFabricante(Integer idTempFabricante) {
		this.idTempFabricante = idTempFabricante;
	}
	public Integer getIdTempChave() {
		return idTempChave;
	}
	public void setIdTempChave(Integer idTempChave) {
		this.idTempChave = idTempChave;
	}
	public Integer getIdTempDocumento() {
		return idTempDocumento;
	}
	public void setIdTempDocumento(Integer idTempDocumento) {
		this.idTempDocumento = idTempDocumento;
	}
	public Integer getIdTempAcessorio() {
		return idTempAcessorio;
	}
	public void setIdTempAcessorio(Integer idTempAcessorio) {
		this.idTempAcessorio = idTempAcessorio;
	}
	/*
	 Um dos lados precisará ser o dono do relacionamento e ser responsável por atualizar uma coluna com uma chave estrangeira.
	 */
	@OneToOne /* CRIA UMA RELACAO 1 PARA 1*/
	@JoinColumn(name = "chave_id", referencedColumnName = "id") /*cria um campo chamado chave_id e vai ser referenciado do chave.id*/
	private Chave chave;
	
	@ManyToOne
	@JoinColumn(name = "fabricante_id", referencedColumnName = "id")
	private Fabricante fabricante;
	
	@ManyToMany
	@JoinTable(
		name = "carro_acessorio",
		joinColumns = @JoinColumn(name = "carro_id"),
		inverseJoinColumns = @JoinColumn(name = "acessorio_id"))
	private List<Acessorio> acessorios;

	public Integer getChassi() {
		return chassi;
	}
	public void setChassi(Integer chassi) {
		this.chassi = chassi;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Chave getChave() {
		return chave;
	}
	public void setChave(Chave chave) {
		this.chave = chave;
	}
	public Fabricante getFabricante() {
		return fabricante;
	}
	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
	public List<Acessorio> getAcessorios() {
		return acessorios;
	}
	public void setAcessorios(List<Acessorio> acessorios) {
		this.acessorios = acessorios;
	}
	@Override
	public String toString() {
		return "Carro [chassi=" + chassi + ", modelo=" + modelo + ", idTempFabricante=" + idTempFabricante
				+ ", idTempChave=" + idTempChave + ", idTempDocumento=" + idTempDocumento + ", idTempAcessorio="
				+ idTempAcessorio + ", chave=" + chave + ", fabricante=" + fabricante + ", acessorios=" + acessorios
				+ "]";
	}
	
}
