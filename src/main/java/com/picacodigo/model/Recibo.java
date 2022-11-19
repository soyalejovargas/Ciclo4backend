package com.picacodigo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Document("facturas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Recibo{

    @Id
    private String _id;
    private String mes;
    private String fechaLimite;
    private Integer tarifa;
    private double total;
    @DBRef
    private Inmueble inmueble;

}
