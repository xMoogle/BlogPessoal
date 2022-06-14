package com.generation.blogpessoal.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.blogpessoal.model.Postagem;
import com.generation.blogpessoal.repository.PostagemRepository;




@RestController

@CrossOrigin(origins = "*")

@RequestMapping("/postagens")
public class PostagemController 
{
  @Autowired
  private PostagemRepository repository;
  
  @GetMapping
  public ResponseEntity<List<Postagem>> GetAll()
  {
	 return ResponseEntity.ok(repository.findAll());
  }
  
  @GetMapping("/{id}")
  public ResponseEntity<Postagem> GetAllId(@PathVariable Long id)
  {
	 return repository.findById(id)
			 .map(resposta -> ResponseEntity.ok(resposta))
	 .orElse(ResponseEntity.notFound().build());
  }
  
  @PostMapping
  public ResponseEntity<Postagem> biscoito(@Valid @RequestBody Postagem postagem)
  {
	  return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
  }
  
  @PutMapping
  public ResponseEntity<Postagem> putbiscoito(@Valid @RequestBody Postagem postagem)
  {
	  return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));
  }
  @GetMapping("/produto={keyword}")
	public ResponseEntity<List<Postagem>> getByTema(@PathVariable String keyword){
		return ResponseEntity.ok(repository.findAllByTextoContainingIgnoreCase(keyword));
  }
  @DeleteMapping("/{id}")
	void delete(@PathVariable Long id)
  {
		repository.deleteById(id);
  }
}
