/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simulpro.modelo.logica;


import simulpro.modelo.util.generator.CongruencialMixto;

/**
 *
 * @author Ariel Arnedo
 */
public class FactoryRandomVariable {
    
    private final java.util.Stack<Integer> timesArrivals;
    private final java.util.Stack<Integer> timesServicesToBox;
    private final java.util.Stack<Integer> timesServicesToAttention;
    private final java.util.Stack<Double>  numberAleatory;
    
    private static FactoryRandomVariable factoryRandomVariable = null;
    
    private FactoryRandomVariable(){
        numberAleatory = new java.util.Stack<>();
        timesArrivals = createStackTimes(createTimeArrivals
                        (CongruencialMixto.createNumbersAleatory(31, 11, 41, 5237), TimesSetting.getTimeSetting().getTimeLambdaBetwwenArrivals()));
        timesServicesToBox = createStackTimes(createTimeArrivals
                        (CongruencialMixto.createNumbersAleatory(73, 11, 5, 5237), TimesSetting.getTimeSetting().getTimeLambdaServiceTobox()));
        timesServicesToAttention = createStackTimes(createTimeArrivals
                        (CongruencialMixto.createNumbersAleatory(3, 11, 5, 5237), TimesSetting.getTimeSetting().getTimeLambdaServiceAttention()));
        numberAleatory.addAll(CongruencialMixto.createListNumbersAleatory(3, 11, 5, 5237));
    }
    
    public static FactoryRandomVariable getRandomVariableTimes(){
        if(factoryRandomVariable == null){
            factoryRandomVariable = new FactoryRandomVariable();
        }
        return factoryRandomVariable;
    } 
    
    public double getNumberAleatory(){
        return numberAleatory.pop();
    }
    
    public int timeArrival() {
         return timesArrivals.pop();
    }
    
    public int timeServiceBox() {
         return timesServicesToBox.pop();
    }
    
    public int timeAttention() {
         return timesServicesToAttention.pop();
    }
    
    private java.util.Stack<Integer> createStackTimes(int times[]){
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        for (Integer integer : times) {
            stack.add(integer);
        }
        return stack;
    }
    
    private int[] createTimeArrivals(double numberAleatory[], double lambda){
        int[] times = new int[numberAleatory.length];
        for(int i = 0 ; i < numberAleatory.length ; i++){
            times[i] = (int) utilities.distribution.Distribution.exponential(lambda, numberAleatory[i]);
        }
        return times;
    }
}
