package com.dbexcercise.connection.dao;

import com.dbexcercise.LocalUserDaoImpl;
import com.dbexcercise.User;
import com.dbexcercise.connection.dao.UserDao4;
import com.dbexcercise.connection.dao.UserDaoFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

// 인터페이스 이용 test
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = UserDaoFactory.class)

class UserDao4Test {
    @Autowired
    ApplicationContext context;
    @Test
    void addAndSelect() throws SQLException, ClassNotFoundException {
        //UserDao4 userDao = new UserDao4();
        UserDao4 userDao = context.getBean("nConnectionUserDao", UserDao4.class); // factory에서 설정한 조합을 가져와서 사용
        User user = new User("9", "EternityHwan", "11234");
        userDao.add(user);

        User selectedUser = userDao.findById("8");
        Assertions.assertEquals("EternityHwan", selectedUser.getName());
    }

}