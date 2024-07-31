package com.filtrosapi.filtros.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter@Setter
public class Usuario {
    
    @Id
    private long id;
    private String nombre;
    private String apellido;
    private LocalDate fechaRegistro;
    private LocalDate fechaBaja;
    private LocalDate fechaNacimiento;
    private String dni;
    private String cuil;
    private boolean estaActivo;
    
    
    public Usuario() {
    }

    public Usuario(long id, String nombre, String apellido, LocalDate fechaRegistro, LocalDate fechaNacimiento, String dni, String cuil) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaRegistro = fechaRegistro;
        this.fechaNacimiento = fechaNacimiento;
        this.dni = dni;
        this.cuil = cuil;
    }
    
}
