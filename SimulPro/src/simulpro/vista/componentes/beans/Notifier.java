/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simulpro.vista.componentes.beans;

import java.util.Observable;
import java.util.Observer;
 
/**
 *
 * @author Klac
 */
public class Notifier extends Observable{
  
    private static Notifier notificador = null;
     
    public static Notifier getNotificador(){
        if(notificador == null){
            notificador = new Notifier();
        }
        return notificador;
    }
     
    public void notificar(Object obj){
        this.setChanged();
        notificador.notifyObservers(obj);
    }
     
    public void añadirObsevador(Observer obser){
        notificador.addObserver(obser);
    }
}