package br.edu.ufersa.SistemaFaculdadeWeb.api.dto;

import java.util.UUID;

public class TurmaDTO {
	
	private UUID uuid;
	private String local;
	private String horario;
	private boolean status;
	private String disc_cod;
	private String prof_cpf;

	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
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
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getDisc_cod() {
		return disc_cod;
	}
	public void setDisc_cod(String disc_cod) {
		this.disc_cod = disc_cod;
	}
	public String getProf_cpf() {
		return prof_cpf;
	}
	public void setProf_cpf(String prof_cpf) {
		this.prof_cpf = prof_cpf;
	}
	

		
}