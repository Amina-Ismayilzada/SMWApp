//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package az.webapps.firstwebapp.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {
    private static final String DB_HOST = "jdbc:mysql://localhost:3306/mysql";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "Emmagraizel1";
    private static Connection connection;

    public DBConfig() {
    }

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DB_HOST, DB_USERNAME, DB_PASSWORD);
        } catch (Exception ex) {
            System.out.println("Cannot create database connection");
        }

        return connection;
    }
}
