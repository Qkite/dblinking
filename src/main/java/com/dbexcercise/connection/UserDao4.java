package com.dbexcercise.connection;

import com.dbexcercise.SimpleConnectionMaker;
import com.dbexcercise.User;

import java.sql.*;
import java.util.Map;

// interface를 상속받은 Nconnectionmaker 이용
public class UserDao4 {

    private NConnectionMaker nConnectionMaker;

    public UserDao4(){
        nConnectionMaker = new NConnectionMaker();

    }
    public void add(User user) throws ClassNotFoundException, SQLException {

        Map<String, String> env = System.getenv();


        Connection connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = nConnectionMaker.makeConnection();
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
            connection = nConnectionMaker.makeConnection();
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
        UserDao4 userDao1 = new UserDao4();
        userDao1.add(new User("7", "Ruru", "1123457"));

    }


}
