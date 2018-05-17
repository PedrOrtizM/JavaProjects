/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor_rmi.ventanas;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.UnsupportedLookAndFeelException;
import org.jvnet.substance.SubstanceLookAndFeel;
/**
 *
 * @author Andres Ramirez
 */
public class Servidor_rmi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Servidor_rmi.class.getName()).log(Level.SEVERE, null, ex);
        }
      
           JFrame.setDefaultLookAndFeelDecorated(true);
        org.jvnet.substance.SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.Business");
        SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.BusinessBlackSteelSkin");
        SubstanceLookAndFeel.setCurrentTheme( "org.jvnet.substance.theme.SubstanceLightAquaTheme ");
        SubstanceLookAndFeel.setCurrentWatermark("org.jvnet.substance.watermark.SubstanceBinaryWatermark");
      
        SubstanceLookAndFeel.setImageWatermarkOpacity(new Float(0.3));
        VentanaRMIServerl vent = new VentanaRMIServerl();
        vent.setVisible(true);
    }
 
}
