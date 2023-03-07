package br.edu.ufersa.SistemaFaculdadeWeb.api.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AtualizarTurmaDTO {
	@NotBlank(message="O local não deve estar vazio")
	private String local;
	@Size(min=8,max=20,message="O horario não deve estar vazio")
	private String horario;
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


}
