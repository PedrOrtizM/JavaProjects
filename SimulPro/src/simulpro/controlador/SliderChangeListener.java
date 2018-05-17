/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simulpro.controlador;

import javax.swing.BoundedRangeModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import simulpro.modelo.logica.ControlModel;

/**
 *
 * @author Ariel Arnedo
 */
public class SliderChangeListener implements ChangeListener{

    @Override
    public void stateChanged(ChangeEvent e) {
        javax.swing.JSlider s1 = (javax.swing.JSlider) e.getSource();
        System.out.println((float)(1.0 / (s1.getValue()*10)));
        ControlModel.getControlModel().getAnimation().setAnimationSpeed((float)(1.0 / (s1.getValue()*10)));
        
    }
    
   
}
