package com.picacodigo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Document("inmuebles")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Inmueble{
	    @Id
	    private String _id;
	    private String descripcion;
		private double coeficiente;
		@DBRef
	    private Persona propietario;
}
