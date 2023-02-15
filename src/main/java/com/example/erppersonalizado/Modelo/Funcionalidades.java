package com.example.erppersonalizado.Modelo;


import java.io.FileNotFoundException;
import java.sql.*;

public class Funcionalidades {

    public void insertarCliente(String isbn, String titulo, Integer numeropagina, String idioma, String fechalanzamiento, String categoria, String sinopsis, String editorial) throws ClassNotFoundException, SQLException, FileNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");
        Statement stmt = conexion.createStatement();

        PreparedStatement acctualiza = conexion.prepareStatement("INSERT INTO libro(isbn, titulo, numeropagina, idioma, fechalanzamiento, categoria, sinopsis, editorial) VALUES( ?, ?, ?, ?, ?, ?, ?, ?) ");


        acctualiza.setString(1, isbn);
        acctualiza.setString(2, titulo);
        acctualiza.setInt(3, numeropagina);
        acctualiza.setString(4, idioma);
        acctualiza.setString(5, fechalanzamiento);
        acctualiza.setString(6, categoria);
        acctualiza.setString(7, sinopsis);
        acctualiza.setString(8, editorial);

        int filActualizadas = acctualiza.executeUpdate();
        stmt.close();

    }
    public boolean esSoloNumeros(String cadena) {
        for (int x = 0; x < cadena.length(); x++) {
            char c = cadena.charAt(x);
            // Si no está entre 0 y 9
            if (!(c >= '0' && c <= '9')) {
                return false;
            }
        }
        return true;
    }
}


