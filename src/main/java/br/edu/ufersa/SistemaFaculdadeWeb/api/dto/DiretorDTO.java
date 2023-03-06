package br.edu.ufersa.SistemaFaculdadeWeb.api.dto;

import java.util.UUID;

import br.edu.ufersa.SistemaFaculdadeWeb.api.domain.entities.Autorizacao;

public class DiretorDTO {
	private String nome;
	private UUID uuid;
	private final Autorizacao permissao = Autorizacao.DIR;
	private String senha;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
