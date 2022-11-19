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

import com.picacodigo.model.Inmueble;
import com.picacodigo.service.InmuebleService;

@RestController
@RequestMapping("/api/inmuebles")
public class InmuebleController {
	
	@Autowired
	private InmuebleService inmuebleService;
	
	@GetMapping()
    public List<Inmueble> getAllInmuebles(){
        return inmuebleService.getAllInmuebles();
    }

    @GetMapping(path = "/{id}")
    public Optional<Inmueble> getInmuebleById(@PathVariable("id") String id){
        return inmuebleService.getInmuebleByID(id);
    }


    @PostMapping()
    public Inmueble saveInmueble(@RequestBody Inmueble inmueble){
        return inmuebleService.saveInmueble(inmueble);
    }

    @DeleteMapping(path = "/{identificador}")
    public String deleteInmuebleById(@PathVariable("identificador") String id){
        return inmuebleService.deleteInmueble(id);   
    }

    @DeleteMapping()
    public void eliminarTodoInmueble(){
        inmuebleService.deleteAllInmuebles();
    }
}
