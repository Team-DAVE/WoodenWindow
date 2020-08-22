package com.driver;

import com.dao.UserDao;
import com.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Java {
    UserDao userDao;

    @Autowired
    public Java(UserDao userDao) {
        this.userDao = userDao;
    }

    public static void main(String[] args) {
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-context.xml");
        Java javaBean = ac.getBean( "java",Java.class);
        javaBean.userDao.addUser("test@host.com","1234", "Test", "One");

        ac.close();
    }
}