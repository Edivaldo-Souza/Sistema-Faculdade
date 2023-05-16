package br.edu.ufersa.SistemaFaculdadeWeb.api.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CriarTurmaDTO {
	@NotBlank(message="O local não deve estar vazio")
	private String local;
	@NotBlank(message="O horario não deve estar vazio")
	private String horario;
	@NotBlank(message="O id da disciplina não deve estar vazio")
	private String disCod;
	
	private String profCpf;
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
	public String getDisCod() {
		return disCod;
	}
	public void setDisCod(String disCod) {
		this.disCod = disCod;
	}
	public String getProfCpf() {
		return profCpf;
	}
	public void setProfCpf(String profCpf) {
		this.profCpf = profCpf;
	}
	
}
