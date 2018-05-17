/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import APIpc.Computador;
import javax.swing.JOptionPane;
import org.hyperic.sigar.OperatingSystem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

/**
 *Clase CLiente, esta clase utilizaremos para estraer la informacion del equipo y enviarla al 
 * servidor 
 * 
 * @author Andres Ramirez
 * @author Pedro Ortiz
 * 
 */
public class Cliente {
    
    //Atributos necesarios para el cliente 
    private static final Sigar sigar = new Sigar();//objeto que se utiliza para obtener informacion del equipo
    //Objetos necesarios para conectar cliente y servidor
    private Socket conector;
    private int puerto;
    private String ip;

    /**
     *  Metodo cliente constructor general
     * este metodo recibe los parametros Puerto e ip
     *  y realizan la coneccion con el servidor
     * @param puerto
     * @param ip
     */
    public Cliente(int puerto, String ip) {
        this.puerto = puerto;//puerto del servidor
        this.ip = ip;//ip del servidor
        try {
            conector = new Socket(ip, puerto);// se inicializa el Socket pasandole como parametros
                                              // la ip y el puerto
            JOptionPane.showMessageDialog(null, "Conectado con éxito");

        } catch (IOException ex) {
            //en caso de que arroje alguna excepcion por no lograr conectarse muestre el mensaje de error
            JOptionPane.showMessageDialog(null,"No se puede conectar con el servidor " + ip + ":" + puerto+ ex);
        }
    }

    /**
     * metodo utilizado para imprimir un error en caso de que ocurra
     * @param msg mensaje que acompañe la excepcion
     * @param error excepcion
     */
  
    Computador pc = new Computador();// se inicializa un objeto pc
    ObjectOutputStream oos;//necesario para enviar el pc

    /**
     *Metodo que envia el Computador al servidor, 
     *en este metodo tambien se obtienen los datos
     * 
    */
    public void enviarDatoPc() {
        try {
            OperatingSystem SO=OperatingSystem.getInstance();
            pc.setSo(System.getProperty("os.name"));//obtenemos el  nombre del sistema operativo
            pc.setUsuario(System.getProperty("user.name"));//obtenemos el nombre del usuario
            try {
                pc.setProcesador(sigar.getCpuInfoList()[0].getModel()+"");//se obtiene el modelo del procesaro
                pc.setRam((sigar.getMem().getRam()/1024.0)+ "GB");//se obtiene la cantidad de memoria ram y se pasa a GB
                pc.setMac(sigar.getNetInterfaceConfig().getHwaddr());//se obtiene la direccion mac del pc
                pc.setIp(sigar.getNetInterfaceConfig().getAddress());//se obtiene la direccion ip del equipo
                pc.setFabricanteProcesador(sigar.getCpuInfoList()[0].getVendor());//se obtiene el fabricante del procesador
                pc.setNucleoProcesador(sigar.getCpuInfoList()[0].getTotalCores()+"");//se obtiene el numero de procesadores
                pc.setDescripcionSO(SO.getDescription());//se obtiene una descripcion del SO
                pc.setArquitecturaSO(SO.getArch());
            } catch (SigarException ex) {
                //en caso de ocurrir una exepcion las muestra en consola
                System.out.println("ERRROR");
                System.err.print(ex);
            }
            //envia el objeto a traves del socket
            oos = new ObjectOutputStream(conector.getOutputStream());

            Thread hiloEscritura;//declaramos un hilo para que se pueda ejecutar en segundo plano
            hiloEscritura = new Thread() {
                
                @Override
                public void run() {
                    super.run(); //To change body of generated methods, choose Tools | Templates.
                    try {
                        oos.writeObject(pc);//se envia el objeto por medio del socket
                        oos.flush();//limpia el buffer para que se pueda seguir usando
                        
                        try {
                            Thread.sleep(10000);//da una espera de 10 segundos para que alcance a llegar toda la trama
                        } catch (InterruptedException ex) {
                           JOptionPane.showMessageDialog(null, "ERROR ESPERANDO");
                        }
                        
                    } catch (IOException ex) {
                       JOptionPane.showMessageDialog(null, "ERROR ENVIANDO PC");
                    }

                }
            };
             hiloEscritura.start();//inicia el hilo de escritura
        } catch (IOException ex) {
           JOptionPane.showMessageDialog(null, "ERROR CON EL CANAL DE SALIDA");
            return;
        }
        
    }

    /**
     *Metodo get del conector 
     * @return el conector
     */
    public Socket getConector() {
        return conector;
    }

    /**
     * metodo set del conector 
     * @param conector permite modificarlo
     */
    public void setConector(Socket conector) {
        this.conector = conector;
    }

    /**
     *metodo del puerto hace referencia al puerto del servidor
     * @return el puerto de coneccion
     */
    public int getPuerto() {
        return puerto;
    }

    /**
     *permite modificar el puerto de coneccion
     * @param puerto puerto del servidor para conectar con el cliente
     */
    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }

    /**
     *metodo get devuelve la ip del servidor con el que se desea conectar
     * @return ip del servidor
     */
    public String getIp() {
        return ip;
    }

    /**
     *metodo set de la ip del servidor
     * @param ip ip del servidor, para lograr conectarse
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

}
