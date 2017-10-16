/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author kt
 */
public class ConexionAse {
 Connection cnn=null;
 
 public Connection ConexionAsedb(){
     try {
        Class.forName("com.mysql.jdbc.Driver" );
         cnn=DriverManager.getConnection("jdbc:mysql://localhost/Aseguradora","root","");
            JOptionPane.showMessageDialog(null,"Conexion Exitosa" );
     } catch (Exception e) {
          System.out.println(e);
     }
     return cnn;
 }
 
    public static void main(String[] args) {
       ConexionAse con=new ConexionAse();
       con.ConexionAsedb();
               
    }
    
}
