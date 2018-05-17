/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

import java.net.Socket;

/**
 * Clase encargada de atender el cliente, 
 * sera la que cree el camino por donde se conectara el cliente
 * @author Estudiante
 */
public class AtiendeCliente {
    private Socket cliente;//se crea un socket del cliente
    private HiloEntrada in;// se crean objetos de las clases hilo de entrada
  
    private boolean estado;//estado de la coneccion
    Servidor server;

     /**
     *Constructor general
     * @param server recibe como parametro el servidor 
     * @param cliente recibe como parametro el socket del cliente
     */
    AtiendeCliente(Servidor server, Socket cliente) {
       this.server = server;
       this.cliente = cliente;
       in = new HiloEntrada(server, cliente); //inicializa el hilo con el cliente y el servidor
       in.start();
    }

     /**
     * este metodo retorna un cliente
     * @return cliente retorna el cliente
     */
    public Socket getCliente() {
        return cliente;
    }
    /**
     * este metodo retorna un Servidor
     * @return Servidor retorna el Servidor
     */
    public Servidor getServer() {
        return server;
    }

    /**
     *este metodo modifica el valor de server por el 
     * @param server recibido aqui
     */
    public void setServer(Servidor server) {
        this.server = server;
    }

      /**
     *este metodo modifica el valor de cliente por el 
     * @param cliente recibido aqui
     */
    public void setCliente(Socket cliente) {
        this.cliente = cliente;
    }

    public HiloEntrada getIn() {
        return in;
    }

    public void setIn(HiloEntrada in) {
        this.in = in;
    }

    public boolean isEstado() {
        return estado;
    }

    /**
     *  este metodo modifica el estad de la conexion en los hilos de entrada
     * @param estado y de salidas
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
        in.setEstado(estado);
      
        
    }
    
    
    
}
