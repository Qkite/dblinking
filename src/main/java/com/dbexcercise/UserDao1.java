package com.dbexcercise;

import java.sql.*;
import java.util.Map;

public class UserDao1 {
    public void add(User user) throws ClassNotFoundException, SQLException {

        Map<String, String> env = System.getenv();

        Connection connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = makeConnection();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        PreparedStatement ps = connection.prepareStatement("INSERT INTO users(id, name, password) VALUES(?, ?, ?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();
        ps.close();
        connection.close();

    }




    public User findById(String id) throws ClassNotFoundException, SQLException {

        Map<String, String> env = System.getenv();

        Connection connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = makeConnection();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

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

    private Connection makeConnection() throws SQLException {
        Map<String, String> env = System.getenv();
        Connection c = DriverManager.getConnection(env.get("DB_HOST"), env.get("DB_USER"), env.get("DB_PASSWORD"));

        return c;

    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserDao1 userDao2 = new UserDao1();
        userDao2.add(new User("7", "Ruru", "1123457"));

    }


}
