package com.service;

import com.dao.UserDao;
import com.model.Users;

import java.util.List;

public class UserService {
    private UserDao dao = new UserDao();

    public void addUser(String email, String password, String firstName, String lastName) {
        dao.addUser(email, password, firstName, lastName);
    }

    public List<Users> getUsers() {
        System.out.println("service method get users invoked");
        return dao.findAll();
    }
}
