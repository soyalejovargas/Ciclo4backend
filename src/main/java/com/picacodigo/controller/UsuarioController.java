package com.picacodigo.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.picacodigo.model.Usuario;
import com.picacodigo.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping()
    public List<Usuario> getAllUsuarios(){
        return usuarioService.getAllUsuarios();
    }

    @GetMapping(path = "/{id}")
    public Optional<Usuario> getUsuaurioById(@PathVariable("id") String id){
        return usuarioService.getUsuarioByID(id);
    }


    @PostMapping()
    public Usuario saveUsuario(@RequestBody Usuario usuario){
        return usuarioService.saveUsuario(usuario);
    }

    @DeleteMapping(path = "/{identificador}")
    public String deleteUsuarioById(@PathVariable("identificador") String id){
        return usuarioService.deleteUsuario(id);   
    }

    @DeleteMapping()
    public void eliminarTodoUsuario(){
        usuarioService.deleteAllUsuarios();
    }
}
