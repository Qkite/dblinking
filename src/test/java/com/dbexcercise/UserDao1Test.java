package com.dbexcercise;

import com.dbexcercise.connection_with_abstract_class.dao.LocalUserDaoImpl;
import com.dbexcercise.connection_with_abstract_class.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

class UserDao1Test {
    @Test
    void addAndSelect() throws SQLException, ClassNotFoundException {
        LocalUserDaoImpl userDao1 = new LocalUserDaoImpl();
        User user = new User("8", "EternityHwan", "11234");
        userDao1.add(user);

        User selectedUser = userDao1.findById("8");
        Assertions.assertEquals("EternityHwan", selectedUser.getName());
    }
}