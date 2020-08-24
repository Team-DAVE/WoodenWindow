package com.controllers;

import com.model.Users;
import com.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path="/user")
public class UsersController {
    private UserService userService = new UserService();

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Users>> getUsers() {
        System.out.println("controller method get users invoked");
        System.out.println(userService.getUsers());
        List<Users> users = userService.getUsers();
        System.out.println(users);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping
    @ResponseBody
    public boolean addUser(@RequestBody Users newUser) throws URISyntaxException {
        System.out.println("addUser controller called");
        if (newUser == null) {
            System.out.println("user is empty");
            //return new ResponseEntity<>("user is empty", HttpStatus.BAD_REQUEST);
            return false;
        } else {
            System.out.println("else was hit");
            String email = newUser.getEmail();
            String json = "test";
            String password = newUser.getPassword();
            String firstName = newUser.getFirstName();
            String lastName = newUser.getLastName();
            return userService.addUser(email, password, firstName, lastName);

        }
    }
}
