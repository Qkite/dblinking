package com.dbexcercise;

import java.sql.*;
import java.util.Map;

public class SimpleConnectionMaker {

    SimpleConnectionMaker(){

    }

    public Connection makeConnection() throws SQLException {
        Map<String, String> env = System.getenv();
        Connection c = DriverManager.getConnection(env.get("DB_HOST"), env.get("DB_USER"), env.get("DB_PASSWORD"));

        return c;

    }



}
