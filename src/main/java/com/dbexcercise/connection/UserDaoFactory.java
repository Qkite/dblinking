package com.dbexcercise.connection;

public class UserDaoFactory {

    // 내가 어떤 조합을 사용할 것인지를 설정해줌
    public UserDao4 nConnectionUserDao(){
        NConnectionMaker nConnectionMaker = new NConnectionMaker();
        UserDao4 userDao4 = new UserDao4(nConnectionMaker);
        return userDao4;
    }

    public UserDao4 dConnectionUserDao(){
        DConnectionMaker dConnectionMaker = new DConnectionMaker();
        UserDao4 userDao4 = new UserDao4(dConnectionMaker);
        return userDao4;
    }
}
