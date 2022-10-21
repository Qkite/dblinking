package com.likelion.dbreview.dao;


import com.likelion.dbreview.domain.User;
import com.likelion.dbreview.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.EmptyStackException;
import java.util.Map;

public class UserDao {

    private ConnectionMaker cm;
    public UserDao() {
        this.cm = new AwsConnectionMaker();
    }

    public UserDao(ConnectionMaker cm) {
        this.cm = cm;
    }

    public void add(User user) {
        Map<String, String> env = System.getenv();
        PreparedStatement pstmt = null;
        Connection c = null;
        try {
            // DB접속 (ex sql workbeanch실행)
            c = cm.makeConnection();

            // Query문 작성
            pstmt = c.prepareStatement("INSERT INTO users(id, name, password) VALUES(?,?,?);");
            pstmt.setString(1, user.getId());
            pstmt.setString(2, user.getName());
            pstmt.setString(3, user.getPassword());

            // Query문 실행
            pstmt.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if(pstmt !=null){
                try {
                    pstmt.close();
                } catch (SQLException e) {

                }
            }
            if(c!=null){
                try {
                    c.close();
                } catch (SQLException e) {

                }
            }


        }
    }

    public User findById(String id) {
        Map<String, String> env = System.getenv();
        Connection c = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        try {
            // DB접속 (ex sql workbeanch실행)
            c = cm.makeConnection();

            // Query문 작성
            pstmt = c.prepareStatement("SELECT * FROM users WHERE id = ?");
            pstmt.setString(1, id);

            // Query문 실행
            rs = pstmt.executeQuery();
            User user = null;

            if (rs.next()) {
                user = new User(rs.getString("id"), rs.getString("name"),
                        rs.getString("password"));
            }

            if (user == null) {
                throw new EmptyStackException();
            }

            return user;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

            if (rs!= null){
                try {
                    rs.close();
                } catch (SQLException e) {

                }
            }

            if(pstmt!=null){
                try {
                    pstmt.close();
                } catch (SQLException e) {

                }
            }

            if(c!=null){
                try {
                    c.close();
                } catch (SQLException e) {

                }
            }

        }
    }

    public void deleteAll() throws SQLException {

        Connection c = null;
        PreparedStatement ps = null;
        try {
            c = cm.makeConnection();
            ps = c.prepareStatement("delete from users");
            ps.executeUpdate();
        } catch (SQLException e) {

        } finally {
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {

                }
            }
            if(c!=null){
                try {
                    c.close();
                } catch (SQLException e) {

                }
            }

        }

    }

    public int getCount() throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 0;
        try {
            c = cm.makeConnection();
            ps = c.prepareStatement("select count(*) from users");
            rs = ps.executeQuery();
            count = 0;

            if(rs.next()){
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {

                }
            }
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {

                }
            }
            if(c!=null){
                try {
                    c.close();
                } catch (SQLException e) {

                }
            }

        }
        return count;

    }

    public static void main(String[] args) {
        UserDao userDao = new UserDao();
//        userDao.add();
        User user = userDao.findById("6");
        System.out.println(user.getName());
    }

}
