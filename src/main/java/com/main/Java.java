package com.main;

import com.dao.UserDao;
import com.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Java {
  UserDao flashcardDao;

  @Autowired
  public Java(UserDao flashcardDao) {
    this.flashcardDao = flashcardDao;
  }

  public static void main(String[] args) {
    AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-context.xml");
    Java m = ac.getBean( "java",Java.class);
    m.flashcardDao.addUser("Testquestion3","answer is 102");
    List<Users> cards =  m.flashcardDao.findAll();
    for(Users f : cards) {
      System.out.println(f);
    }
    ac.close();
  }
}

