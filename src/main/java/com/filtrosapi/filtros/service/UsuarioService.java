package com.filtrosapi.filtros.service;

import com.filtrosapi.filtros.model.Usuario;
import com.filtrosapi.filtros.repository.IUsuarioRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService{
    
    @Autowired
    private IUsuarioRepository usuRepo;

    @Override
    public List<Usuario> getUsuarios() {
        List <Usuario> listaUsuarios= usuRepo.findAll();
        
        return listaUsuarios;
    }

    @Override
    public Usuario findUsuario(Long id) {
        Usuario usu = usuRepo.findById(id).orElse(null);
        return usu;
    }

    @Override
    public void saveUsuario(Usuario usu) {
                usuRepo.save(usu);
    }

    @Override
    public void deleteUsuario(Long id) {
        usuRepo.deleteById(id);
    }

    @Override
    public void editUsuario(long id,
                            long nuevoId,
                            String nuevoNombre,
                            String nuevoApellido,
                            LocalDate nuevaFechaRegistro,
                            LocalDate nuevaFechaBaja,
                            LocalDate nuevaFechaNacimiento,
                            String nuevoDni,
                            String nuevoCuil,
                            boolean nuevoEstaActivo) {
        
    Usuario usu = this.findUsuario(id);
    
            usu.setId(nuevoId);
            usu.setNombre(nuevoNombre);
            usu.setApellido(nuevoApellido);
            usu.setFechaRegistro(nuevaFechaRegistro);
            usu.setFechaBaja(nuevaFechaBaja);
            usu.setFechaNacimieno(nuevaFechaNacimiento);
            usu.setDni(nuevoDni);
            usu.setCuil(nuevoCuil);
            usu.setEstaActivo(nuevoEstaActivo);


           this.saveUsuario(usu);
    }

    @Override
    public void editUsuario(Usuario usu) {
    this.saveUsuario(usu);

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
    
    //Para encontrar con usuarios con DNIs idénticos
    @Override
    public String[] findByDni (String[] documentos,String valor){
        boolean encontrado=false;
        
        for(int i=0;i<documentos.length && !encontrado;i++){
            
            if(documentos[i]!=null){
                if(documentos[i].equals(valor)){
                    encontrado=true;
                }
            }
            
        }
        
        return documentos;
    }

    @Override
    public ArrayList<Usuario> findByFechaRegistro(ArrayList<Usuario> listaUsuarios, LocalDate fechaBusqueda) {

    }

    @Override
    public ArrayList<Usuario> findByFechaBaja(ArrayList<Usuario> listaUsuarios, LocalDate fechaBusqueda) {

    }
    
    @Override
    public int countCifrasDni(int numeroCifrasIngresado) {
    int contador=0;
            if(numeroCifrasIngresado==0){
                return 1;
            }else if(numeroCifrasIngresado>0){
                //bucle que cuenta las cifras
                while (numeroCifrasIngresado>0){
                    numeroCifrasIngresado=(int)Math.floor(numeroCifrasIngresado/10);
                    contador+=1;
                }
               
               return contador;
               
            }else{
                while (numeroCifrasIngresado<0){
                   numeroCifrasIngresado=(int)Math.floor(numeroCifrasIngresado/10);
                   contador+=1;
                }
               
                return contador;
            }
       }    

    @Override
    public String fillDniConCeros(int numeroMaximoCifras, int numeroCifrasIngresado) {
        
        int numCeros=numeroMaximoCifras-countCifrasDni(numeroCifrasIngresado);
        
        String ceros="";
        
        for(int i=0;i<numCeros;i++){
            ceros+="0";
        }
        
        return ceros+String.valueOf(numeroCifrasIngresado);
    }    

    @Override
    public int getCantidadSuscripcionesEnFecha(LocalDate fechaRegistro) {
        List <Usuario> listaUsuarios= usuRepo.findAll();
        ArrayList<Usuario> suscripcionesEnFecha = findByFechaRegistro(new ArrayList<>(listaUsuarios), fechaRegistro);
        
        return suscripcionesEnFecha.size();     
    }
}
