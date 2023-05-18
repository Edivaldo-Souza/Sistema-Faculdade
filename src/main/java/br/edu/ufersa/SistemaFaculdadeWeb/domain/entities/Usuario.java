package br.edu.ufersa.SistemaFaculdadeWeb.domain.entities;

import java.util.UUID;

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
	private String nome;
	private String senha;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private int permissao;
	private UUID uuid;
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
	public int getPermissao() {
		return permissao;
	}
	public void setPermissao(int permissao) {
		this.permissao = permissao;
	}
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

}
