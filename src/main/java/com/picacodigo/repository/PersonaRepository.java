package com.picacodigo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.picacodigo.model.Persona;

public interface PersonaRepository extends MongoRepository<Persona, String>{
	
}
