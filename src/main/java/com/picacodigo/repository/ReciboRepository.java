package com.picacodigo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.picacodigo.model.Recibo;

public interface ReciboRepository extends MongoRepository<Recibo, String>{
	
}
