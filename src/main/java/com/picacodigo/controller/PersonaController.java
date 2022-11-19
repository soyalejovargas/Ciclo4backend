package com.picacodigo.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.picacodigo.model.Persona;
import com.picacodigo.service.PersonaService;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {
	
	@Autowired
	private PersonaService personaService;
	
	@GetMapping()
    public List<Persona> getAllPersonas(){
        return personaService.getAllPersonas();
    }

    @GetMapping(path = "/{id}")
    public Optional<Persona> getPersonaById(@PathVariable("id") String id){
        return personaService.getPersonaByID(id);
    }


    @PostMapping()
    public String savePersona(@RequestBody Persona persona){
        return personaService.savePersona(persona);
    }

    @DeleteMapping(path = "/{identificador}")
    public String deletePersonaById(@PathVariable("identificador") String id){
        return personaService.deletePersona(id);   
    }

    @DeleteMapping()
    public void eliminarTodoPersona(){
        personaService.deleteAllPersonas();
    }

}
