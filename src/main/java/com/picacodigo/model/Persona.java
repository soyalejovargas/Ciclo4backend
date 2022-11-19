package com.picacodigo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Document("personas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Persona{

    @Id
    private String _id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;

}
