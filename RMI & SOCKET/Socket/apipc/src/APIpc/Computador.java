/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package APIpc;

import java.io.Serializable;

/**
 *
 * @author Andres Ramirez
 * @author Pedro Ortiz
 * 
 */
public class Computador implements Serializable{
    
    //atributos del computador
    private String so;
    private String descripcionSO;
    private String arquitecturaSO;
    private String fabricanteProcesador;
    private String usuario;
    private String ram;
    private String capacidad;
    private String procesador;
    private String nucleoProcesador;
    private String ip;
    private String Mac;

    
    
    public String getNucleoProcesador() {
        return nucleoProcesador;
    }

    public void setNucleoProcesador(String nucleoProcesador) {
        this.nucleoProcesador = nucleoProcesador;
    }
    
    
    public String getDescripcionSO() {
        return descripcionSO;
    }

    public void setDescripcionSO(String descripcionSO) {
        this.descripcionSO = descripcionSO;
    }

    public String getArquitecturaSO() {
        return arquitecturaSO;
    }

    public void setArquitecturaSO(String arquitecturaSO) {
        this.arquitecturaSO = arquitecturaSO;
    }

    public String getFabricanteProcesador() {
        return fabricanteProcesador;
    }

    public void setFabricanteProcesador(String fabricanteProcesador) {
        this.fabricanteProcesador = fabricanteProcesador;
    }

    /**
     *devuelve el valor de la memoria ram
     * @return la memoria del ram equipo
     */
    public String getRam() {
        return ram;
    }
    
    /**
     *Metodo set recibe como parametro
     * @param ram del equipo computo y modificarla
     */
    public void setRam(String ram) {
        this.ram = ram;
    }

    /**
     * Metodo get que devuelve
     * @return la capacidad del disco duro
     */
    public String getCapacidad() {
        return capacidad;
    }

    /**
     * Metodo set recibe como parametro
     * @param capacidad del disco duro
     */
    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    /**
     * devuelve el tipo de procesador
     * @return procesador 
     */
    public String getProcesador() {
        return procesador;
    }

    /**
     * Metodo set recibe como parametro
     * @param procesador y lo modifica por el que reciba
     */
    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    /**
     * devuelve la ip del equipo
     * @return la ip del computador
     */
    public String getIp() {
        return ip;
    }

    /**
     * Metodo set recibe como parametro
     * @param ip y lo modifica
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * devuelve la direccion mac
     * @return del computador
     */
    public String getMac() {
        return Mac;
    }

    /**
     * Metodo set recibe como parametro
     * @param Mac y la modifica
     */
    public void setMac(String Mac) {
        this.Mac = Mac;
    }
    
    /**
     * metodo que devuelve
     * @return sistema operativo que tiene
     */
    public String getSo() {
        return so;
    }

    /**
     *  Metodo set recibe como parametro
     * @param so y lo modifica
     */
    public void setSo(String so) {
        this.so = so;
    }

    /**
     * Metodo  get devuelve el 
     * @return con el nombre del usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Metodo set recibe como parametro
     * @param usuario que es el nombre del equipo
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    /**
     * Metodo toString de computador
     * @return retorna un String con la informacion del sistema
     */
    @Override
    public String toString() {
      String dato = "Sistema Operativo: "+so
              + "\nArquitectura del Sistema Operativo: "+arquitecturaSO +"\n"
              +"\nDescripcion :"+descripcionSO+"\n"
                   + "\nUsuario: "+usuario+"\n"+
              "\nCantidad de Ram: "+ram+"\n"+
              "\nProcesador: "+this.procesador+"\n"+
              "\nnumero de nucleos: "+this.nucleoProcesador+"\n"+
              "\nFabricante: "+this.fabricanteProcesador+"\n"+
              "\nIP: "+this.ip+"\n"+
              "\nMac: "+this.Mac+"\n";
      return dato;
    }
    
    
}
