package com.dao;

import com.model.Users;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class UserDao {
    SessionFactory sessionFactory;

    @Autowired
    public UserDao(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    public UserDao() {
    }

    @Transactional
    public boolean addUser(String email, String password, String firstName, String lastName) {
        System.out.println("is it breaking here");
        Users newUser = new Users();
        newUser.setEmail(email);
        newUser.setPassword(password);
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);

        Session session = sessionFactory.getCurrentSession();
        System.out.println("break");
        String sql = "Select u From Users u where email = ?";
        System.out.println("break1");
        Query query = session.createQuery(sql);
        query.setParameter(0, newUser.getEmail());
        System.out.println("break2");
        //System.out.println(query.uniqueResult());
        if (query.uniqueResult() == null) {
            session.save(newUser);
            return true;
        }
        return false;
        //System.out.println(session.get(Users.class, newUser.getEmail()));
        //System.out.println("break here");



        //session.save(newUser);
    }


    @Transactional(isolation = Isolation.READ_COMMITTED, readOnly=true)
    public List<Users> findAll() {
        System.out.println("dao method findall invoked");
        Session session;
        session = sessionFactory.getCurrentSession();
        System.out.println(session);
        String sql = "Select u From Users u";
        Query query = session.createQuery(sql);
        List<Users> users = query.list();
        return users;
    }
}
