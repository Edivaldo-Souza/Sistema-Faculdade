package br.edu.ufersa.SistemaFaculdadeWeb.api.domain.entities;

public enum Autorizacao {
	ALUNO(0),
	PROF(1),
	DIR(2);
	private int estado;
	Autorizacao(int i){
		this.estado = i;
	}
}
