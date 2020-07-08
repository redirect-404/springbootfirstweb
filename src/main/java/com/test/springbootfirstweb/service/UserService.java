package com.test.springbootfirstweb.service;

import com.test.springbootfirstweb.dao.UserDao;
import com.test.springbootfirstweb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public Integer insertUser(User user){
       return userDao.inserUser(user);
    }

    public List<User> findUserAll(){
        return userDao.findUserAll();
    }

    public User findUser(String id){
        return userDao.findUser(id);
    }

    public Integer updateUser(User user){
        return userDao.updateUser(user);
    }

    public Integer deleteUser(String id){
        return userDao.deleteUser(id);
    }
}
