package com.billing;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection() {
        Connection con = null;
        try {
            String url = "jdbc:mysql://localhost:3306/billing_db";
            String user = "root";
            String password = "nishant7007"; 

            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}