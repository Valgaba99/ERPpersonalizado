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
    private static String URL = "jdbc:mysql://localhost:3306/hospital";
    private static String Usuario = "root";
    private static String Contraseña = "root";
    
    public static Connection conectar(){
        Connection conexion = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, Usuario, Contraseña);
            System.out.println("Conexion establecida");
        }catch (Exception e){
            System.out.println("Error: " + e);
        }
        return conexion;
    }
}
