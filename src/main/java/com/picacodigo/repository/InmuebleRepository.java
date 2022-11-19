package com.picacodigo.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import com.picacodigo.model.Inmueble;

public interface InmuebleRepository extends MongoRepository<Inmueble, String>{
	
}
