package com.service;

import com.dao.UserDao;
import com.driver.Java;
import com.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {
    UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserService() { };

    public void addUser(String email, String password, String firstName, String lastName) {
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-context.xml");
        UserService userServiceBean = ac.getBean("userService", UserService.class);
        userServiceBean.userDao.addUser(email, password, firstName, lastName);
        ac.close();
    }

    public List<Users> getUsers() {
        System.out.println("service method get users invoked");
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-context.xml");
        UserService userServiceBean = ac.getBean( "userService", UserService.class);
        List<Users> users = userServiceBean.userDao.findAll();
        System.out.println(users);
        ac.close();
        return users;
    }
}
