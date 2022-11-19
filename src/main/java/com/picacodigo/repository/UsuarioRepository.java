package com.picacodigo.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.picacodigo.model.Usuario;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String>{

	//@Query(value="SELECT * FROM usuario as u WHERE u.password = :pass AND u.usuario = :user", nativeQuery = true)
	//public List<Usuario> loguearse(String pass, String user);
}
