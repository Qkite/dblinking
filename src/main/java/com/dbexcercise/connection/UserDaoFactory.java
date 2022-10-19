package com.dbexcercise.connection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserDaoFactory {


    // 내가 어떤 조합을 사용할 것인지를 설정해줌

    @Bean
    public UserDao4 nConnectionUserDao(){
        NConnectionMaker nConnectionMaker = new NConnectionMaker();
        UserDao4 userDao4 = new UserDao4();
        return userDao4;
    }

    @Bean
    public UserDao4 dConnectionUserDao(){
        DConnectionMaker dConnectionMaker = new DConnectionMaker();
        UserDao4 userDao4 = new UserDao4();
        return userDao4;
    }
}
