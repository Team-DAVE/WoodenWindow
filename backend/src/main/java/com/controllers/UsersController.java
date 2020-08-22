package com.controllers;

import com.model.Users;
import com.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.net.URISyntaxException;

@Controller
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
    public ResponseEntity<String> addUser(@RequestBody Users newUser) throws URISyntaxException {
        if (newUser == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } else {
            String email = newUser.getEmail();
            String password = newUser.getPassword();
            String firstName = newUser.getFirstName();
            String lastName = newUser.getLastName();
            userService.addUser(email, password, firstName, lastName);
            return new ResponseEntity<>(null, HttpStatus.CREATED);
        }
    }
}
