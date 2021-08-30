/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

// Importación de librerias necesarias para realizar la conexión
// Tener añadidas: json-simple-1.1.1.jar y mysql-connector-java-8.0.26.jar
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.*;
import org.json.simple.parser.*;

/**
 *
 * @author lenovo
 */
public class ConnectionDB {
    public static Connection getConnection()
    {
        //Get JSON Simple: https://code.google.com/archive/p/json-simple/downloads
    
        JSONParser parser = new JSONParser();
        Connection connection = null;
        
        // Try-catch para intentar conectarse a la base de datos a partir de las credenciales obtenidas del JSON
        
        try
        {
            // Guardar en string el path o camino en donde se debe buscar el json
            String credentials_path = System.getProperty("user.dir") + "/src/utils/db_creds.json";
            System.out.println(credentials_path);
            
            // Inicialización de objeto tipo JSONObject, leyéndo el dato desde las credenciales guardadas
            
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(credentials_path));
            
            // inicialización de variables en donde se asignan las credenciales para la conexión a la DB
            
            String host     = (String)jsonObject.get("db_ip");
            String port     = (String)jsonObject.get("dp_port");
            String username = (String)jsonObject.get("db_user");
            String password = (String)jsonObject.get("db_pssword");
            String dbName = (String) jsonObject.get("db_name");
            String dbURL = "jdbc:mysql://"+host+":"+port+"/"+dbName;
            
            // Se establece la conexión
            
            connection = DriverManager.getConnection(dbURL, username, password);
            
//            if(connection != null)
//                System.out.println("Conectado a "+ dbName);
            
        }
        catch(SQLException | FileNotFoundException ex)
        {
            ex.printStackTrace();
        }
        catch (IOException | ParseException ex) 
        {
            ex.printStackTrace();
        }
        
        return connection;
    }
    
    public static void main(String[] args)
    {
        getConnection();
    }
}
