package com.Polycake.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext {
    private final String serverName = "localhost";
    private final String dbName = "Polycake";
    private final String portNumber = "1433";
    private final String userID = "sa";       // TODO: Thay đổi username SQL của bạn
    private final String password = "123456";    // TODO: Thay đổi password SQL của bạn

    public Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber 
                   + ";databaseName=" + dbName + ";encrypt=false;";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, password);
    }
}