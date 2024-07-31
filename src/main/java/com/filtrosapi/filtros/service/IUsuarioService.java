package com.filtrosapi.filtros.service;

import com.filtrosapi.filtros.model.Usuario;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface IUsuarioService {
    
    public List <Usuario> getUsuarios();
    
    public Usuario findUsuario(Long id);
    
    public void saveUsuario(Usuario us);
    
    public void deleteUsuario(Long id);
    
    public void editUsuario(long id,
                            long nuevoId,
                            String nuevoNombre,
                            String nuevoApellido,
                            LocalDate nuevaFechaRegistro,
                            LocalDate nuevaFechaBaja,
                            LocalDate nuevaFechaNacimiento,
                            String nuevoDni,
                            String nuevoCuil,
                            boolean nuevoEstaActivo);
    
    public void editUsuario(Usuario usu);
    
    public double findByMenoresEdad(LocalDate fecha);
    
    public String[] findByDni (String[] documentos,String valor);

    public int findByMayoresEdad(LocalDate fecha);

    public ArrayList<Usuario> findByFechaRegistro(ArrayList<Usuario> listaUsuarios, LocalDate fechaBusqueda);
    
    public ArrayList<Usuario> findByFechaBaja(ArrayList<Usuario> listaUsuarios, LocalDate fechaBusqueda);
    
    public int countCifrasDni (int numeroCifrasIngresado);
    
    public String fillDniConCeros (int numeroMaximoCifras, int numeroCifrasIngresado);
    
    public int getCantidadSuscripcionesEnFecha(LocalDate fechaRegistro);
    
    public boolean validarFecha(int anio, int mes, int dia);
    
    public int numeroDeDiasMes (int mes);
    
    public boolean mesCorrecto(int mes);
    
    public boolean esBisiesto(int anio);
}
