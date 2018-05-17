/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentador;

import Modelo.Modelo;
import Vista.Ivista;

/**
 *
 * @author Pedro Ortiz M
 */
public class Presentador {
    
    private Ivista iVista;
    
    public Presentador(Ivista iVista){
    this.iVista = iVista;
    
    }
    
    public void convertir(){
    
        Modelo modelo = new Modelo();
        String cadena = iVista.getDato();
        cadena = modelo.toUpper(cadena);
        //iVista.setDato(modelo.toUpper(iVista.getDato()));

        iVista.setDato(cadena);
        
    
    }
    
}
