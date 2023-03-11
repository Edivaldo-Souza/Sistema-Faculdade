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

import br.edu.ufersa.SistemaFaculdadeWeb.domain.entities.Diretor;
import br.edu.ufersa.SistemaFaculdadeWeb.domain.service.DiretorService;
import br.edu.ufersa.SistemaFaculdadeWeb.api.dto.DiretorDTO;
import br.edu.ufersa.SistemaFaculdadeWeb.api.dto.AtualizarDiretorDTO;
import br.edu.ufersa.SistemaFaculdadeWeb.api.dto.CriarDiretorDTO;

@RestController
@RequestMapping("api/diretor")
public class DiretorController {
	@Autowired
	private DiretorService service;
	@Autowired
	private ModelMapper mapper; 
	
	@GetMapping
	public List<DiretorDTO> getAll(){
		List<DiretorDTO> Diretors = new ArrayList<DiretorDTO>();
		for(Diretor a: service.getAll()) {
			Diretors.add(mapper.map(a, DiretorDTO.class));
		}
		return Diretors;
	}
	
	@GetMapping("/id")
	public ResponseEntity<DiretorDTO> getAt(@PathVariable UUID id){
		Diretor Diretor = service.getAt(id);
		DiretorDTO dto = mapper.map(Diretor, DiretorDTO.class);
		if(dto!=null) {
			return new ResponseEntity<>(dto,HttpStatus.OK);
		}
		else return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<DiretorDTO> post(@Valid @RequestBody CriarDiretorDTO dto){
		Diretor Diretor = service.create(mapper.map(dto, Diretor.class));
		if(Diretor!=null) {
			DiretorDTO dto2 = mapper.map(Diretor, DiretorDTO.class);
			return new ResponseEntity<>(dto2,HttpStatus.CREATED);
		}
		else return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@PutMapping
	public ResponseEntity<DiretorDTO> put(@Valid @RequestBody AtualizarDiretorDTO dto){
		Diretor Diretor = service.update(mapper.map(dto, Diretor.class));
		if(Diretor!=null) {
			DiretorDTO dto2 = mapper.map(Diretor, DiretorDTO.class);
			return new ResponseEntity<>(dto2,HttpStatus.CREATED);
		}
		else return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@PatchMapping
	public ResponseEntity<DiretorDTO> patch(@Valid @RequestBody AtualizarDiretorDTO dto){
		Diretor Diretor = service.updatePatch(mapper.map(dto, Diretor.class));
		if(Diretor!=null) {
			DiretorDTO dto2 = mapper.map(Diretor, DiretorDTO.class);
			return new ResponseEntity<>(dto2,HttpStatus.CREATED);
		}
		else return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@DeleteMapping("/id")
	public String delete(UUID id){
		if(service.delete(id)) {
			return "Diretor deletada";
		}
		else {
			return "Nao foi possivel deletar";
		}
	}
}
