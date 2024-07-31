package com.filtrosapi.filtros.controller;

import com.filtrosapi.filtros.model.Usuario;
import com.filtrosapi.filtros.service.IUsuarioService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UsuarioController {
    
    @Autowired
    private IUsuarioService usuServ;

    @GetMapping ("/usuarios")
    public List <Usuario> getUsuarios(){
        return usuServ.getUsuarios();
    }
    
    @PostMapping ("/usuarios/crear")
    public String saveUsuario(@RequestBody Usuario usu){
        usuServ.saveUsuario(usu);
        
        return "El usuario se creó correctamente";
    }
    
    @DeleteMapping("/usuarios/eliminar/{id}")
    public String deleteUsuario(@PathVariable Long id){
        usuServ.deleteUsuario(id);
        
        return "El usuario se borró correctamente";
    }
    
    @PutMapping("/usuario/editar/{id}")
    public Usuario editUsuario (@PathVariable Long id,
            @RequestParam(required = false, name= "id") Long nuevoId,
            @RequestParam(required = false, name= "nombre") String nuevoNombre,
            @RequestParam(required = false, name= "apellido") String nuevoApellido,
            @RequestParam(required = false, name= "fechaRegistro") LocalDate nuevaFechaRegistro,
            @RequestParam(required = false, name= "fechaBaja") LocalDate nuevaFechaBaja,
            @RequestParam(required = false, name= "fechaNacimiento") LocalDate nuevaFechaNacimiento,
            @RequestParam(required = false, name= "dni") String nuevoDni,
            @RequestParam(required = false, name= "cuil") String nuevoCuil,
            @RequestParam(required = false, name= "estaActivo") boolean nuevoEstaActivo){
    
        usuServ.editUsuario(id, 
                            nuevoId,
                            nuevoNombre, 
                            nuevoApellido, 
                            nuevaFechaRegistro, 
                            nuevaFechaBaja,
                            nuevaFechaNacimiento,
                            nuevoDni,
                            nuevoCuil,
                            nuevoEstaActivo);
        
        Usuario usu = usuServ.findUsuario(nuevoId);
        
        return usu;
    }
    
    @PutMapping("/usuarios/editar")
    public Usuario editUsuario(@RequestBody Usuario usu){
        usuServ.editUsuario(usu);
        
        return usuServ.findUsuario(usu.getId());
    }
    
    @GetMapping("/usuarios/registros/{fechaRegistro}")
    public String getCantidadSuscripcionesEnFecha(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaRegistro) {
        double totalSuscripciones = usuServ.getCantidadSuscripcionesEnFecha(fechaRegistro);

        return "En la fecha " + fechaRegistro + " las suscripciones fueron " + totalSuscripciones;
    }
}
