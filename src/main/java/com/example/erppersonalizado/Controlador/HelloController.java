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
        private Pane popUpCrear;
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
            popUpCrear.setVisible(false);
            conexion.close();
            Connection conexion2 = cbd.conectarBD(tfNombreBD.getText());

            Statement stmtCreacion = conexion2.createStatement();
            String sqlCreacion = "CREATE TABLE IF NOT EXISTS `cliente` (\n" +
                    "  `id_cliente` int(11) NOT NULL,\n" +
                    "  `nombre` varchar(50) DEFAULT NULL,\n" +
                    "  `apellidos` varchar(50) DEFAULT NULL,\n" +
                    "  `correo` varchar(50) DEFAULT NULL,\n" +
                    "  `direccion` varchar(50) DEFAULT NULL,\n" +
                    "  `telefono` int(9) DEFAULT NULL,\n" +
                    "  PRIMARY KEY (`id_cliente`)\n" +
                    ") ";
            stmtCreacion.executeUpdate(sqlCreacion);
            sqlCreacion = "CREATE TABLE IF NOT EXISTS `proveedor` (\n" +
                    "  `id_proveedor` int(11) NOT NULL,\n" +
                    "  `nombre` varchar(50) DEFAULT NULL,\n" +
                    "  `correo` varchar(50) DEFAULT NULL,\n" +
                    "  `direccion` varchar(50) DEFAULT NULL,\n" +
                    "  `telefono` int(9) DEFAULT NULL,\n" +
                    "  PRIMARY KEY (`id_proveedor`)\n" +
                    ") ";
            stmtCreacion.executeUpdate(sqlCreacion);
            sqlCreacion = "CREATE TABLE IF NOT EXISTS `factura` (\n" +
                    "  `id_factura` int(11) NOT NULL,\n" +
                    "  `direccion` varchar(50) DEFAULT NULL,\n" +
                    "  `precio` float DEFAULT NULL,\n" +
                    "  `nombre_producto` float DEFAULT NULL,\n" +
                    "  `numero_producto` float DEFAULT NULL,\n" +
                    "  `fecha` date DEFAULT NULL,\n" +
                    "  `id_cliente` int(11) DEFAULT NULL,\n" +
                    "  `id_proveedor` int(11) DEFAULT NULL,\n" +
                    "  PRIMARY KEY (`id_factura`),\n" +
                    "  KEY `FK_factura_cliente` (`id_cliente`),\n" +
                    "  KEY `FK_factura_proveedor` (`id_proveedor`),\n" +
                    "  CONSTRAINT `FK_factura_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,\n" +
                    "  CONSTRAINT `FK_factura_proveedor` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedor` (`id_proveedor`) ON DELETE NO ACTION ON UPDATE NO ACTION\n" +
                    ") ";
            stmtCreacion.executeUpdate(sqlCreacion);
                sqlCreacion = "CREATE TABLE IF NOT EXISTS `producto` (\n" +
                        "  `id_producto` int(11) NOT NULL,\n" +
                        "  `nombre` varchar(50) DEFAULT NULL,\n" +
                        "  `tipo` varchar(50) DEFAULT NULL,\n" +
                        "  `costo` float DEFAULT NULL,\n" +
                        "  `precio` float DEFAULT NULL,\n" +
                        "  `id_proveedor` int(11) DEFAULT NULL,\n" +
                        "  PRIMARY KEY (`id_producto`),\n" +
                        "  KEY `FK_producto_proveedor` (`id_proveedor`),\n" +
                        "  CONSTRAINT `FK_producto_proveedor` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedor` (`id_proveedor`) ON DELETE NO ACTION ON UPDATE NO ACTION\n" +
                        ") ";
                stmtCreacion.executeUpdate(sqlCreacion);

                conexion2.close();

        }
    }

