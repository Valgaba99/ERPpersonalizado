/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.erppersonalizado.Modelo;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ivanm
 */
public class Conexion {
    private static String Usuario = "root";
    private static String Contraseña = "root";
    
    public static Connection conectarCreacion(){
        Connection conexion = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/", Usuario, Contraseña);
        }catch (Exception e){
            System.out.println("Error: " + e);
        }
        return conexion;
    }
    public static Connection conectarBD(String nombreBD){
        Connection conexion = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+nombreBD, Usuario, Contraseña);
        }catch (Exception e){
            System.out.println("Error: " + e);
        }
        return conexion;
    }
}
