
import javax.swing.JFrame;
import org.jvnet.substance.SubstanceLookAndFeel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pedro Ortiz M
 */
public class Main1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         JFrame.setDefaultLookAndFeelDecorated(true);
        org.jvnet.substance.SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.Business");
        SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.BusinessBlackSteelSkin");
        SubstanceLookAndFeel.setCurrentTheme( "org.jvnet.substance.theme.SubstanceLightAquaTheme ");
        SubstanceLookAndFeel.setCurrentWatermark("org.jvnet.substance.watermark.SubstanceBinaryWatermark");
      
        SubstanceLookAndFeel.setImageWatermarkOpacity(new Float(0.3));
        PrincipalCliente ventana = new PrincipalCliente();
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
    }
    
}
