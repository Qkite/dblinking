package com.likelion.dbreview.dao;

import static org.junit.jupiter.api.Assertions.*;

import com.likelion.dbreview.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = UserDaoFactory.class)
class UserDaoTest {

    @Autowired
    ApplicationContext context;
    UserDao userDao;
    User user1;
    User user2;
    User user3;

    @BeforeEach
    public void setting(){
        // 픽스쳐 가져오기
        this.userDao = context.getBean("awsUserDao", UserDao.class);

        this.user1 = new User("131", "박성철", "12345");
        this.user2 = new User("132", "박성철", "12345");
        this.user3 = new User("133", "박성철", "12345");

    }


    @Test
    void addAndGet() {


        String id = "29";
        userDao.add(new User(id, "EternityHwan", "1234"));
        User user = userDao.findById(id);


        assertEquals("EternityHwan", user.getName());
        assertEquals("1234", user.getPassword());
    }

    @Test
    @DisplayName("deleteAll, getCount 테스트하기")
    public void deleteAndCount() throws SQLException {



        userDao.deleteAll();
        assertEquals(userDao.getCount(), 0);

        userDao.add(user1);
        userDao.add(user2);
        assertEquals(userDao.getCount(), 2);



    }

}