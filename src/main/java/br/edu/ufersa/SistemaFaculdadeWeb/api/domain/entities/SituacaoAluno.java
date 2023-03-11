package br.edu.ufersa.SistemaFaculdadeWeb.api.domain.entities;

public enum SituacaoAluno {
	APROVADO(0),
	RECUPERACAO(1),
	REPROVADO(2),
	INDEFINIDO(3);
	private int estado;
	SituacaoAluno(int i){
		this.estado = i;
	}
}
