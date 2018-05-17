/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simulpro.vista.componentes.beans;

import java.awt.Color;
import java.awt.Font;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.Border;
import simulpro.modelo.logica.ControlModel;
import simulpro.modelo.logica.StateAnimation;
import simulpro.modelo.logica.ThreadMove;

/**
 *
 * @author Ariel Arnedo
 */
public class LabelThread extends javax.swing.JLabel implements Runnable{

    private String timeExetution;
    
    private int second = 0;
    private int minute = 0;
    private int hour = 0;
    
    public LabelThread() {
        super("00:00:00");
    }

    @Override
    public Border getBorder() {
        return javax.swing.BorderFactory
                .createEtchedBorder(
                        javax.swing.border.EtchedBorder.RAISED,
                        new java.awt.Color(152, 204, 255),
                        new java.awt.Color(152, 204, 255));
    }

    @Override
    public int getHorizontalAlignment() {
        return javax.swing.SwingConstants.CENTER;
    }

    @Override
    public Font getFont() {
        return new java.awt.Font("Arial", java.awt.Font.BOLD, 36);
    }

    @Override
    public Color getForeground() {
        return new java.awt.Color(100, 200, 255);
    }
       
    
    public void run(){
        while(true){
            if(ControlModel.getControlModel().getAnimation().getStateAnimation().compareTo(StateAnimation.STOP) == 0 ||
                    ControlModel.getControlModel().getAnimation().getStateAnimation().compareTo(StateAnimation.PAUSE) == 0){
                delay(15);
                if(ControlModel.getControlModel().getAnimation().getStateAnimation().compareTo(StateAnimation.STOP) == 0){
                    second = 0;
                    minute = 0;
                    hour = 0;
                }
                    
            }else {
                 setCronometer();
                 setText(getCronometer());
                 delay((int)(1000*ControlModel.getControlModel().getAnimation().getAnimationSpeed()));
            }
        }
    }
    
    private void setCronometer(){
        if(hour == 4){
            ControlModel.getControlModel().getAnimation().setStateAnimation(StateAnimation.STOP);
            second = 0;
            minute = 0;
            hour = 0;
            Notifier.getNotificador().notificar(new Integer(1));
        }else{
            second++;
            if(second == 59){
                minute++;
                second = 0;
            }
            if(minute == 59){
                hour++;
                minute = 0;
            }
        }
    }
    
   private void delay(int delay){
        try {
            Thread.sleep(delay);
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadMove.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private String getCronometer(){
        StringBuilder sb = new StringBuilder();
        sb.append(hour < 10 ? "0"+hour : hour);
        sb.append(":");
        sb.append(minute < 10 ? "0"+minute : minute);
        sb.append(":");
        sb.append(second < 10 ? "0"+second : second);
        return sb.toString();
    }
}
