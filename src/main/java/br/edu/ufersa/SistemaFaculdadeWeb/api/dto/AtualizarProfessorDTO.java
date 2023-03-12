package br.edu.ufersa.SistemaFaculdadeWeb.api.dto;

import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AtualizarProfessorDTO {
	@NotBlank(message="O nome não deve estar vazio")
	private String nome;
	@NotBlank(message="O endereco não deve estar vazio")
	private String endereco;
	@NotBlank(message="A senha nao pode estar vazia")
	@Size(min=8,max=20,message="Seguinte parceiro. Senha entre 8 e 20 caracteres.")
	private String senha;
	private UUID uuid;
	
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
}