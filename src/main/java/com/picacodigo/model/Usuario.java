package com.picacodigo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Document("usuarios")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Usuario{

    @Id
    private String _id;
    private String usuario;
    private String password;
    @DBRef
    private Persona persona;
}
