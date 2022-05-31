package com.generation.blogpessoal.blogpessoal1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.blogpessoal.blogpessoal1.model.Postagem;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long>
{
 
}
