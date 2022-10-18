package com.dbexcercise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;


// 추상 클래스 이용
public class AWSUserDaoImpl extends UserDaoAbstract {
    @Override
    public Connection makeConnection() throws SQLException {
        Map<String, String> env = System.getenv();
        Connection c = DriverManager.getConnection(env.get("DB_HOST"), env.get("DB_USER"), env.get("DB_PASSWORD"));
        return c;
    }
}
