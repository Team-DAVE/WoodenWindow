package com.model;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
public class Users {
    @Id
    @Column(name="USERS_ID", columnDefinition="serial primary key")
    @GeneratedValue(strategy=GenerationType.IDENTITY) // the table creates this value
    private int id;

    @Column(name="EMAIL", nullable = false, unique = true)
    private String email;
    @Column(name="PASSWORD", nullable = false)
    private String password;
    @Column(name="FIRST_NAME", nullable = false)
    private String firstName;
    @Column(name="LAST_NAME", nullable = false)
    private String lastName;

    public Users() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}