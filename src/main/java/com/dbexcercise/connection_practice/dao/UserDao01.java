package com.dbexcercise.connection_practice.dao;

import com.dbexcercise.connection_with_abstract_class.domain.User;
import com.dbexcercise.connection_practice.connectionmaker.MakeConnectionWithInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao01 {
    public void add(User user) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        MakeConnectionWithInterface makeConnectionWithInterface = new MakeConnectionWithInterface();
        Connection connection = makeConnectionWithInterface.makeConnection();

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
        MakeConnectionWithInterface makeConnectionWithInterface = new MakeConnectionWithInterface();
        Connection connection = makeConnectionWithInterface.makeConnection();

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
        UserDao01 userDao01 = new UserDao01();
        userDao01.add(new User("11", "Hello", "112233"));

    }
}
