package com.example.javafx.controller;

import com.example.javafx.DAO.DAOManager;
import com.example.javafx.DAO.DAOUsuarioSQL;
import com.example.javafx.models.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class HelloController {
    @FXML
    private Label welcomeText;

    public static boolean existePin(String pin, DAOManager dao) {
        DAOUsuarioSQL daoUsuario = new DAOUsuarioSQL();
        ArrayList<String> pins = daoUsuario.devuelvePins(dao);
        if (pins.contains(pin)) {
            return true;
        }
        return false;
    }

    public static boolean cambioTurno(DAOManager dao, String pin, boolean trabajando){
        DAOUsuarioSQL daoUsuario = new DAOUsuarioSQL();
        return daoUsuario.cambioTurno(dao, pin, trabajando);
    }

    public static boolean devuelveTrabajando (String pin, DAOManager dao) {
        DAOUsuarioSQL daoUsuario = new DAOUsuarioSQL();
        return daoUsuario.devuelveTrabajando(pin, dao);
    }

    public static boolean UsuarioEsAdmin(String pin, DAOManager dao) {
        DAOUsuarioSQL daoUsuario = new DAOUsuarioSQL();
        return daoUsuario.UsuarioEsAdmin(pin, dao);
    }

    public static String ListaAdmin(DAOManager dao) {
        DAOUsuarioSQL daoUsuario = new DAOUsuarioSQL();
        return daoUsuario.ListaAdmin(dao);
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }


}