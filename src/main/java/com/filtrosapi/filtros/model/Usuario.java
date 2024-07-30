package com.filtrosapi.filtros.model;

import jakarta.persistence.Entity;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter@Setter
public class Usuario {
    
    private long id;
    private String nombre;
    private String apellido;
    private LocalDate fechaRegistro;
    private LocalDate fechaBaja;
    private LocalDate fechaNacimieno;
    private String dni;
    private String cuil;
    private boolean estaActivo;
    
    
    public Usuario() {
    }

    public Usuario(long id, String nombre, String apellido, LocalDate fechaRegistro, LocalDate fechaNacimieno, String dni, String cuil) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaRegistro = fechaRegistro;
        this.fechaNacimieno = fechaNacimieno;
        this.dni = dni;
        this.cuil = cuil;
    }
    
}
