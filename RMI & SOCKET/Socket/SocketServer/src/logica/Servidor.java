/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *Clase servidor, es la clase que recibe un objeto y muestra
 * @author Estudiante
 */
public class Servidor extends Thread{

     private ServerSocket server;//se crea un Objeto Socket llamado server
    private String ip;//ip que tomara el servidor
    private int puerto = 8779;//puerto que tomara el servidor
    private boolean estado;//estado de la coneccion
    private HashMap<String, AtiendeCliente> listaConectados;//mapa con la lista de equipos conectados
    
    public Servidor(){
        try {
            ip = InetAddress.getLocalHost().getHostAddress();
            listaConectados = new HashMap<String, AtiendeCliente>();
        } catch (UnknownHostException ex) {
            JOptionPane.showMessageDialog(null, "No se puede iniciar el servidor");
        }
         
    }
    
    @Override
    public void run() {
        super.run(); //To change body of generated methods, choose Tools | Templates.
        iniciar();
    }
    
     /**
     *En este metodo se inicia el socket y se solicita la comunicacion del servidor con el cliente
     * se crea un mapa de ip con cliente, donde aparece el otro equipo
     */
    public void iniciar(){
        
        try {
            server = new ServerSocket(puerto);//inicia la coneccion socket por el puerto
            estado = true;//coneccion activa
            do {                
                Socket cliente = server.accept();//si llega un cliente lo acepta
                AtiendeCliente unCliente = new AtiendeCliente(this, cliente);//asigna un atiende cliente al cliente
                listaConectados.put(cliente.getInetAddress().getHostAddress(), unCliente);//guarda el cliente en el mapa
                
            } while (estado);//mientras el estado este true
            
        } catch (IOException ex) {
           mensajeError("No se puede utilizar el Servicio en el puerto: "+puerto, ex);
        }
    }

    public HashMap<String, AtiendeCliente> getListaConectados() {
        return listaConectados;
    }

    public void setListaConectados(HashMap<String, AtiendeCliente> listaConectados) {
        this.listaConectados = listaConectados;
    }

    public ServerSocket getServer() {
        return server;
    }

    public void setServer(ServerSocket server) {
        this.server = server;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    public static void mensajeError(String msg, Exception error){
          System.out.println(msg);
            System.out.println("Mensaje Org: "+error.getMessage());
            error.printStackTrace();
    }
    
}
