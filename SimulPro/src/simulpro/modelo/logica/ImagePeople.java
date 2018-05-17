/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simulpro.modelo.logica;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Ariel Arnedo
 */
public class ImagePeople {
    public static BufferedImage createImagePeople(String tipo){
        try{
            switch(tipo){
                case "GIRL":
                    return ImageIO.read(ImagePeople.class.getClassLoader().getResource("simulpro/vista/iconos/girl.png"));
                case "BOY":
                    return ImageIO.read(ImagePeople.class.getClassLoader().getResource("simulpro/vista/iconos/boy.png"));
                case "WOMAN":
                    return ImageIO.read(ImagePeople.class.getClassLoader().getResource("simulpro/vista/iconos/woman.png"));
                case "MAN":
                    return ImageIO.read(ImagePeople.class.getClassLoader().getResource("simulpro/vista/iconos/man.png"));
                case "GRANDFATHER":
                    return ImageIO.read(ImagePeople.class.getClassLoader().getResource("simulpro/vista/iconos/grandfather.png"));
                case "GRANDMOTHER":
                    return ImageIO.read(ImagePeople.class.getClassLoader().getResource("simulpro/vista/iconos/grandmother.png"));
                default:
                    throw new RuntimeException("Tipo de imagen no valida");
            }
        }catch(IOException ex){
            throw new RuntimeException("Imagen No Cargada");
        }
    }
}
