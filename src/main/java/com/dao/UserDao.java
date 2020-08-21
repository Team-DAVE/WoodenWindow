package com.dao;

import com.model.Users;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;


@Repository
@Transactional
public class UserDao {
  SessionFactory sessionFactory;

  /*@PostConstruct
  protected void initFlashcard() {
    Flashcard f = new Flashcard();
    f.setQuestion("How many beans are required to integrate Spring and Hibernate with Transaction Management");
    f.setAnswer("3");

    Session session = sessionFactory.openSession();
    Transaction tx = session.beginTransaction();
    session.save(f);
    tx.commit();
  }*/

  @Transactional
  public void addUser(String username, String password) {
    Users f = new Users();
    f.setUserName(username);
    f.setPassword(password);

    Session session = sessionFactory.openSession();
    Transaction tx = session.beginTransaction();
    session.save(f);
    tx.commit();
  }

  @Autowired
  public UserDao(SessionFactory sf) {
    this.sessionFactory = sf;
  }

  @Transactional(isolation = Isolation.READ_COMMITTED, readOnly=true)
  public List<Users> findAll() {
    Session session = sessionFactory.getCurrentSession(); // CONTEXTUAL SESSION. IS USED IN TX MANAGEMENT.
    String sql = "Select u From Users u";
    Query query = session.createQuery(sql);
    List<Users> cards = query.list();
    return cards;
  }
}


