package com.service;

import com.dao.ProfileDao;
import com.dao.UserDao;
import com.model.Profile;
import com.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {
    ProfileDao profileDao;
    UserDao userDao;

    @Autowired
    public ProfileService(ProfileDao profileDao, UserDao userDao) {
        this.profileDao = profileDao;
        this.userDao = userDao;
    }

    public ProfileService() { };

    public void addProfile(String profileName, String resume, int userId) {
        System.out.println("ProfileService addProfile method reached");
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-context.xml");
        ProfileService profileServiceBean = ac.getBean("profileService", ProfileService.class);
        Users user = profileServiceBean.userDao.findUserById(userId);
        profileServiceBean.profileDao.addProfile(profileName, resume, user);
        ac.close();
        System.out.println("ProfileService method ended");
    }

    public List<Profile> getProfilesByUserId(int userId) {
        System.out.println("ProfileService getProfilesByUserId method reached");
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-context.xml");
        ProfileService profileServiceBean = ac.getBean("profileService", ProfileService.class);
        List<Profile> profiles = profileServiceBean.profileDao.getProfilesByUserId(userId);
        System.out.println(profiles);
        ac.close();
        return profiles;
    }
}
