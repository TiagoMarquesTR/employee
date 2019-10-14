package br.com.tr.employee.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.tr.employee.controller.dto.RubricDto;
import br.com.tr.employee.model.Rubric;
import br.com.tr.employee.repository.RubricRepository;

@RequestMapping("/v1/rubric")
@RestController
public class RubricController {
	
	@Autowired
	RubricRepository rubricRepository;
	
	@GetMapping
	public List<RubricDto> get() {
		List<Rubric> rubrics = rubricRepository.findAll();
		return RubricDto.convert(rubrics);
	}
		
	@GetMapping("/{id}")
	public ResponseEntity<RubricDto> get(@PathVariable UUID id) {
		Optional<Rubric> rubric = rubricRepository.findById(id);
		
		if(rubric.isPresent()) {
			return ResponseEntity.ok(new RubricDto(rubric.get()));
		}
	
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<RubricDto> add(@RequestBody @Valid RubricDto rubricDto, UriComponentsBuilder uriBuilder) {
		Rubric rubric = new Rubric(rubricDto);
		rubricRepository.save(rubric);
		
		URI uri = uriBuilder.path("/vi/rubric/{id}").buildAndExpand(rubric.getRubricId()).toUri();
		
		return ResponseEntity.created(uri).body(new RubricDto(rubric));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remove(@PathVariable UUID id) {
		Optional<Rubric> rubric = rubricRepository.findById(id);
		
		if(rubric.isPresent()) {
			rubricRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
				
		return ResponseEntity.notFound().build();		
	}

}
