package com.picacodigo.service;

import com.picacodigo.model.Recibo;
import com.picacodigo.repository.PersonaRepository;
import com.picacodigo.repository.ReciboRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ReciboService {

	@Autowired
    ReciboRepository reciboRepository;

	public List<Recibo> getAllRecibos() {
        List<Recibo> recibos = reciboRepository.findAll();
        recibos.sort(Comparator.comparing(Recibo::get_id));
        return recibos;
    }

    public Optional <Recibo> getReciboByID(String id){
        return reciboRepository.findById(id); //{_id:ObjectId("636c6135333faa8132d4ffb3")}
    }

    public Recibo saveRecibo(Recibo recibo) {
        return reciboRepository.save(recibo);
    }

    public String deleteRecibo(String id) {
        if (reciboRepository.existsById(id)) {
            reciboRepository.deleteById(id);
            return "Eliminado";
        }else{
            return "No eliminado";
        }
    }

    public void deleteAllRecibos(){
        reciboRepository.deleteAll();
    }
	
	
}
