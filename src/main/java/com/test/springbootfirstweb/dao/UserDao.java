package com.test.springbootfirstweb.dao;

import com.test.springbootfirstweb.model.User;

import java.util.List;

public interface UserDao {
    public Integer inserUser(User user);

    public List<User> findUserAll();
    public User findUser(String id);

    public Integer updateUser(User user);
    public Integer deleteUser(String id);

}
