/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Andres Ramirez
 * @author Pedro ortiz
 * 
 */
public class Utilidad {

    public static final String CODEBASE = "java.rmi.server.codebase";
    /*
     indica al compilador que se  va a realizar una compilacion usando RMIC.
     */
    public static void setCodeBase(Class<?> args) {
        /*El parametro c de tipo Class<?> del metodo setCodeBase, indica que sele puede
         pasar cualquier clase.*/
        String ruta = args.getProtectionDomain().getCodeSource().getLocation().toString();
        /*devuelve la ruta
         del archivo de codigo fuente .java de la clase que se ha pasado como parametro
         Class <?> c.
         */

        String path = System.getProperty(CODEBASE);

        if (path != null && !path.isEmpty()) { 

            ruta = path + " " + ruta;

        }
        System.setProperty(CODEBASE, ruta);

    }

}
