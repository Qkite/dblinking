package com.dbexcercise.connection;

import com.dbexcercise.LocalUserDaoImpl;
import com.dbexcercise.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

// 인터페이스 이용 test
class UserDao4Test {
    @Test
    void addAndSelect() throws SQLException, ClassNotFoundException {
        UserDao4 userDao = new UserDao4();
        User user = new User("8", "EternityHwan", "11234");
        userDao.add(user);

        User selectedUser = userDao.findById("8");
        Assertions.assertEquals("EternityHwan", selectedUser.getName());
    }

}