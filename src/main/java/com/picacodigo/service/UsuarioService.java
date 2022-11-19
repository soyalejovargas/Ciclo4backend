package com.picacodigo.service;

import com.picacodigo.model.Usuario;
import com.picacodigo.repository.UsuarioRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

	@Autowired
    UsuarioRepository usuarioRepository;

	public List<Usuario> getAllUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        usuarios.sort(Comparator.comparing(Usuario::get_id));
        return usuarios;
    }

    public Optional <Usuario> getUsuarioByID(String id){
        return usuarioRepository.findById(id); //{_id:ObjectId("636c6135333faa8132d4ffb3")}
    }

    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public String deleteUsuario(String id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return "Eliminado";
        }else{
            return "No eliminado";
        }
    }

    public void deleteAllUsuarios(){
        usuarioRepository.deleteAll();
    }
	
}
