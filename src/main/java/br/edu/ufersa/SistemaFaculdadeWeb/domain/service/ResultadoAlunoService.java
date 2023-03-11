package br.edu.ufersa.SistemaFaculdadeWeb.domain.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufersa.SistemaFaculdadeWeb.domain.entities.ResultadoAluno;
import br.edu.ufersa.SistemaFaculdadeWeb.domain.entities.SituacaoAluno;
import br.edu.ufersa.SistemaFaculdadeWeb.domain.repository.ResultadoRepository;

@Service
public class ResultadoAlunoService implements ServiceInterface<ResultadoAluno>{

	@Autowired
	ResultadoRepository repository;
	
	@Override
	public List<ResultadoAluno> getAll() {
		List<ResultadoAluno> results = repository.findAll(); 
		return results;
	}

	@Override
	public ResultadoAluno getAt(UUID id) {
		ResultadoAluno result = repository.findByUuid(id);
		return result;
	}

	@Override
	public ResultadoAluno create(ResultadoAluno obj) {
		obj.setUuid(UUID.randomUUID());
		obj.setFrequencia(100.f);
		obj.setNota1(0);
		obj.setNota2(0);
		obj.setNota3(0);
		obj.setMedia(0);
		obj.setStatus(SituacaoAluno.INDEFINIDO);
		return repository.save(obj);
	}

	@Override
	public ResultadoAluno update(ResultadoAluno obj) {
		ResultadoAluno dados = repository.findByUuid(obj.getUuid());
		obj.setTurma_id(dados.getTurma_id());
		return repository.save(obj);
	}

	@Override
	public ResultadoAluno updatePatch(ResultadoAluno obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(UUID id) {
		ResultadoAluno dados = repository.findByUuid(id);
		if(dados!=null) {
			repository.delete(dados);
			return true;
		}
		return false;
	}

}
