package com.cognizantTest.repositary;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/medicalLaboratory_DB";
    private static final String user = "root";
    private static final String password = "root";

    public static Connection getConnection() throws Exception{
        return DriverManager.getConnection(URL, user, password);
    }
}
