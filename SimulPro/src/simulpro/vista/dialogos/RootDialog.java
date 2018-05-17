/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simulpro.vista.dialogos;

import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.Window;

/**
 *
 * @author Ariel Arnedo
 */
class RootDialog extends javax.swing.JDialog{

    public RootDialog() {
        super();
    }

    public RootDialog(Frame owner) {
        super(owner);
    }

    public RootDialog(Frame owner, boolean modal) {
        super(owner, modal);
    }
    
    protected javax.swing.JButton createButton(){
        javax.swing.JButton boton = new javax.swing.JButton();
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        boton.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
        boton.setBackground(new java.awt.Color(250, 250, 255));
        boton.setForeground(new java.awt.Color(5, 132, 249,255));
        return boton;
    }
     
    protected javax.swing.JButton createButtonMenu(){
        javax.swing.JButton boton = createButton();
        boton.setBorderPainted(true);
        boton.setBorder(javax.swing.BorderFactory
                .createEtchedBorder(
                        javax.swing.border.EtchedBorder.RAISED,
                        new java.awt.Color(152, 204, 255),
                        new java.awt.Color(152, 204, 255)));
        boton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 19));
        return boton;
    }
    
    protected javax.swing.JTextField createTextFieldChat(){
        final javax.swing.JTextField campo = new javax.swing.JTextField();
        campo.setFont(new java.awt.Font("Arial", 0, 17));
        campo.setForeground(new java.awt.Color(102, 102, 102));
        campo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        return campo;
    }
    
    protected void runThread(Runnable run){
        new Thread(run).start();
    }
}
