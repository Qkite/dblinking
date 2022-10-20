package com.dbexcercise.connection_practice.dao;

import com.dbexcercise.User;
import com.dbexcercise.connection_practice.connectionmaker.MakeConnection;

import java.sql.*;

public class UserDao00 {
    public void add() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        MakeConnection makeConnection = new MakeConnection();
        Connection connection = makeConnection.makeConnection();

        PreparedStatement ps = connection.prepareStatement("INSERT INTO users(id, name, password) VALUES(?, ?, ?)");
        ps.setString (1, "2");
        ps.setString(2, "Yeonji");
        ps.setString(3,"45678");

        ps.executeUpdate();
        ps.close();
        connection.close();

    }


    public User findById(String id) throws ClassNotFoundException, SQLException {


        Class.forName("com.mysql.cj.jdbc.Driver");
        MakeConnection makeConnection = new MakeConnection();
        Connection connection = makeConnection.makeConnection();

        PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE id = ?");

        ps.setString(1,id);

        ResultSet rs = ps.executeQuery();

        rs.next();
        String[] outputs = {rs.getString(1), rs.getString(2),  rs.getString(3)};

        rs.close();
        ps.close();
        connection.close();

        return new User(outputs[0], outputs[1], outputs[2]);

    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserDao00 userDao00 = new UserDao00();
        userDao00.add();

    }

}
