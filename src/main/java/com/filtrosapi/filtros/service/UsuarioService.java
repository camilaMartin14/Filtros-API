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
}
