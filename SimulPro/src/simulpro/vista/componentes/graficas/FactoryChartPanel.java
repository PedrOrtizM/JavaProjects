/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simulpro.vista.componentes.graficas;



import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;



/**
 *
 * @author Ariel Arnedo
 */
public class FactoryChartPanel {
    
    public static ChartPanel createCharPanel(JFreeChart freeChart){
        ChartPanel chartPanel = new ChartPanel(freeChart);
        return chartPanel;
    }
}
