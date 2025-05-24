//package com.studentPortalRegistration;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class DBConnection {
//    private static final String URL      = "jdbc:mysql://localhost:3306/student_portal";
//    private static final String USERNAME = "root";
//    private static final String PASSWORD = "admin";
//
//    public static Connection getConnection() throws SQLException {
//        // Load driver if needed:
//        // Class.forName("com.mysql.cj.jdbc.Driver");
//        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
//    }
//}


package com.studentPortalRegistration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/student_portal";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    public static Connection getConnection() throws SQLException {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC Driver not found.", e);
        }

        // Return connection
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

