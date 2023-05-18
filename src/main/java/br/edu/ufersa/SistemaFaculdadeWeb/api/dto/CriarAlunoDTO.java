package br.edu.ufersa.SistemaFaculdadeWeb.api.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CriarAlunoDTO {
	@NotBlank(message="O nome não deve estar vazio")
	private String nome;
	@Size(min=8,message="A senha deve ter entre 8 a 20 digitos")
	private String senha;
	@NotBlank(message="O endereco não deve estar vazio")
	private String endereco;
	private String matricula;
	private String diretorCod;
	public String getDiretorCod() {
		return diretorCod;
	}
	public void setDiretorCod(String diretorCod) {
		this.diretorCod = diretorCod;
	}
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
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
}
