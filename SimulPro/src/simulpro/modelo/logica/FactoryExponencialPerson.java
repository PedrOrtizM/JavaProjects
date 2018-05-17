/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simulpro.modelo.logica;

import java.util.ArrayList;
import java.util.List;




/**
 *
 * @author Ariel Arnedo
 */
public class FactoryExponencialPerson {
    
    public static Persona createPersonWithTimesArrivals(){
        return new Persona
                (FactoryRandomVariable.getRandomVariableTimes().timeArrival(),
                        FactoryRandomVariable.getRandomVariableTimes().timeServiceBox(),
                                FactoryRandomVariable.getRandomVariableTimes().timeAttention());
    }
    
    public static Persona createPersonWithGender(){
        Persona persona = createPersonWithTimesArrivals();
        persona.setGenero(TimesSetting.getTimeSetting().getGenero(FactoryRandomVariable.getRandomVariableTimes().getNumberAleatory()));
        persona.setTipo(TimesSetting.getTimeSetting().isTipo(FactoryRandomVariable.getRandomVariableTimes().getNumberAleatory()));
        persona.setShape(TimesSetting.getTimeSetting().getShape(persona.getGenero(), persona.getTipo()));
        
        return persona;
    }
    
    public static Persona createPersonWithAllAtributes(){
        Persona persona = createPersonWithGender();
        persona.setProductosComprados(createListProducts());
        return persona;
    }
    
    private static List<String> createListProducts(){
        List<String> list = null;
        
        int index = ProductSetting.pEleccionPr(FactoryRandomVariable.getRandomVariableTimes().getNumberAleatory());
        if(index == 0)
            return null;
        
               
        for (int i = 1; i <= index ; i++){
            switch(i){
                case 1:{
                    list = new ArrayList<>(1);
                    list.add(ProductSetting.tipoAlimento(FactoryRandomVariable.getRandomVariableTimes().getNumberAleatory()));
                    break;
                }
                case 2:{
                    list = new ArrayList<>(1);
                    list.add(ProductSetting.tipoBebida(FactoryRandomVariable.getRandomVariableTimes().getNumberAleatory()));
                    break;
                }
                case 3:{
                    list = new ArrayList<>(2);
                    list.add(ProductSetting.tipoAlimento(FactoryRandomVariable.getRandomVariableTimes().getNumberAleatory()));
                    list.add(ProductSetting.tipoBebida(FactoryRandomVariable.getRandomVariableTimes().getNumberAleatory()));
                    break;
                }
            }
        }
        return list;
    }
}
