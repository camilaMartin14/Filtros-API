package com.filtrosapi.filtros.repository;

import com.filtrosapi.filtros.model.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
    
    public List<Usuario> findAll();
}