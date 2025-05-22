package com.example.javafx.DAO;

import java.util.ArrayList;

public interface DAOUsuario {

    public abstract ArrayList<String> devuelvePins (DAOManager dao);
    public abstract boolean cambioTurno (DAOManager dao, String pin, boolean trabajando);
    public boolean devuelveTrabajando (String pin, DAOManager dao);
    public boolean UsuarioEsAdmin(String pin, DAOManager dao);
    public String ListaAdmin(DAOManager dao);
}
