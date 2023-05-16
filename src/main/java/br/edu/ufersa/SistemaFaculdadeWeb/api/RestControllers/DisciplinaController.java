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

import br.edu.ufersa.SistemaFaculdadeWeb.domain.entities.Disciplina;
import br.edu.ufersa.SistemaFaculdadeWeb.domain.service.DisciplinaService;
import br.edu.ufersa.SistemaFaculdadeWeb.api.dto.AtualizarDisciplinaDTO;
import br.edu.ufersa.SistemaFaculdadeWeb.api.dto.CriarDisciplinaDTO;
import br.edu.ufersa.SistemaFaculdadeWeb.api.dto.DisciplinaDTO;

@RestController
@RequestMapping("/api/disciplina")
public class DisciplinaController {
	@Autowired
	private DisciplinaService service;
	@Autowired
	private ModelMapper mapper; 
	
	@GetMapping
	public List<DisciplinaDTO> getAll(){
		List<DisciplinaDTO> disciplinas = new ArrayList<DisciplinaDTO>();
		for(Disciplina d: service.getAll()) {
			disciplinas.add(mapper.map(d, DisciplinaDTO.class));
		}
		return disciplinas;
	}
	
	@GetMapping("/{uuid}")
	public ResponseEntity<DisciplinaDTO> getAt(@PathVariable UUID uuid){
		Disciplina d = service.getAt(uuid);
		if(d != null) {
			DisciplinaDTO dto = mapper.map(d, DisciplinaDTO.class);
			return new ResponseEntity<>(dto, HttpStatus.FOUND);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/codigo/{cod}")
	public List<DisciplinaDTO> getByCodigo(@PathVariable String cod){
		List<DisciplinaDTO> disciplinas = new ArrayList<DisciplinaDTO>();
		DisciplinaDTO d = mapper.map(service.getByCodigo(cod),DisciplinaDTO.class);
		if(d != null) {
			disciplinas.add(d);
		}
		return disciplinas;
	}
	
	@PostMapping
	public ResponseEntity<DisciplinaDTO> adicionar(@Valid @RequestBody CriarDisciplinaDTO dto){
		Disciplina d = service.create(mapper.map(dto, Disciplina.class));
		if(d != null) {
			DisciplinaDTO dto2 = mapper.map(d, DisciplinaDTO.class);
			return new ResponseEntity<>(dto2, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@PutMapping
	public ResponseEntity<DisciplinaDTO> atualizar(@Valid @RequestBody AtualizarDisciplinaDTO dto){
		Disciplina d = service.update(mapper.map(dto, Disciplina.class));
		if(d != null) {
			DisciplinaDTO dto2 = mapper.map(d, DisciplinaDTO.class);
			return new ResponseEntity<>(dto2, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PatchMapping
	public ResponseEntity<DisciplinaDTO> atualizartudo(@Valid @RequestBody AtualizarDisciplinaDTO dto){
		Disciplina d = service.update(mapper.map(dto, Disciplina.class));
		if(d != null) {
			DisciplinaDTO dto2 = mapper.map(d, DisciplinaDTO.class);
			return new ResponseEntity<>(dto2, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@DeleteMapping("/{uuid}")
	public String delete(@PathVariable UUID uuid){
		if(service.delete(uuid)) {
			return "Registro dessa disciplina foi de Drake&Josh";
		}
		return "shiiiiii...";
	}

}