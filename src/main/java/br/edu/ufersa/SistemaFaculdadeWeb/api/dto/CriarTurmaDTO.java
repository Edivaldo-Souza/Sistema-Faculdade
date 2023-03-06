package br.edu.ufersa.SistemaFaculdadeWeb.api.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CriarTurmaDTO {
	@NotBlank(message="O local não deve estar vazio")
	private String local;
	@Size(min=8,max=20,message="O horario não deve estar vazio")
	private String horario;
	@NotBlank(message="O id da disciplina não deve estar vazio")
	private String discplina_id;
	private boolean status;
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
	public String getDiscplina_id() {
		return discplina_id;
	}
	public void setDiscplina_id(String discplina_id) {
		this.discplina_id = discplina_id;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

}
