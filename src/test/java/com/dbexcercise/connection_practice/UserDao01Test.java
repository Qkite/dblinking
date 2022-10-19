package com.dbexcercise.connection_practice;

import com.dbexcercise.User;
import com.dbexcercise.connection.UserDao4;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class UserDao01Test {

    @Test
    void addAndSelect() throws SQLException, ClassNotFoundException {
        UserDao01 userDao = new UserDao01();
        User user = new User("130", "Dominic", "11234");
        userDao.add(user);

        User selectedUser = userDao.findById("130");
        Assertions.assertEquals("Dominic", selectedUser.getName());
    }
}