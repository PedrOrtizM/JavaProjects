
package Logica;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;


public class controlTiempo {
    private Tiempo hora;
    private  Tiempo cronometro;
    Thread hiloHora;
    Thread hiloCronometro;

    public Thread getHiloHora() {
        return hiloHora;
    }

    public void setHiloHora(Thread hiloHora) {
        this.hiloHora = hiloHora;
    }

    public Thread getHiloCronometro() {
        return hiloCronometro;
    }

    public void setHiloCronometro(Thread hiloCronometro) {
        this.hiloCronometro = hiloCronometro;
    }
    
    
    public  void manejarHora(final JLabel JLHora){
              
     this.hiloHora = new Thread(){
  
   @Override       
   public void run(){
   
  for(;;){
                    
                    if (hora.getSegundos() == 59) {//si los segundos son iguales a 59
                        hora.setSegundos((short)0);//segundo vuelve a empezar en cero
                        hora.setMinutos((short) (hora.getMinutos()+1));//y aumenta un minuto
                    }
                    if (hora.getMinutos() == 59) {//si los minutos son iguales a 59
                        hora.setMinutos((short)0);//minuto vuelve a empezar en cero
                        hora.setHoras((short) (hora.getHoras()+1));//y aumenta una hora
                    }
                    if(hora.getHoras()==24){                    
                     hora.setHoras((short)0);
                    }
                    hora.setSegundos((short) (hora.getSegundos()+1));//aumentan las decimas de segundo
                 
                    JLHora.setText("Hora -> "+hora.getHoras()+" : "+hora.getMinutos()+" : "+hora.getSegundos());
                    
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        System.out.println(ex);
                    }
                }
       
   }
            
            
   };    
    
    
    
    }
    
    public void manejarCronometro(final JLabel JLtiempo){
       
      this.hiloCronometro = new Thread(){
             boolean ax=false;
            @Override
            public void run(){
                for(;;){ // for infinito para que corra hasta que se explote la memoria ram
                    if(cronometro.getMilisegundos()==10){
                    cronometro.setMilisegundos((short)0);
                    cronometro.setSegundos((short) (cronometro.getSegundos()+1));
                    }
                    
                    if (cronometro.getSegundos() == 59) {//si los segundos son iguales a 59
                        cronometro.setSegundos((short)0);//segundo vuelve a empezar en cero
                        cronometro.setMinutos((short) (cronometro.getMinutos()+1));//y aumenta un minuto
                    }
                    if (cronometro.getMinutos() == 59) {//si los minutos son iguales a 59
                        cronometro.setMinutos((short)0);//minuto vuelve a empezar en cero
                        cronometro.setHoras((short) (cronometro.getHoras()+1));//y aumenta una hora
                    }
                    
                                    
                    
                    JLtiempo.setText(""+cronometro.getHoras()+" : "+cronometro.getMinutos()+" : "+cronometro.getSegundos());
                            
                    
                    
                    cronometro.setMilisegundos((short) (cronometro.getMilisegundos()+1));//aumentan las decimas de segundo
                   
                   
                    
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                    }
                }
                
            }
            
        };
    
    
    
    }
    
    public controlTiempo() {
         GregorianCalendar HoraPC = new GregorianCalendar(); 
       short hora = (short)HoraPC.get(Calendar.HOUR_OF_DAY);
       short min= (short)HoraPC.get(Calendar.MINUTE);
       short seg=(short)HoraPC.get(Calendar.SECOND);
        
       this.hora = new Tiempo(hora,min,seg);
        
        cronometro = new Tiempo();
        
    }

    public void reiniciar(){
    
    cronometro.setHoras((short)0);
    cronometro.setMilisegundos((short)0);
    cronometro.setMinutos((short)0);
    cronometro.setSegundos((short)0);
    }
    
    public Tiempo getHora() {
        return hora;
    }

    public void setHora(Tiempo hora) {
        this.hora = hora;
    }

    public Tiempo getCronometro() {
        return cronometro;
    }

    public void setCronometro(Tiempo cronometro) {
        this.cronometro = cronometro;
    }
    
    
    
    
    
}
