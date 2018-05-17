/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import APIpc.Computador;

/**
 *Hilo entrada
 * esta clase es la que recibe al objeto
 * @author Estudiante
 */
public class HiloEntrada extends Thread{
    
    Socket cliente;
    boolean estado;
    ObjectInputStream ois;
    Servidor server;
    ArrayList<Computador>listaComputadores = new ArrayList<>();

    HiloEntrada(Servidor server, Socket cliente) {
     this.cliente = cliente;
     this.server = server;
     
    }
    @Override
    public void run() {
        super.run(); //To change body of generated methods, choose Tools | Templates.
        leerDatos();//ejecuta el metodo leer datos en segundo plano
    }

    public void leerDatos(){
        try {
            //instancia un ObjetInputStream con lo que recibe cliente
            ois = new ObjectInputStream(cliente.getInputStream());
                         
                Computador pc = (Computador)ois.readObject();//obtiene el pc y lo castea
                listaComputadores.add(pc);//agrega el pc a la lista
               
           
        } catch (IOException ex) {
            //en el caso de que no se pueda conectar al canal
            Servidor.mensajeError("No se puede utilizar el canal de Entrada", ex);
            estado = false;
        } catch (ClassNotFoundException ex) {
            //en el caso en el que no se encuentre el .jar de ApiPC
            Servidor.mensajeError("Alquien borro la clase Computador", ex);
            estado = false;
        }
       
        
    }

    public ArrayList<Computador> getListaComputadores() {
        return listaComputadores;
    }



    public void setListaComputadores(ArrayList<Computador> listaComputadores) {
        this.listaComputadores = listaComputadores;
    }
    
    
    void setEstado(boolean estado) {
        this.estado = estado;
    }
    
  
}
