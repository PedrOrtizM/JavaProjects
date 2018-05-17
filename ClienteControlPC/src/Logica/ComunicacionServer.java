/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import sun.net.www.http.HttpClient;

/**
 *
 * @author Pedro Ortiz M
 */
public class ComunicacionServer {

    private static final String USER_AGENT = "Chrome/58.0.3029.96";

    public ComunicacionServer() {
        
        
    }

    public void enviarUsuario(String nombre, String pass, String url) {

        //Creamos un objeto JSON
        JSONObject jsonObj = new JSONObject();
        //Añadimos el nombre y pass del usuario
        jsonObj.put("nombre", nombre);
        jsonObj.put("pass", pass);
        

        StringBuffer response = enviarJSON(jsonObj,url);
         
            //cerramos la conexión
            if(response!=null){
      //      System.out.println("RESPUESTA : "+response);
//            int i =  Integer.parseInt(response.toString());
//            if(i!=-1){JOptionPane.showMessageDialog(null, "BIENVENIDO AL SISTEMA\n Tiempo Disponible: "+i);}  
//            if(i==-1){JOptionPane.showMessageDialog(null, "USUARIO NO REGISTRADO EN EL SISTEMA");}
            }
          
           
    }
    
    
       
    public void actualizarTiempo(int tiempo,String nombre,String pass,String url){
    
    JSONObject jsonObj = new JSONObject();
    jsonObj.put("tiempo", tiempo);
    jsonObj.put("nombre", nombre);
    jsonObj.put("pass", pass);
    enviarJSON(jsonObj, url);
    
    
    }
    
    
    public void enviarSesionApps(Date inicio, Date fin,String ip,String nombre,String pass,String url,ArrayList<String>Apps){
        
   JSONObject jsonObj = new JSONObject();
    jsonObj.put("FechaInicio", inicio);
    jsonObj.put("FechaFin", fin);
    jsonObj.put("ip", ip);
    jsonObj.put("nombre", nombre);
    jsonObj.put("pass", pass);
    // PARA LAS APLICACIONES
     jsonObj.put("tamano", Apps.size());
    for(int i=0;i<Apps.size();i++){
            jsonObj.put(i, Apps.get(i));

    }

    enviarJSON(jsonObj, url);
        
    
    
    }
    public void enviarApps(ArrayList<String>Apps,String nombre,String pass,String url){
    JSONObject jsonObj = new JSONObject();
    jsonObj.put("nombre", nombre);
    jsonObj.put("pass", pass);
   
        enviarJSON(jsonObj, url);

    
    
    
    
    }
    
    
    
    
    
    
    

    private StringBuffer enviarJSON(JSONObject jsonObj, String url) {
         //Creamos una lista para almacenar el JSON
        List l = new LinkedList();
        l.addAll(Arrays.asList(jsonObj));
        //Generamos el String JSON
        String jsonString = JSONValue.toJSONString(l);
        System.out.println("JSON GENERADO:");
        System.out.println(jsonString);
        System.out.println("");

        try {
            //Codificar el json a URL
            jsonString = URLEncoder.encode(jsonString, "UTF-8");

            //Creamos un nuevo objeto URL con la url donde queremos enviar el JSON
            URL obj = new URL(url);
            //Creamos un objeto de conexión
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            //Añadimos la cabecera
            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", USER_AGENT);
            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            
            //Creamos los parametros para enviar
            String urlParameters = "json=" + jsonString;
            // Enviamos los datos por POST
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.flush();
            wr.close();
            //       Capturamos la respuesta del servidor
         //   int responseCode = con.getResponseCode();
//            System.out.println("\nSending 'POST' request to URL : " + url);
//            System.out.println("Post parameters : " + urlParameters);
//            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            //Mostramos la respuesta del servidor por consola
         
            //cerramos la conexión
            System.out.println(response);
                     
            in.close();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            
        }

    return null;
    
    }
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public String obtenerJSON() {

        StringBuffer response = null;

        try {
            //Generar la URL
            String url = "http://localhost/controlPC/prueba.php";
            //Creamos un nuevo objeto URL con la url donde pedir el JSON
            URL obj = new URL(url);
            //Creamos un objeto de conexión
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            //Añadimos la cabecera
            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", USER_AGENT);
            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            // Enviamos la petición por POST
            con.setDoOutput(true);
            //Capturamos la respuesta del servidor
            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'POST' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            //Mostramos la respuesta del servidor por consola
            System.out.println("Respuesta del servidor: " + response);
            System.out.println();
            //cerramos la conexión
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response.toString();
        
        
    }

    
    
 


    private static void mostrarJSON(String json) {
        System.out.println("INFORMACIÓN OBTENIDA:");
        //Crear un Objeto JSON a partir del string JSON
        Object jsonObject = JSONValue.parse(json.toString());
        //Convertir el objeto JSON en un array

        //Iterar el array y extraer la información
        System.out.println(jsonObject);
    }
}
