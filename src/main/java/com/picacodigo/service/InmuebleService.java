package com.picacodigo.service;

import com.picacodigo.model.Inmueble;
import com.picacodigo.repository.InmuebleRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InmuebleService {

	@Autowired
	InmuebleRepository inmuebleRepository;

	public List<Inmueble> getAllInmuebles() {
        List<Inmueble> inmuebles = inmuebleRepository.findAll();
        inmuebles.sort(Comparator.comparing(Inmueble::get_id));
        return inmuebles;
    }

    public Optional <Inmueble> getInmuebleByID(String id){
        return inmuebleRepository.findById(id); //{_id:ObjectId("636c6135333faa8132d4ffb3")}
    }

    public Inmueble saveInmueble(Inmueble inmueble) {
        inmueble.setDescripcion(inmueble.getDescripcion().toLowerCase());
        return inmuebleRepository.save(inmueble);
    }

    public String deleteInmueble(String id) {
        if (inmuebleRepository.existsById(id)) {
            inmuebleRepository.deleteById(id);
            return "Eliminado";
        }else{
            return "No eliminado";
        }
    }

    public void deleteAllInmuebles(){
        inmuebleRepository.deleteAll();
    }
}
