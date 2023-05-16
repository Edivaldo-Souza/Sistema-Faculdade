package br.edu.ufersa.SistemaFaculdadeWeb.api.dto;

import java.util.UUID;

public class TurmaDTO {
	
	private UUID uuid;
	private String local;
	private String horario;
	private boolean status;
	private String discCod;
	private String profCpf;

	public String getDiscCod() {
		return discCod;
	}
	public void setDiscCod(String discCod) {
		this.discCod = discCod;
	}
	public String getProfCpf() {
		return profCpf;
	}
	public void setProfCpf(String profCpf) {
		this.profCpf = profCpf;
	}
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

	

		
}