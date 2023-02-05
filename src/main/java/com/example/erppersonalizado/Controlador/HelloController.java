package com.example.erppersonalizado.Controlador;

import com.example.erppersonalizado.Modelo.Conexion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class HelloController implements Initializable{


        @FXML
        private Button bCrearBD;

        @FXML
        private Button bLogin;

        @FXML
        private Button bLogin1;

        @FXML
        private Button bRegistro;

        @FXML
        private Button bRegistro1;

        @FXML
        private TextField correoCliente;

        @FXML
        private TextField direccionCliente;

        @FXML
        private GridPane gpBD;

        @FXML
        private TextField nombreCliente;

        @FXML
        private Pane pInicio;

        @FXML
        private Pane pInicio1;

        @FXML
        private Pane pMedico;

        @FXML
        private Pane pMedico1;

        @FXML
        private Pane pMedico2;

        @FXML
        private Pane pMedico21;

        @FXML
        private TextField telCliente;

        @FXML
        private TextField tfContraseña;

        @FXML
        private TextField tfContraseña1;

        @FXML
        private TextField tfContraseña11;

        @FXML
        private TextField tfEmail;

        @FXML
        private TextField tfEmail1;

        @FXML
        private TextField tfNombreBD;

        @FXML
        private TextField webCliente;

        Conexion cbd = new Conexion();
        @Override
        public void initialize(URL url, ResourceBundle rb) {

        }
        @FXML
        void creaBD(ActionEvent e) throws SQLException {
            Connection conexion = cbd.conectarCreacion();
            Statement stmt = conexion.createStatement();
            String sql = "CREATE DATABASE "+tfNombreBD.getText();
            stmt.executeUpdate(sql);
            System.out.println("Base de datos creada.");
        }
    }

