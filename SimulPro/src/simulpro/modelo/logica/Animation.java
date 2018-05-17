/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simulpro.modelo.logica;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import simulpro.vista.componentes.beans.LabelThread;
import simulpro.vista.componentes.beans.Notifier;
import simulpro.vista.paneles.PanelAnimation;

/**
 *
 * @author Ariel Arnedo
 */
public class Animation {
    
    private float animationSpeed = 1.0F;
    
    private StateAnimation stateAnimation = StateAnimation.STOP;
    
    private final PanelAnimation panelAnimation;
    private final ThreadMove thread = new ThreadMove();
    private final LabelThread labelThread;

    private final Queue<Persona> personas;
    private final Queue<Persona> colaCaja;
    private final List<Persona> colaAtencion;
    
    private final List<Persona> personasProcesadas;
    
    public Animation() {
        panelAnimation = new PanelAnimation();
        labelThread = new LabelThread();
        personas = new LinkedList<>();
        colaCaja = new LinkedList<>();
        colaAtencion = new LinkedList<>();
        personasProcesadas = new java.util.ArrayList<>();
        loadPerson();
    }
    
    private void loadPerson(){
        while(true){
            try{
                personas.offer(FactoryExponencialPerson.createPersonWithAllAtributes());
            }catch(EmptyStackException ex){
                break;
            }
        }
    }

    public float getAnimationSpeed() {
        return animationSpeed;
    }

    public void setAnimationSpeed(float animationSpeed) {
        this.animationSpeed = animationSpeed;
    }

    public PanelAnimation getPanelAnimation() {
        return panelAnimation;
    }

    public LabelThread getLabelThread() {
        return labelThread;
    }
    
    public void setLabelProductosComprados(javax.swing.JLabel eti){
        thread.setLabelProductos(eti);
    }
    
    public StateAnimation getStateAnimation() {
        return stateAnimation;
    }

    public void setStateAnimation(StateAnimation stateAnimation) {
        this.stateAnimation = stateAnimation;
    }

    public Queue<Persona> getPersonas(){
        return personas;
    }
    
    public Queue<Persona> getColaCaja() {
        return colaCaja;
    }

    public List<Persona> getColaAtencion() {
        return colaAtencion;
    }

    public List<Persona> getPersonasProcesadas() {
        return personasProcesadas;
    }
    
    public java.util.List<Persona> listPersonInBox(){
        java.util.List<Persona> list = new java.util.ArrayList<>();
        Iterator<Persona> iteCaja = getColaCaja().iterator();
        while(iteCaja.hasNext()){
            Persona poPersona = iteCaja.next();
            if(poPersona != null)
                list.add((Persona) iteCaja.next().clone());
        }
        return list;
    }
    
    public java.util.List<Persona> listPersonInAttencion(){
        java.util.List<Persona> list = new java.util.ArrayList<>();
        Iterator<Persona> iteAttention = getColaAtencion().iterator();
        while(iteAttention.hasNext()){
            Persona poPersona = iteAttention.next();
            if(poPersona != null)
                list.add((Persona) poPersona.clone());

        }
        return list;
    }
    
    public java.util.List<Persona> listPersonExit() {
        java.util.List<Persona> list = new java.util.ArrayList<>();
        Iterator<Persona> iteExit = getPersonasProcesadas().iterator();
        
        while(iteExit.hasNext()){
            Persona poPersona = iteExit.next();
            if(poPersona != null)
                list.add((Persona) poPersona.clone());
        }
        return list;
    }
    
    public void startAnimation(){
        if(stateAnimation.compareTo(StateAnimation.PLAY) != 0){
            new Thread(panelAnimation).start();
            new Thread(thread).start();
            new Thread(labelThread).start();
            stateAnimation = StateAnimation.PLAY;
            Notifier.getNotificador().notificar(2);
        }
    }
    
    public void stopAnimation(){
        stateAnimation = StateAnimation.STOP;
    }
}
