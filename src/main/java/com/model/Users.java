package com.model;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
public class Users {
  @Id
  @Column(name="USERS_ID", columnDefinition="serial primary key")
  @GeneratedValue(strategy=GenerationType.IDENTITY) // the table creates this value
  private int id;

  @Column(name="USERNAME", nullable = false)
  private String username;
  @Column(name="PASSWORD", nullable = false)
  private String password;

  /*
    create table if not exist FLASHCARDS (
      flashcard_id serial,
      flashcard_question varchar(4000) not null,
      flashcard_answer varchar(4000) not null,
      primary key(flashcard_id)
    );
   */

  public Users() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUserName() {
    return username;
  }

  public void setUserName(String question) {
    this.username = question;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String answer) {
    this.password = answer;
  }

  @Override
  public String toString() {
    return "Flashcard{" +
      "id=" + id +
      ", question='" + username + '\'' +
      ", answer='" + password + '\'' +
      '}';
  }
}

