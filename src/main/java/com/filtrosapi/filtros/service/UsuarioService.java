package com.filtrosapi.filtros.service;

import com.filtrosapi.filtros.model.Usuario;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService{

    @Override
    public List<Usuario> getUsuarios() {

    }

    @Override
    public Usuario findUsuario(Long id) {

    }

    @Override
    public void saveUsuario(Usuario us) {

    }

    @Override
    public void deleteUsuario(Long id) {

    }

    @Override
    public void editUsuario() {

    }

    @Override
    public void editUsuario(Long id) {

    }

    @Override
    public void findByFechaRegistro(Long codigoVenta, List<Usuario> listaProductos) {

    }

    @Override
    public double findByMenoresEdad(LocalDate fecha) {

    }

    @Override
    public int findByMayoresEdad(LocalDate fecha) {

    }

    @Override
    public ArrayList<Usuario> findByFechaRegistro(ArrayList<Usuario> listaUsuarios, LocalDate fechaBusqueda) {

    }

    @Override
    public ArrayList<Usuario> findByFechaBaja(ArrayList<Usuario> listaUsuarios, LocalDate fechaBusqueda) {

    }
    
}
