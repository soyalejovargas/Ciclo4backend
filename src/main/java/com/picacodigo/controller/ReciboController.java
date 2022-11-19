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

import com.picacodigo.model.Recibo;
import com.picacodigo.service.ReciboService;

@RestController
@RequestMapping("/api/recibos")
public class ReciboController {
	
	@Autowired
	ReciboService reciboService;
	
	@GetMapping()
    public List<Recibo> getAllRecibos(){
        return reciboService.getAllRecibos();
    }

    @GetMapping(path = "/{id}")
    public Optional<Recibo> getReciboById(@PathVariable("id") String id){
        return reciboService.getReciboByID(id);
    }


    @PostMapping()
    public Recibo saveRecibo(@RequestBody Recibo recibo){
        return reciboService.saveRecibo(recibo);
    }

    @DeleteMapping(path = "/{identificador}")
    public String deleteReciboById(@PathVariable("identificador") String id){
        return reciboService.deleteRecibo(id);   
    }

    @DeleteMapping()
    public void eliminarTodoRecibo(){
        reciboService.deleteAllRecibos();
    }
}
