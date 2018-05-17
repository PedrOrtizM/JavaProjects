/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorialweka;

import javax.activation.DataSource;
import weka.associations.Apriori;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;

/**
 *
 * @author Pedro Ortiz M
 */
public class AlgoritmoApriori {

    private String direccionBD;  // Atributo para la direccion de la Base de datos

    public AlgoritmoApriori(String direccionBD) { // Constructor para asignarle el valor ingresado
        this.direccionBD = direccionBD;
    }

    public Apriori Apriori() throws Exception { // Metodo para que genere el algoritmo apriori

        ConverterUtils.DataSource source = new ConverterUtils.DataSource(direccionBD); //Asignamos la ruta de la BD
        Instances data = source.getDataSet();
        Apriori modelo = new Apriori(); // nuevo modelo del algotimo a apriori
        modelo.buildAssociations(data);//metodo que genera todos los items setc con minimum support y 
        //minimum confidence.

        return modelo;

    }

}
