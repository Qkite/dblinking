package com.dbexcercise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class UserDao1Test {
    @Test
    void addAndSelect() throws SQLException, ClassNotFoundException {
        UserDao1 userDao1 = new UserDao1();
        User user = new User("8", "EternityHwan", "11234");
        userDao1.add(user);

        User selectedUser = userDao1.findById("8");
        Assertions.assertEquals("EternityHwan", selectedUser.getName());
    }
}