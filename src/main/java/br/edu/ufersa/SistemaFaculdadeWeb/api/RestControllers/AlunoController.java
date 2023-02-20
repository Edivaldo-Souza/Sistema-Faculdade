package br.edu.ufersa.SistemaFaculdadeWeb.api.RestControllers;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufersa.SistemaFaculdadeWeb.api.domain.service.AlunoService;
import br.edu.ufersa.SistemaFaculdadeWeb.api.dto.AlunoDTO;

@RestController
@RequestMapping("api/aluno")
public class AlunoController {
	@Autowired
	private AlunoService service;
	@Autowired
	private ModelMapper mapper; 
	
	@GetMapping
	public List<AlunoDTO> getAll(){
		return null;
	}
	
	@GetMapping("/id")
	public ResponseEntity<AlunoDTO> getAt(UUID id){
		return null;
	}
	
	@PostMapping
	public ResponseEntity<AlunoDTO> post(){
		return null;
	}
	@PutMapping
	public ResponseEntity<AlunoDTO> put(){
		return null;
	}
	@PatchMapping
	public ResponseEntity<AlunoDTO> patch(UUID id){
		return null;
	}
	@DeleteMapping("/id")
	public String delete(UUID id){
		return null;
	}
}
