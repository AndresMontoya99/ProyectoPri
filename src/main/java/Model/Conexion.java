/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author Andrew
 */
public class Conexion {
    
    private Connection conn = null;
    
    public Conexion() throws IOException {
        
        Properties props = new Properties();
        
        InputStream is = Conexion.class.getClassLoader().getResourceAsStream("app.properties");
        //InputStream is = new FileInputStream("app.properties");
        props.load(is);
        is.close();

        try {
            conn = DriverManager.getConnection(props.getProperty("url"),props);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Connection getConexion(){
        return conn;
    }
    
    
    
}
