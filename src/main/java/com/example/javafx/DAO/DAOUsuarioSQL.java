package com.example.javafx.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class DAOUsuarioSQL implements DAOUsuario{
    @Override
    public ArrayList<String> devuelvePins (DAOManager dao) {
        ArrayList<String> pins = new ArrayList<>();
        String sentencia = "SELECT pin FROM trabajador";
        try {
            dao.open();
            PreparedStatement ps = dao.getConn().prepareStatement(sentencia);
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    pins.add(rs.getString("pin"));
                }
            }
            dao.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return pins;
    }

    @Override
    public boolean devuelveTrabajando (String pin, DAOManager dao) {
        boolean salida = false;
        String sentencia = "SELECT trabajando FROM trabajador WHERE pin = '" + pin + "'";
        try {
            dao.open();
            PreparedStatement ps = dao.getConn().prepareStatement(sentencia);
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next())
                    salida = rs.getBoolean("trabajando");
            }
            dao.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return salida;
    }

    @Override
    public boolean cambioTurno (DAOManager dao, String pin, boolean trabajando) {
        String sentencia;
        if (trabajando)
            sentencia = "UPDATE trabajador SET trabajando = 0 WHERE pin = '" + pin + "'";
        else
            sentencia = "UPDATE trabajador SET trabajando = 1 WHERE pin = '" + pin + "'";
        String sentencia2 = "UPDATE trabajador SET fechaFichaje = '" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")) + "' WHERE pin = '" + pin + "'";
        try {
            dao.open();
            Statement stmt = dao.getConn().createStatement();
            stmt.executeUpdate(sentencia);
            stmt.executeUpdate(sentencia2);
            dao.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean UsuarioEsAdmin(String pin, DAOManager dao) {
        String sentencia = "SELECT esAdmin FROM trabajador WHERE pin = '" + pin + "'";
        boolean salida = false;
        try {
            dao.open();
            PreparedStatement ps = dao.getConn().prepareStatement(sentencia);
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next())
                    salida = rs.getBoolean("esAdmin");
            }
            dao.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return salida;
    }

    public String ListaAdmin(DAOManager dao) {
        String sentencia = "SELECT nombreTrabajador, codTrabajador, trabajando, fechaFichaje FROM trabajador WHERE esAdmin = '0'";
        String salida = "";
        try {
            dao.open();
            PreparedStatement ps = dao.getConn().prepareStatement(sentencia);
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()) {
                    salida += rs.getString("nombreTrabajador") + " - ";
                    salida += rs.getString("codTrabajador") + " - ";
                    salida += (rs.getBoolean("trabajando") ? "Entrada" : "Salida") + " - ";
                    salida += rs.getDate("fechaFichaje") + " - ";
                    salida += rs.getTime("fechaFichaje") + "\n";
                }
            }
            dao.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return salida;
    }
}
