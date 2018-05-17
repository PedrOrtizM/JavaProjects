/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *Esta interfaz permite recibir el objeto que mando el cliente cuando se conectaron y agregarlo a
 * la lista
 * @author Andres Ramirez
 * @author Pedro Ortiz
 */
public interface OperacionesServidor extends Remote{
    
    public String propiedadesServidor() throws RemoteException;;
    
    /**
     * @param ip recibe la ip del cliente
     * @param puerto recibe el puerto de escucha del cliente
     * 
     * @return      boolean retorna true si se logro agregar el cliente, o false en caso de
     * no se pudo agregar
     * @throws java.rmi.RemoteException     
     */
    public boolean agregarCliente(String ip , int puerto) throws RemoteException;;
    
}
