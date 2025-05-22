package com.example.javafx.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAOManager {
    private Connection conn = null;
    private final String URL = "jdbc:mysql://localhost:3306/mysql?autoReconnect=true&useSSL=false";
    private final String USER = "root";
    private final String PASS = "root";
    private static DAOManager singleton;

    private DAOManager() {
    }

    public static DAOManager getSingletonInstance() {
        if (singleton == null) {
            singleton = new DAOManager();
        }

        return singleton;
    }

    public Connection getConn() {
        return this.conn;
    }

    public void open() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conn = DriverManager.getConnection(this.URL, this.USER, this.PASS);
        } catch (Exception e) {
            throw e;
        }
    }

    public void close() throws Exception {
        try {
            if (this.conn != null) {
                this.conn.close();
            }

        } catch (Exception e) {
            throw e;
        }
    }
}
