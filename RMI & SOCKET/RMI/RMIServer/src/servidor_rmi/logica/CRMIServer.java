/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor_rmi.logica;

import java.net.Inet4Address;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.OperacionesCliente;
import logica.OperacionesServidor;
import logica.Utilidad;
import servidor_rmi.ventanas.VentanaRMIServerl;

/**
 *
 * @author Andres Ramirez
 * @author Pedro Ortiz
 */
public class CRMIServer implements OperacionesServidor {

    //Datos que le competen directamente al servidor
    private String ip;
    private String puerto;
  
    private VentanaRMIServerl ventana;

    private ArrayList<OperacionesCliente> listClientes;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public VentanaRMIServerl getVentana() {
        return ventana;
    }

    public void setVentana(VentanaRMIServerl ventana) {
        this.ventana = ventana;
    }

   

    public ArrayList<OperacionesCliente> getListClientes() {
        return listClientes;
    }

    public void setListClientes(ArrayList<OperacionesCliente> listClientes) {
        this.listClientes = listClientes;
    }

    public String getPuerto() {
        return puerto;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    /**
     * Servidor_rmi
     * @param puerto inicia el servi 
     */
    public CRMIServer(String puerto) {
        try {
            this.ip = Inet4Address.getLocalHost().getHostAddress();
        } catch (UnknownHostException ex) {
            System.out.println("Error : no se pudo capturar tú IP");
        }

        this.puerto = puerto;
        listClientes = new ArrayList<>();
    }

    /**
     *
     * @return la informacion del servidor la ip y el puerto
     */
    @Override
    public String toString() {
        return "" + "ip=" + ip + ", puerto=" + puerto;
    }

    /**
     * Es importante tener en cuenta que la "," debido a que con ella podemos
     * separar la información del servidor,por ejemplo la ip =127.0.0.1
     *
     * @return devuelve la información del servidor,por ejemplo la ip =127.0.0.1
     * "," puerto = 8000
     */
    @Override
    public String propiedadesServidor() throws RemoteException {
        return toString();
    }

    /**
     * Mediante este método el cliente le solicita al servidor que lo agregue a
     * sus clientes conectados
     *
     * @param  ipCliente  contiene la IP 
     * @param puerto  el Puerto por el que escucha dicho cliente
     * 
     * @return true si lo agrego y false sino
     * @throws RemoteException
     */
    @Override
    public boolean agregarCliente(String ipCliente, int puerto) throws RemoteException {

        Utilidad.setCodeBase(OperacionesCliente.class);

        try {

            OperacionesCliente nuevo = (OperacionesCliente) Naming.lookup("//" + ipCliente + ":" + puerto + "/ObjetoCliente");

            if (listClientes.add(nuevo)) {

                ventana.actualizarTabla();//Actualiza la tabla de la ventana principal con la ip y el nombre de usuario
                return true;

            } else {
                return false;
            }

        } catch (NotBoundException | MalformedURLException ex) {
            ventana.mostrarMensajes("Error al intentar agregar un cliente");
            Logger.getLogger(CRMIServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

}
