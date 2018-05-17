/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simulpro.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import simulpro.modelo.logica.ControlModel;

/**
 *
 * @author Ariel Arnedo
 */
public class ActionAnimationListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "play":{
                if(!ControlModel.getControlModel().getAnimation().getPersonasProcesadas().isEmpty()){
                    ControlModel.getControlModel().getAnimation().getPersonasProcesadas().clear();
                }
                if(!ControlModel.getControlModel().getAnimation().getColaCaja().isEmpty()){
                    ControlModel.getControlModel().getAnimation().getColaCaja().clear();
                }
                if(!ControlModel.getControlModel().getAnimation().getColaAtencion().isEmpty()){
                    ControlModel.getControlModel().getAnimation().getColaAtencion().clear();
                }
                ControlModel.getControlModel().getAnimation().startAnimation();
                break;
            }
            case "stop":{
                ControlModel.getControlModel().getAnimation().stopAnimation();
                break;
            }
        }
    }
    
}
