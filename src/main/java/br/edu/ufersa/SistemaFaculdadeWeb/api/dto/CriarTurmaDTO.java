package br.edu.ufersa.SistemaFaculdadeWeb.api.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CriarTurmaDTO {
	@NotBlank(message="O local não deve estar vazio")
	private String local;
	@NotBlank(message="O horario não deve estar vazio")
	private String horario;
	@NotBlank(message="O id da disciplina não deve estar vazio")
	private String disc_cod;
	
	private String prof_cpf;
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public String getProf_cpf() {
		return prof_cpf;
	}
	public void setProf_cpf(String prof_cpf) {
		this.prof_cpf = prof_cpf;
	}
	public String getDisc_cod() {
		return disc_cod;
	}
	public void setDisc_cod(String disc_cod) {
		this.disc_cod = disc_cod;
	}
}
