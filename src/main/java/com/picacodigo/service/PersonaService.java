package com.picacodigo.service;

import com.picacodigo.model.Persona;
import com.picacodigo.repository.PersonaRepository;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {

	@Autowired
    PersonaRepository personaRepository;

	public List<Persona> getAllPersonas() {
        List<Persona> personas = personaRepository.findAll();
        personas.sort(Comparator.comparing(Persona::getNombre));
        return personas;
    }

    public Optional <Persona> getPersonaByID(String id){
        return personaRepository.findById(id); //{_id:ObjectId("636c6135333faa8132d4ffb3")}
    }

    public String savePersona(Persona persona) {
        persona.setNombre(persona.getNombre().toLowerCase());
        persona.setApellido(persona.getApellido().toLowerCase());
        if(persona.get_id() != null){
            if(personaRepository.existsById(persona.get_id())){
                personaRepository.save(persona);
            }
            return "RegistroActualizado";
        }
        else{
            personaRepository.save(persona);
            return "RegistroGuardado";
        }
    }

    public String deletePersona(String id) {
        if (personaRepository.existsById(id)) {
            personaRepository.deleteById(id);
            return "Eliminado";
        }else{
            return "No eliminado";
        }
    }

    public void deleteAllPersonas(){
        personaRepository.deleteAll();
    }
	
}
