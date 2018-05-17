/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simulpro.modelo.logica;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;


/**
 *
 * @author Ariel Arnedo
 */
public class ThreadMove implements Runnable{
    
    private final ControlModel controlModel = ControlModel.getControlModel();
    private volatile long tiempoEntreLLegada;
    private volatile long tiempoServicioCaja;
    private JLabel labelProductos;

    public void setLabelProductos(JLabel labelProductos) {
        this.labelProductos = labelProductos;
    }
    
        
    private void update() throws Exception{
      
        if((System.currentTimeMillis() - tiempoEntreLLegada) 
                > (long)(controlModel.getAnimation().getPersonas().element().getTimeEntreLlegada()*controlModel.getAnimation().getAnimationSpeed())){

            tiempoEntreLLegada = System.currentTimeMillis();
            controlModel.getAnimation().getColaCaja().add(controlModel.getAnimation().getPersonas().poll().timeLLegada(System.currentTimeMillis()));
        }

        if(!controlModel.getAnimation().getColaCaja().isEmpty()){
            if((System.currentTimeMillis() - controlModel.getAnimation().getColaCaja().element().getTimeDeLLegada()) 
                    > (long)(controlModel.getAnimation().getColaCaja().element().getTimeCaja()*controlModel.getAnimation().getAnimationSpeed())){

                controlModel.getAnimation().getColaAtencion().add(controlModel.getAnimation().getColaCaja().poll().timeServicio(System.currentTimeMillis()));
            }
        }

        if(!controlModel.getAnimation().getColaAtencion().isEmpty()){
            List<Persona> list = controlModel.getAnimation().getColaAtencion();
            for(int i = 0; i < list.size() ; i++){
                if((System.currentTimeMillis() - list.get(i).getTimeDeLLegada()) 
                        > (long)(list.get(i).getTimeAtencion()*controlModel.getAnimation().getAnimationSpeed())){
                    labelProductos.setText(list.get(i).getCategoriasCompradas());
                    controlModel.getAnimation().getPersonasProcesadas().add(list.remove(i));
                }
            }
        }
//            System.out.println(controlModel.getAnimation().getColaCaja().size()+"\t"+controlModel.getAnimation().getColaAtencion().size());
        }
    
    public void run(){
        tiempoEntreLLegada = System.currentTimeMillis();
//        System.out.println("Personas en Caja\tPersonas en Atencion");
        while(true){
            if(controlModel.getAnimation().getStateAnimation().compareTo(StateAnimation.PLAY) == 0){
                try {
                    update();
                } catch (Exception ex) {}
            }
            delay();
        }
    }
    
     private void delay(){
        try {
            Thread.sleep(50);
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadMove.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
