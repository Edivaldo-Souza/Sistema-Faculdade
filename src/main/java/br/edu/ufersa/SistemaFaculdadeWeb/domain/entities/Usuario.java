package br.edu.ufersa.SistemaFaculdadeWeb.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="tb_usuarios")
public class Usuario {
	@Column(unique=true, nullable=false)
	private String nome;
	private String senha;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private Autorizacao permissao;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Autorizacao getPermissao() {
		return permissao;
	}
	public void setPermissao(Autorizacao permissao) {
		this.permissao = permissao;
	}

}
