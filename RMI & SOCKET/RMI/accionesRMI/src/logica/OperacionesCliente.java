/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.rmi.Remote;
import java.rmi.RemoteException;
import johnarrieta.apipc.v1.Computador;

/**
 *En esta interfaz definimos los metodos que implemetara
 * en la clase RMIcliente llamados desde el servidor
 * @author Andres
 */
public interface OperacionesCliente extends Remote{
    
    /**
     *  enviar datos: este metodo permite que se llame desde el servidor hasta el cliente
     * y este le envie el computador al servidor
     * @return Computador   permiter
     * @throws RemoteException
     */
    public Computador enviarDatos()  throws RemoteException;
    
}
