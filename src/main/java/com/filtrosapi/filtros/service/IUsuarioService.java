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
    
    public void editUsuario();
    
    public void editUsuario(Long id);
    
    public void findByFechaRegistro(Long codigoVenta, List<Usuario> listaProductos);
    
    public double findByMenoresEdad(LocalDate fecha);

    public int findByMayoresEdad(LocalDate fecha);

    public ArrayList<Usuario> findByFechaRegistro(ArrayList<Usuario> listaUsuarios, LocalDate fechaBusqueda);
    
    public ArrayList<Usuario> findByFechaBaja(ArrayList<Usuario> listaUsuarios, LocalDate fechaBusqueda);
    
}
