package br.edu.ufersa.SistemaFaculdadeWeb.api.domain.entities;

import java.util.UUID;

public class Diretor {
	private final Autorizacao permissao = Autorizacao.DIR;
	private String nome;
	private String senha;
	private String endereco;
	private long id;
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
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
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
