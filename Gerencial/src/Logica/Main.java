/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.Conexion;
import Vista.PanelPrincipal;
import javax.swing.JFrame;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.utils.SubstanceConstants;
import org.jvnet.substance.watermark.SubstanceImageWatermark;

/**
 *
 * @author Pedro Ortiz M
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       JFrame.setDefaultLookAndFeelDecorated(true);
       
        org.jvnet.substance.SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.Business");
        SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.BusinessSkin");
        SubstanceLookAndFeel.setCurrentTheme( "org.jvnet.substance.theme.SubstanceLightAquaTheme ");
        SubstanceImageWatermark.setKind(SubstanceConstants.ImageWatermarkKind.APP_CENTER);
        SubstanceLookAndFeel.setCurrentWatermark("org.jvnet.substance.watermark.SubstanceBubblesWatermark");
        SubstanceLookAndFeel.setImageWatermarkOpacity(new Float(0.3));
        PanelPrincipal ventana = new PanelPrincipal();
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);

        
    }
    
}
