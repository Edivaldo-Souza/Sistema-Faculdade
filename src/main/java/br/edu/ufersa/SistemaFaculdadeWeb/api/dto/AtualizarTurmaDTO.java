package br.edu.ufersa.SistemaFaculdadeWeb.api.dto;

import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AtualizarTurmaDTO {
	@NotBlank(message="O local não deve estar vazio")
	private String local;
	@NotBlank(message="O horario não deve estar vazio")
	private String horario;
	private UUID uuid;
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
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}


}
