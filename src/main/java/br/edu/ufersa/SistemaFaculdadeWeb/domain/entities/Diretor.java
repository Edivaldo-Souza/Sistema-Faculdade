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
@Table(name="tb_diretores")
public class Diretor {
	private final Autorizacao permissao = Autorizacao.DIR;
	private String nome;
	private String senha;
	@Id
	private long id;
	@Column(updatable=false, nullable=false, columnDefinition="VARCHAR(36)")
	@Type(type="uuid-char")
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
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public Autorizacao getPermissao() {
		return permissao;
	}
}
