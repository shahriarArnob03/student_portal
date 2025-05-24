package com.studentPortalRegistration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    /**  
     * Expects these three environment variables to be set in Railway’s UI:
     *   DB_URL  → jdbc:mysql://${MYSQLHOST}:${MYSQLPORT}/${MYSQLDATABASE}?serverTimezone=UTC&useSSL=false
     *   DB_USER → ${MYSQLUSER}
     *   DB_PASS → ${MYSQLPASSWORD}
     */
    public static Connection getConnection() throws SQLException {
        String url  = System.getenv("DB_URL");
        String user = System.getenv("DB_USER");
        String pass = System.getenv("DB_PASS");
        if (url == null || user == null) {
            throw new SQLException("Database credentials not set in environment");
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC Driver not found.", e);
        }

        return DriverManager.getConnection(url, user, pass);
    }
}
