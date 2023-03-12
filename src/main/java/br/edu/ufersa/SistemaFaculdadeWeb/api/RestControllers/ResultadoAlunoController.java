package br.edu.ufersa.SistemaFaculdadeWeb.api.RestControllers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.edu.ufersa.SistemaFaculdadeWeb.domain.entities.ResultadoAluno;
import br.edu.ufersa.SistemaFaculdadeWeb.domain.service.ResultadoAlunoService;
import br.edu.ufersa.SistemaFaculdadeWeb.api.dto.AtualizarResultadoAlunoDTO;
import br.edu.ufersa.SistemaFaculdadeWeb.api.dto.CriarResultadoAlunoDTO;
import br.edu.ufersa.SistemaFaculdadeWeb.api.dto.ResultadoAlunoDTO;

@RestController
@RequestMapping("api/resultado")
public class ResultadoAlunoController {
	@Autowired
	private ResultadoAlunoService service;
	@Autowired
	private ModelMapper mapper;
	
	@GetMapping
	public List<ResultadoAlunoDTO> getAll(){
		List<ResultadoAlunoDTO> results = new ArrayList<ResultadoAlunoDTO>();
		for(ResultadoAluno a: service.getAll()) {
			results.add(mapper.map(a, ResultadoAlunoDTO.class));
		}
		return results;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResultadoAlunoDTO> getAt(@PathVariable UUID id){
		ResultadoAlunoDTO dto = mapper.map(service.getAt(id), ResultadoAlunoDTO.class);
		if(dto!=null) {
			return new ResponseEntity<>(dto,HttpStatus.OK);
		}
		else return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<ResultadoAlunoDTO> post(@Valid @RequestBody CriarResultadoAlunoDTO dto){
		ResultadoAluno result = service.create(mapper.map(dto, ResultadoAluno.class));
		if(result!=null) {
			ResultadoAlunoDTO dto2 = mapper.map(result, ResultadoAlunoDTO.class);
			return new ResponseEntity<>(dto2,HttpStatus.CREATED);
		}
		else return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@PutMapping
	public ResponseEntity<ResultadoAlunoDTO> put(@Valid @RequestBody AtualizarResultadoAlunoDTO dto){
		ResultadoAluno result = service.update(mapper.map(dto, ResultadoAluno.class));
		if(result!=null) {
			ResultadoAlunoDTO dto2 = mapper.map(result, ResultadoAlunoDTO.class);
			return new ResponseEntity<>(dto2,HttpStatus.CREATED);
		}
		else return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@PatchMapping
	public ResponseEntity<ResultadoAlunoDTO> patch(@Valid @RequestBody AtualizarResultadoAlunoDTO dto){
		ResultadoAluno result = service.updatePatch(mapper.map(dto, ResultadoAluno.class));
		if(result!=null) {
			ResultadoAlunoDTO dto2 = mapper.map(result, ResultadoAlunoDTO.class);
			return new ResponseEntity<>(dto2,HttpStatus.CREATED);
		}
		else return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@DeleteMapping("/{id}")
	public String delete(@PathVariable UUID id){
		if(service.delete(id)) {
			return "ResultadoAluno deletado";
		}
		else {
			return "Nao foi possivel deletar";
		}
	}
}
