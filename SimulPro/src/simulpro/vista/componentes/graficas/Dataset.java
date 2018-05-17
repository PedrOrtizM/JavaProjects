/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulpro.vista.componentes.graficas;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import simulpro.modelo.logica.Persona;

/**
 *
 * @author Pedro Ortiz M
 */
public class Dataset {

    public final String CATEGORIAS[] = {
        "Agua",
        "Bebidas Calientes",
        "Bebidas Azucaradas",
        "Bebidas Naturales",
        "Bebidas Lácteas",
        "Cocidos",
        "Dulces",
        "Horneados",
        "Mecatos",
        "Frito"
    };

    private final List<Persona> lista;

    public Dataset(List<Persona> lista) {
        this.lista = lista;
    }

    public JFreeChart generarGenero() {
        int num[] = {0, 0};
        for (Persona p : lista) {

            if (p.getGenero().equalsIgnoreCase("Hombre")) {
                num[0]++;

            }
            if (p.getGenero().equalsIgnoreCase("Mujer")) {
                num[1]++;
            }
        }

        return this.generarPieChart(num, "Hombre", "Mujer", "Genero");

    }

    public JFreeChart generarTipo() {
        int num[] = {0, 0, 0};
        for (Persona p : lista) {

            if (p.getTipo().equalsIgnoreCase("Joven")) {
                num[0]++;

            }
            if (p.getTipo().equalsIgnoreCase("Adulto")) {
                num[1]++;
            }
            if (p.getTipo().equalsIgnoreCase("Ñiño")) {
                num[2]++;
            }
        }

        return this.generarPieChart(num, "Joven", "Adulto", "Niño", "Tipo");
    }

    private JFreeChart generarPieChart(int[] num, String tipo1, String tipo2, String titulo) {

        DefaultPieDataset data = new DefaultPieDataset();
        data.setValue(tipo1, num[0]);
        data.setValue(tipo2, num[1]);
        JFreeChart jf = ChartFactory.createPieChart3D(titulo, data, true, true, Locale.US);

        return jf;
    }

    private JFreeChart generarPieChart(int[] num, String tipo1, String tipo2, String tipo3, String titulo) {

        DefaultPieDataset data = new DefaultPieDataset();
        data.setValue(tipo1, num[0]);
        data.setValue(tipo2, num[1]);
        data.setValue(tipo3, num[2]);
        JFreeChart jf = ChartFactory.createPieChart3D(titulo, data, true, true, Locale.US);

        return jf;
    }

    private void iniciarMapaProd(Map<String, Integer> mapaProd) {

        for (int i = 0; i < CATEGORIAS.length; i++) {

            mapaProd.put(CATEGORIAS[i], 0);

        }

    }

  
 
    public JFreeChart[] generarEstadisticas() {

        Map<String, Integer> mapaProd = new HashMap<>();
        Map<String, Integer> mapaProdMujer = new HashMap<>();
        Map<String, Integer> mapaProdHombre = new HashMap<>();
        Map<String, Integer> mapaProdJoven = new HashMap<>();
        Map<String, Integer> mapaProdAdulto = new HashMap<>();
        Map<String, Integer> mapaProdAdultoH = new HashMap<>();
        Map<String, Integer> mapaProdAdultoM = new HashMap<>();
        Map<String, Integer> mapaProdJovenH = new HashMap<>();
        Map<String, Integer> mapaProdJovenM = new HashMap<>();
        Map<String, Integer> mapaProdNinoH = new HashMap<>();
        Map<String, Integer> mapaProdNinoM = new HashMap<>();

        int i = 0, contM = 0, contH = 0, contJ = 0, contA = 0,
                contAH = 0, contAM = 0, contJH = 0, contJM = 0,
                contNH = 0, contNM = 0;
        iniciarMapaProd(mapaProd);
        iniciarMapaProd(mapaProdHombre);
        iniciarMapaProd(mapaProdMujer);
        iniciarMapaProd(mapaProdJoven);
        iniciarMapaProd(mapaProdAdulto);
        iniciarMapaProd(mapaProdAdultoH);
        iniciarMapaProd(mapaProdAdultoM);
        iniciarMapaProd(mapaProdJovenH);
        iniciarMapaProd(mapaProdJovenM);
        iniciarMapaProd(mapaProdNinoH);
        iniciarMapaProd(mapaProdNinoM);

        for (Persona persona : lista) {
            if (persona.getProductosComprados() == null) {
                continue;
            }
            for (String producto : persona.getProductosComprados()) {
                for (int k = 0; k < CATEGORIAS.length; k++) {
                    if (producto.equalsIgnoreCase(CATEGORIAS[k])) {
                        i = mapaProd.get(CATEGORIAS[k]) + 1;

                        mapaProd.put(CATEGORIAS[k], i);

                        if (persona.getGenero().equalsIgnoreCase("Mujer")) {
                            contM = mapaProdMujer.get(CATEGORIAS[k]) + 1;
                            mapaProdMujer.put(CATEGORIAS[k], contM);
                        }
                        if (persona.getGenero().equalsIgnoreCase("Hombre")) {
                            contH = mapaProdHombre.get(CATEGORIAS[k]) + 1;
                            mapaProdHombre.put(CATEGORIAS[k], contH);
                        }
                        if (persona.getTipo().equalsIgnoreCase("Joven")) {
                            contJ = mapaProdJoven.get(CATEGORIAS[k]) + 1;
                            mapaProdJoven.put(CATEGORIAS[k], contJ);
                        }
                        if (persona.getTipo().equalsIgnoreCase("Adulto")) {
                            contA = mapaProdAdulto.get(CATEGORIAS[k]) + 1;
                            mapaProdAdulto.put(CATEGORIAS[k], contA);
                        }
                        if (persona.getTipo().equalsIgnoreCase("Adulto") && persona.getGenero().equalsIgnoreCase("Hombre")) {
                            contAH = mapaProdAdultoH.get(CATEGORIAS[k]) + 1;
                            mapaProdAdultoH.put(CATEGORIAS[k], contAH);
                        }

                        if (persona.getTipo().equalsIgnoreCase("Adulto") && persona.getGenero().equalsIgnoreCase("Mujer")) {
                            contAM = mapaProdAdultoM.get(CATEGORIAS[k]) + 1;
                            mapaProdAdultoM.put(CATEGORIAS[k], contAM);
                        }
                        if (persona.getTipo().equalsIgnoreCase("Joven") && persona.getGenero().equalsIgnoreCase("Hombre")) {
                            contJH = mapaProdJovenH.get(CATEGORIAS[k]) + 1;
                            mapaProdJovenH.put(CATEGORIAS[k], contJH);
                        }
                        if (persona.getTipo().equalsIgnoreCase("Joven") && persona.getGenero().equalsIgnoreCase("Mujer")) {
                            contJM = mapaProdJovenM.get(CATEGORIAS[k]) + 1;
                            mapaProdJovenM.put(CATEGORIAS[k], contJM);

                        }

                        if (persona.getTipo().equalsIgnoreCase("Niño")) {
                            if (persona.getGenero().equalsIgnoreCase("Hombre")) {
                                contNH = mapaProdNinoH.get(CATEGORIAS[k]) + 1;
                                mapaProdNinoH.put(CATEGORIAS[k], contNH);

                            }
                            if (persona.getGenero().equalsIgnoreCase("Mujer")) {
                                contNM = mapaProdNinoM.get(CATEGORIAS[k]) + 1;
                                mapaProdNinoM.put(CATEGORIAS[k], contNM);

                            }

                        }
                    }

                }
            }
        }

        JFreeChart estadistica[] = new JFreeChart[16];
        estadistica[0] = this.generarGrafico(mapaProdMujer);
        estadistica[1] = this.generarGrafico(mapaProdHombre);
        estadistica[2] = this.generarGrafico(mapaProd);
        estadistica[3] = this.generarGrafico(mapaProdAdulto);
        estadistica[4] = this.generarGrafico(mapaProdJoven);
        estadistica[5] = this.comprados((HashMap<String, Integer>) mapaProdMujer, "Mujer");
        estadistica[6] = this.comprados((HashMap<String, Integer>) mapaProdHombre, "Hombre");
        estadistica[7] = this.comprados((HashMap<String, Integer>) mapaProd, "Productos");
        estadistica[8] = this.comprados((HashMap<String, Integer>) mapaProdAdulto, "Adulto");
        estadistica[9] = this.comprados((HashMap<String, Integer>) mapaProdJoven, "Joven");
        estadistica[10] = this.generarGrafico(mapaProdAdultoH);
        estadistica[11] = this.generarGrafico(mapaProdAdultoM);
        estadistica[12] = this.generarGrafico(mapaProdJovenH);
        estadistica[13] = this.generarGrafico(mapaProdJovenM);
        estadistica[14] = this.generarGrafico(mapaProdNinoH);
        estadistica[15] = this.generarGrafico(mapaProdNinoM);

        return estadistica;

    }


    private JFreeChart comprados(HashMap<String, Integer> mapa, String tipo) {
        int cont = 0;
        String menosComprado = "", masComprado = "";
        int vMenosComprado = 0, vMasComprado = 0;

        mapa = sortByValues((HashMap) mapa);
        for (Map.Entry<String, Integer> entry : mapa.entrySet()) {

            if (cont == 0) {
                menosComprado = entry.getKey();
                vMenosComprado = entry.getValue();
            }
            if (cont == mapa.size() - 1) {
                masComprado = entry.getKey();
                vMasComprado = entry.getValue();
            }
            cont++;
        }

        DefaultCategoryDataset data = new DefaultCategoryDataset();

        data.addValue(vMenosComprado, menosComprado, "Menos comprado");
        data.addValue(vMasComprado, masComprado, "Mas comprado");
        JFreeChart jf = ChartFactory.createBarChart(tipo, "", "Cantidad", data, PlotOrientation.HORIZONTAL, true, true, true);
        return jf;
    }

    private static HashMap sortByValues(HashMap map) {
        List list = new LinkedList(map.entrySet());

        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o1)).getValue())
                        .compareTo(((Map.Entry) (o2)).getValue());
            }
        });

        HashMap sortedHashMap = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }

    public JFreeChart promedios() {

        long timeLLegadaH = 0, timeCajaH = 0, timeAtencionH = 0,  numH = 0;
        long timeLLegadaM = 0, timeCajaM = 0, timeAtencionM = 0,  numM = 0;
        long timeServicioH = 0, timeServicioM = 0;

        for (Persona persona : lista) {

            if (persona.getGenero().equalsIgnoreCase("Hombre")) {
                numH++;
                timeLLegadaH = timeLLegadaH + persona.getTimeEntreLlegada()/1000;
                timeCajaH = timeCajaH + persona.getTimeCaja()/1000;
                timeAtencionH = timeAtencionH + persona.getTimeAtencion()/1000;
      //          timeServicioH = (long)(timeServicioH + persona.getTimeDeServicio()/1000.0);
         //         timeServicioH = timeServicioH +40;

            }
            if (persona.getGenero().equalsIgnoreCase("Mujer")) {
                numM++;
                timeLLegadaM = timeLLegadaM + persona.getTimeEntreLlegada()/1000;
                timeCajaM = timeCajaM + persona.getTimeCaja()/1000;
                timeAtencionM = timeAtencionM + persona.getTimeAtencion()/1000;
     //           timeServicioM = timeServicioM +20;
       //        timeServicioM = (long) (timeServicioM + persona.getTimeDeServicio()/1000.0);
            }

        }
        float promedioAtencionH = timeAtencionH / numH;
        float promedioLlegadaH = timeLLegadaH / numH;
        float promedioCajaH = timeCajaH / numH;
  //      float promedioServicioH = timeServicioH / numH;

        float promedioAtencionM = timeAtencionM / numM;
        float promedioLlegadaM = timeLLegadaM / numM;
        float promedioCajaM = timeCajaM / numM;
   //     float promedioServicioM = timeServicioM / numM;
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        data.addValue(promedioAtencionH, "Hombre", "Atención");
        data.addValue(promedioAtencionM, "Mujer", "Atención");
        data.addValue(promedioLlegadaH, "Hombre", "LLegada");
        data.addValue(promedioLlegadaM, "Mujer", "LLegada");
        data.addValue(promedioCajaH, "Hombre", "Caja");
        data.addValue(promedioCajaM, "Mujer", "Caja");
    //    data.addValue(promedioServicioH, "Hombre", "Servicio");
    //    data.addValue(promedioServicioM, "Mujer", "Servicio");

        JFreeChart jf = ChartFactory.createBarChart3D("PROMEDIOS", "Personas", "Segundos", data, PlotOrientation.VERTICAL, true, true, true);

        return jf;

    }

    public JFreeChart generarGrafico(Map<String, Integer> mapaProd) {
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        for (Map.Entry<String, Integer> entry : mapaProd.entrySet()) {

            data.addValue(entry.getValue(), entry.getKey(), "");
        }

        JFreeChart jf = ChartFactory.createBarChart3D("Productos", "Tipo", "Cantidad", data, PlotOrientation.VERTICAL, true, true, true);

        return jf;

    }

}
