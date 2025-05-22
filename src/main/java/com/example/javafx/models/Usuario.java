package com.example.javafx.models;

import com.example.javafx.DAO.DAOManager;
import com.example.javafx.DAO.DAOUsuarioSQL;

import java.util.ArrayList;

public class Usuario {
    // Atributos

    private int codTrabajador;
    private String nombreTrabajador;
    private String pin;
    private boolean trabajando;
    private boolean esAdmin;

    // Constructor

    public Usuario(int codTrabajador, String nombreTrabajador, String pin, boolean trabajando, boolean esAdmin) {
        this.codTrabajador = codTrabajador;
        this.nombreTrabajador = nombreTrabajador;
        this.pin = pin;
        this.trabajando = trabajando;
        this.esAdmin = esAdmin;
    }


    // Getters y Setters

    public int getCodTrabajador() {
        return codTrabajador;
    }

    public void setCodTrabajador(int codTrabajador) {
        this.codTrabajador = codTrabajador;
    }

    public String getNombreTrabajador() {
        return nombreTrabajador;
    }

    public void setNombreTrabajador(String nombreTrabajador) {
        this.nombreTrabajador = nombreTrabajador;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    // Otros metodos

    public boolean isTrabajando() {
        return trabajando;
    }

    public void setTrabajando(boolean trabajando) {
        trabajando = trabajando;
    }

    public boolean isEsAdmin() {
        return esAdmin;
    }

    public void setEsAdmin(boolean esAdmin) {
        this.esAdmin = esAdmin;
    }

}
