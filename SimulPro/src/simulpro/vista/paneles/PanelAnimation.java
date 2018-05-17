/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simulpro.vista.paneles;

import java.awt.Color;
import java.awt.Graphics;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import simulpro.modelo.logica.ControlModel;
import simulpro.modelo.logica.ImagePeople;
import simulpro.modelo.logica.Persona;
import simulpro.modelo.logica.StateAnimation;

/**
 *
 * @author Ariel Arnedo
 */
public class PanelAnimation extends RootPanel implements Runnable{

    private final ControlModel controlModel = ControlModel.getControlModel();
    
    public PanelAnimation() {
        intComponent();
    }
   
    private void intComponent(){
        
    }
    
    @Override
    public void paintComponent(Graphics g){
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        try {
            g.drawImage(ImageIO.read(getClass().getClassLoader().getResource("simulpro/vista/iconos/fondo.jpg")), 0, 0, null);
        } catch (IOException ex) {
            Logger.getLogger(PanelAnimation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        g.setColor(Color.gray);
        g.fillRect(300, 100, 600, 15);
        
        g.setColor(new Color(212, 229, 225));
        g.fillRect(0, 0, 200, getHeight());
        try {
            g.drawImage(ImageIO.read(getClass().getClassLoader().getResource("simulpro/vista/iconos/cashier.png")), 80, 20, null);
            g.drawImage(ImageIO.read(getClass().getClassLoader().getResource("simulpro/vista/iconos/servant.png")), 80, 400, null);
        } catch (IOException ex) {
            Logger.getLogger(PanelAnimation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        List<Persona> list1 = controlModel.getAnimation().listPersonInBox();
        List<Persona> list2 = controlModel.getAnimation().listPersonInAttencion();
        List<Persona> list3 = controlModel.getAnimation().listPersonExit();
        
        int i = 0;
        int j = 0;
        int k = 0;
        for(Persona persona : list1){
            
            persona.moveInBox();
            g.drawImage(ImagePeople.createImagePeople(persona.getShape()), persona.getX() + 50 * i++, persona.getY() , this);
        }
        
        for(Persona persona: list2){
            persona.moveInAttention();
            g.drawImage(ImagePeople.createImagePeople(persona.getShape()), persona.getX() , persona.getY() - 50 * j++ , this);
        }
        
        for(Persona persona : list3){
            persona.moveExit();
            g.drawImage(ImagePeople.createImagePeople(persona.getShape()), persona.getX(), persona.getY(), this);
        }
    }

    
    @Override
    public void run() {
        while(true){
            if(controlModel.getAnimation().getStateAnimation().compareTo(StateAnimation.PLAY) == 0){
                this.repaint();
            }
            delay();
        }
    }
    
    private void delay(){
        try {
            Thread.sleep(15);
        } catch (InterruptedException ex) {
            Logger.getLogger(PanelAnimation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
