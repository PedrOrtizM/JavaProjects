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
public class TimesSetting {
    
    private static TimesSetting timesSetting = null;
    
    private double timeLambdaBetwwenArrivals;
    private double timeLambdaServiceTobox;
    private double timeLambdaServiceAttention;
    
    private double pSuccessMan;
    private double pSuccessWoman;
    private double pSuccessChild;
    private double pSuccessYoung;
    private double pSuccessAdult;
    
    private TimesSetting(){
        timeLambdaBetwwenArrivals = 1.0/62.54;
        timeLambdaServiceTobox = 1.0/62.60;
        timeLambdaServiceAttention = 1.0/68.46;
        
        pSuccessMan = 0.5100;
        pSuccessWoman = 0.4900;
        
        pSuccessChild = 0.0095;
        pSuccessAdult =  0.1190;  
        pSuccessYoung = 0.8715; 
    }
    
    public static TimesSetting getTimeSetting(){
        if(timesSetting == null){
            timesSetting = new TimesSetting();
        }
        return timesSetting;
    }

    public double getTimeLambdaBetwwenArrivals() {
        return timeLambdaBetwwenArrivals;
    }

    public void setTimeLambdaBetwwenArrivals(double timeLambdaBetwwenArrivals) {
        this.timeLambdaBetwwenArrivals = timeLambdaBetwwenArrivals;
    }

    public double getTimeLambdaServiceTobox() {
        return timeLambdaServiceTobox;
    }

    public void setTimeLambdaServiceTobox(double timeLambdaServiceTobox) {
        this.timeLambdaServiceTobox = timeLambdaServiceTobox;
    }

    public double getTimeLambdaServiceAttention() {
        return timeLambdaServiceAttention;
    }

    public void setTimeLambdaServiceAttention(double timeLambdaServiceAttention) {
        this.timeLambdaServiceAttention = timeLambdaServiceAttention;
    }

    public double getpSuccessMan() {
        return pSuccessMan;
    }

    public void setpSuccessMan(double pSuccessMan) {
        this.pSuccessMan = pSuccessMan;
    }

    public double getpSuccessWoman() {
        return pSuccessWoman;
    }

    public void setpSuccessWoman(double pSuccessWoman) {
        this.pSuccessWoman = pSuccessWoman;
    }

    public double getpSuccessChild() {
        return pSuccessChild;
    }

    public void setpSuccessChild(double pSuccessChild) {
        this.pSuccessChild = pSuccessChild;
    }

    public double getpSuccessYoung() {
        return pSuccessYoung;
    }

    public void setpSuccessYoung(double pSuccessYoung) {
        this.pSuccessYoung = pSuccessYoung;
    }

    public double getpSuccessAdult() {
        return pSuccessAdult;
    }

    public void setpSuccessAdult(double pSuccessAdult) {
        this.pSuccessAdult = pSuccessAdult;
    }
    
    public String getShape(String genero, String tipo){
        if(genero.compareTo("Mujer") == 0){
            if(tipo.compareTo("Niño") == 0)
                return "GIRL";
            else if(tipo.compareTo("Joven") == 0)
                return "WOMAN";
            else
                return "GRANDMOTHER";
        }else{
            if(tipo.compareTo("Niño") == 0)
                return "BOY";
            else if(tipo.compareTo("Joven") == 0)
                return "MAN";
            else
                return "GRANDFATHER";
        }
    }
    
    public String getGenero(double numberAleatory){
        if(numberAleatory < this.pSuccessMan){
            return "Mujer";//////// Es mujer
        }else{
            return "Hombre";
        }
    }
    
    
    public String isTipo( double numberAleatory){
        if(numberAleatory >= 0.0 && numberAleatory < pSuccessYoung)
            return "Joven";
        else if(numberAleatory >= pSuccessYoung && numberAleatory < pSuccessYoung + pSuccessAdult){
            return "Adulto";
        }else if( numberAleatory >= pSuccessYoung + pSuccessAdult && numberAleatory < 1.0){
            return "Niño";
        }else{
            throw new RuntimeException("Numero aleatorio no se encuentra en el rango 0.0 a 1.0");
        }
    }
//        if(numberAleatory < this.pSuccessChild){
//            return 0;    ///////////// Menor
//        }else{
//            if(numberAleatory>this.pSuccessChild && numberAleatory < this.pSuccessMan + this.pSuccessYoung){
//              return 1; ///////////////// Joven
//            }else{
//                return 2;//////////////// Adulto
//                }            
//            }
//        }
}
