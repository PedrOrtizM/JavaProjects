package simulpro.modelo.logica;

import java.util.List;

public class Bayes {

    private static double promHombre;
    private static double promMujer;
    private static List<Persona> hombres;
    private static List<Persona> mujeres;
    private static List<Persona> personasProcesadas;

    public Bayes() {
        mujeres = new java.util.ArrayList<>();
        hombres = new java.util.ArrayList<>();
        personasProcesadas = ControlModel.getControlModel().getAnimation().getPersonasProcesadas();
    }

    public double probabilidadCondicional(String genero, String producto) {

        int i = 0;
        System.out.println("Tmño personas procesds" + personasProcesadas.size());
        while (personasProcesadas.size() > i) {
            if (personasProcesadas.get(i).getGenero().equalsIgnoreCase("Mujer")) {
                mujeres.add(personasProcesadas.get(i));
            } else {
                hombres.add(personasProcesadas.get(i));
            }
            i++;
        }

        promHombre = (hombres.size() * 100) / personasProcesadas.size();
        promMujer = (mujeres.size() * 100) / personasProcesadas.size();
        System.out.println("Promedio hombres: " + promHombre);
        System.out.println("Promedio mujer: " + promMujer);
        return probabilidadBayes(genero, promedios(hombres), promedios(mujeres), producto);
    }

    private List<Double> promedios(List<Persona> personas) {

        int i = 0, bebidasAzucaradas = 0, bebidasNaturales = 0, bebidasLacteas = 0, agua = 0, bebidasCalientes = 0;
        int horneados = 0, fritos = 0, cocidos = 0, mecatos = 0, dulces = 0, noCompro = 0;

        List<Double> datos = new java.util.ArrayList<>();

        while (personas.size() > i) {
            if (personas.get(i).getProductosComprados() != null) {
                if (personas.get(i).getProductosComprados().contains("Bebidas Azucaradas")) {
                    bebidasAzucaradas++;
                }
                if (personas.get(i).getProductosComprados().contains("Bebidas Naturales")) {
                    bebidasNaturales++;
                }
                if (personas.get(i).getProductosComprados().contains("Bebidas Lácteas")) {
                    bebidasLacteas++;
                }
                if (personas.get(i).getProductosComprados().contains("Agua")) {
                    agua++;
                }
                if (personas.get(i).getProductosComprados().contains("Bebidas Calientes")) {
                    bebidasCalientes++;
                }
                if (personas.get(i).getProductosComprados().contains("Horneados")) {
                    horneados++;
                }
                if (personas.get(i).getProductosComprados().contains("Frito")) {
                    fritos++;
                }
                if (personas.get(i).getProductosComprados().contains("Cocidos")) {
                    cocidos++;
                }
                if (personas.get(i).getProductosComprados().contains("Mecatos")) {
                    mecatos++;
                }
                if (personas.get(i).getProductosComprados().contains("Dulces")) {
                    dulces++;
                }
            } else {
                noCompro++;
            }
            System.out.println(personas.get(i).getProductosComprados() + " Producto numero " + (i + 1));
            i++;
        }

        datos.add((double) (bebidasAzucaradas * 100) / personas.size());
        System.out.println("Bebidas azucaradas, probabilidad: " + ((double) (bebidasAzucaradas * 100) / personas.size()));
        datos.add((double) (bebidasNaturales * 100) / personas.size());
        datos.add((double) (bebidasLacteas * 100) / personas.size());
        datos.add((double) (agua * 100) / personas.size());
        datos.add((double) (bebidasCalientes * 100) / personas.size());
        datos.add((double) (horneados * 100) / personas.size());
        datos.add((double) (fritos * 100) / personas.size());
        datos.add((double) (cocidos * 100) / personas.size());
        datos.add((double) (mecatos * 100) / personas.size());
        datos.add((double) (dulces * 100) / personas.size());
        datos.add((double) (noCompro * 100) / personas.size());

        return datos;
    }

    private double probabilidadBayes(String genero, List<Double> promediosH, List<Double> promediosM, String producto) {
        double promedioProductoH = 0, promedioProductoM = 0, probabilidad = 0;
        if (producto.equalsIgnoreCase("Bebidas Azucaradas")) {
            promedioProductoH = promediosH.get(0);
            promedioProductoM = promediosM.get(0);
            System.out.println("Entró en bebidas azucaradas");
        } else if (producto.equalsIgnoreCase("Bebidas Naturales")) {
            promedioProductoH = promediosH.get(1);
            promedioProductoM = promediosM.get(1);
        } else if (producto.equalsIgnoreCase("Bebidas Lácteas")) {
            promedioProductoH = promediosH.get(2);
            promedioProductoM = promediosM.get(2);
        } else if (producto.equalsIgnoreCase("Agua")) {
            promedioProductoH = promediosH.get(3);
            promedioProductoM = promediosM.get(3);
            System.out.println("Entró en AGUA");
        } else if (producto.equalsIgnoreCase("Bebidas Calientes")) {
            promedioProductoH = promediosH.get(4);
            promedioProductoM = promediosM.get(4);
        } else if (producto.equalsIgnoreCase("Horneados")) {
            promedioProductoH = promediosH.get(5);
            promedioProductoM = promediosM.get(5);
        } else if (producto.equalsIgnoreCase("Frito")) {
            promedioProductoH = promediosH.get(6);
            promedioProductoM = promediosM.get(6);
        } else if (producto.equalsIgnoreCase("Cocidos")) {
            promedioProductoH = promediosH.get(7);
            promedioProductoM = promediosM.get(7);
        } else if (producto.equalsIgnoreCase("Mecatos")) {
            promedioProductoH = promediosH.get(8);
            promedioProductoM = promediosM.get(8);
        } else if (producto.equalsIgnoreCase("Dulces")) {
            promedioProductoH = promediosH.get(9);
            promedioProductoM = promediosM.get(9);
        } else {
            promedioProductoH = promediosH.get(10);
            promedioProductoM = promediosM.get(10);
        }
        if (genero.equalsIgnoreCase("Hombre")) {
            System.out.println("Probabilidad hombre ");
            return probabilidad = ((promHombre * promedioProductoH) / ((promHombre * promedioProductoH) + (promMujer * promedioProductoM)));
        } else {
            return probabilidad = ((promMujer * promedioProductoM) / ((promHombre * promedioProductoH) + (promMujer * promedioProductoM)));
        }
    }
}
