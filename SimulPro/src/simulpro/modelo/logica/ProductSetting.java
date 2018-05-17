/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simulpro.modelo.logica;

/**
 *
 * @author Ariel Arnedo
 */
public class ProductSetting {
    
    //probabilidades de compra
    private static double pFailure = 0.0248;
    private static double pConsumedOnlyDrinks = 0.2574;
    private static double pConsumedOnlyFoods = 0.1733;
    private static double pConsumedBoth = 0.5445;
    
    //
    private static double aCocidos = 0.1257;
    private static double aFritos = 0.3089 ;
    private static double aHornedos = 0.3633;
    private static double aMecatos = 0.1010;
    private static double aDulces = 0.1010;

    private static double bAgua = 0.1238;
    private static double bAzucaradas = 0.4257;
    private static double bCalientes = 0.0545;
    private static double blacteas = 0.1584;
    private static double bNaturales = 0.2376;
    
    private ProductSetting(){}

    public static double getpFailure() {
        return pFailure;
    }

    public static void setpFailure(double pFailure) {
        ProductSetting.pFailure = pFailure;
    }

    public static double getpConsumedOnlyDrinks() {
        return pConsumedOnlyDrinks;
    }

    public static void setpConsumedOnlyDrinks(double pConsumedOnlyDrinks) {
        ProductSetting.pConsumedOnlyDrinks = pConsumedOnlyDrinks;
    }

    public static double getpConsumedOnlyFoods() {
        return pConsumedOnlyFoods;
    }

    public static void setpConsumedOnlyFoods(double pConsumedOnlyFoods) {
        ProductSetting.pConsumedOnlyFoods = pConsumedOnlyFoods;
    }

    public static double getpConsumedBoth() {
        return pConsumedBoth;
    }

    public static void setpConsumedBoth(double pConsumedBoth) {
        ProductSetting.pConsumedBoth = pConsumedBoth;
    }

    public static double getaCocidos() {
        return aCocidos;
    }

    public static void setaCocidos(double aCocidos) {
        ProductSetting.aCocidos = aCocidos;
    }

    public static double getaFritos() {
        return aFritos;
    }

    public static void setaFritos(double aFritos) {
        ProductSetting.aFritos = aFritos;
    }

    public static double getaHornedos() {
        return aHornedos;
    }

    public static void setaHornedos(double aHornedos) {
        ProductSetting.aHornedos = aHornedos;
    }

    public static double getaMecatos() {
        return aMecatos;
    }

    public static void setaMecatos(double aMecatos) {
        ProductSetting.aMecatos = aMecatos;
    }

    public static double getaDulces() {
        return aDulces;
    }

    public static void setaDulces(double aDulces) {
        ProductSetting.aDulces = aDulces;
    }

    public static double getbAgua() {
        return bAgua;
    }

    public static void setbAgua(double bAgua) {
        ProductSetting.bAgua = bAgua;
    }

    public static double getbAzucaradas() {
        return bAzucaradas;
    }

    public static void setbAzucaradas(double bAzucaradas) {
        ProductSetting.bAzucaradas = bAzucaradas;
    }

    public static double getbCalientes() {
        return bCalientes;
    }

    public static void setbCalientes(double bCalientes) {
        ProductSetting.bCalientes = bCalientes;
    }

    public static double getBlacteas() {
        return blacteas;
    }

    public static void setBlacteas(double blacteas) {
        ProductSetting.blacteas = blacteas;
    }

    public static double getbNaturales() {
        return bNaturales;
    }

    public static void setbNaturales(double bNaturales) {
        ProductSetting.bNaturales = bNaturales;
    }

    
    public static int pEleccionPr(double valueR){
        if(valueR >= 0 && valueR < pConsumedBoth){
            return 3; //Ambos
        }else if(valueR >= pConsumedBoth && valueR < pConsumedBoth + pConsumedOnlyDrinks){
            return 2; //Solo Bebidas
        }else if(valueR >= pConsumedBoth + pConsumedOnlyDrinks && valueR < pConsumedBoth + pConsumedOnlyDrinks + pConsumedOnlyFoods){
            return 1; //Solo Comida
        }else if(valueR >= pConsumedBoth + pConsumedOnlyDrinks + pConsumedOnlyFoods && valueR < 1.0){
            return 0;
        }else{
            throw new RuntimeException("numero aleatorio no valido");
        }
 }
    
    public static String tipoAlimento(double valueR){
       if(valueR >= 0.0 && valueR < aHornedos){
           return "Horneados";
       }else if(valueR >= aHornedos && valueR < aHornedos + aFritos){
           return "Frito";
       }else if(valueR >= aHornedos + aFritos && valueR < aHornedos + aFritos + aCocidos){
           return "Cocidos";
       }else if(valueR >= aHornedos + aFritos + aCocidos && valueR < aHornedos + aFritos + aCocidos + aMecatos){
           return "Mecatos";
       }else if(valueR >= aHornedos + aFritos + aCocidos + aMecatos && valueR < aHornedos + aFritos + aCocidos + aMecatos + aDulces){
           return "Dulces";
       }else{
           throw new RuntimeException("numero aleatorio no valido");
       }
    }
    
    public static String tipoBebida(double valueR){
       if(valueR >= 0.0 && valueR < bAzucaradas){
           return "Bebidas Azucaradas";
       }else if(valueR >= bAzucaradas && valueR < bAzucaradas + bNaturales){
           return "Bebidas Naturales";
       }else if(valueR >= bAzucaradas + bNaturales && valueR < bAzucaradas + bNaturales + blacteas){
           return "Bebidas Lácteas";
       }else if(valueR >= bAzucaradas + bNaturales + blacteas && valueR < bAzucaradas + bNaturales + blacteas + bAgua){
           return "Agua";
       }else if(valueR >= bAzucaradas + bNaturales + blacteas + bAgua && valueR < bAzucaradas + bNaturales + blacteas + bAgua + bCalientes){
           return "Bebidas Calientes";
       }else{
           throw new RuntimeException("numero aleatorio no valido");
       }
    }
}
