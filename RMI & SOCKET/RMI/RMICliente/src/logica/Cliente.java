/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;


import java.io.ObjectOutputStream;
import java.net.Socket;
import java.rmi.RemoteException;

import johnarrieta.apipc.v1.Computador;
import org.hyperic.sigar.OperatingSystem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

/**
 * Clase CLiente, esta clase utilizaremos para estraer la informacion del equipo
 * y enviarla al servidor
 *
 * @author Andres Ramirez
 * @author Pedro Ortiz
 *
 */
public class Cliente implements OperacionesCliente {

    //Atributos necesarios para el cliente 
    private static final Sigar sigar = new Sigar();//objeto que se utiliza para obtener informacion del equipo
    //Objetos necesarios para conectar cliente y servidor
    private Socket conector;
    private int puertoServidor;
    private String ip;

    /**
     * Metodo cliente constructor general este metodo recibe los parametros
     * Puerto e ip y realizan la coneccion con el servidor
     *
     * @param puerto
     * @param ip
     */
    public Cliente(int puertoLocal,int puerto, String ip) {
        this.puertoServidor = puerto;//puerto del servidor
        this.ip = ip;//ip del servidor
   
    }

    /**
     * metodo utilizado para imprimir un error en caso de que ocurra
     *
     * @param msg mensaje que acompañe la excepcion
     * @param error excepcion
     */
    public static void mensajeError(String msg, Exception error) {
        System.out.println(msg);
        System.out.println("Mensaje Org: " + error.getMessage());
        error.printStackTrace();
    }
    Computador pc = new Computador();// se inicializa un objeto pc
    ObjectOutputStream oos;//necesario para enviar el pc

    /**
     * Metodo get del conector
     *
     * @return el conector
     */
    public Socket getConector() {
        return conector;
    }

    /**
     * metodo set del conector
     *
     * @param conector permite modificarlo
     */
    public void setConector(Socket conector) {
        this.conector = conector;
    }

    /**
     * metodo del puerto hace referencia al puerto del servidor
     *
     * @return el puerto de coneccion
     */
    public int getPuerto() {
        return puertoServidor;
    }

    /**
     * permite modificar el puerto de coneccion
     *
     * @param puerto puerto del servidor para conectar con el cliente
     */
    public void setPuerto(int puerto) {
        this.puertoServidor = puerto;
    }

    /**
     * metodo get devuelve la ip del servidor con el que se desea conectar
     *
     * @return ip del servidor
     */
    public String getIp() {
        return ip;
    }

    /**
     * metodo set de la ip del servidor
     *
     * @param ip ip del servidor, para lograr conectarse
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

     /**
     * metodo enviar dato, es el que se encarga de obtener y enviar los datos 
     * del equipo al servidor
     *
     * @return computador que se envia al servidor
     * @throws java.rmi.RemoteException
     */
    @Override
    public Computador enviarDatos() throws RemoteException {

        OperatingSystem SO = OperatingSystem.getInstance();
        pc.setSo(System.getProperty("os.name"));//obtenemos el  nombre del sistema operativo
        pc.setUsuario(System.getProperty("user.name"));//obtenemos el nombre del usuario
        try {
            pc.setProcesador(sigar.getCpuInfoList()[0].getModel() + "");//se obtiene el modelo del procesaro
            pc.setRam((sigar.getMem().getRam() / 1024.0) + "GB");//se obtiene la cantidad de memoria ram y se pasa a GB
            pc.setMac(sigar.getNetInterfaceConfig().getHwaddr());//se obtiene la direccion mac del pc
            pc.setIp(sigar.getNetInterfaceConfig().getAddress());//se obtiene la direccion ip del equipo
            pc.setFabricanteProcesador(sigar.getCpuInfoList()[0].getVendor());//se obtiene el fabricante del procesador
            pc.setNucleoProcesador(sigar.getCpuInfoList()[0].getTotalCores() + "");//se obtiene el numero de procesadores
            pc.setDescripcionSO(SO.getDescription());//se obtiene una descripcion del SO
            pc.setArquitecturaSO(SO.getArch());

            return pc;
        } catch (SigarException ex) {
            //en caso de ocurrir una exepcion las muestra en consola
            System.out.println("Error------/n");
            System.err.print(ex);
        }
        return null;

    }

}
