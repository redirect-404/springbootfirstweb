package com.test.springbootfirstweb.dao.impl;

import com.test.springbootfirstweb.dao.UserDao;
import com.test.springbootfirstweb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer inserUser(User user) {
        String sql = "insert into test.user(username,userage) values (?,?)";
        int i = this.jdbcTemplate.update(sql,user.getUserName(),user.getUserAge());
        return i;
    }

    @Override
    public List<User> findUserAll() {

        String sql = "select * from test.user";
        List list = jdbcTemplate.queryForList(sql);
        List<User> listUser = new ArrayList<User>();
        for(int i=0;i<list.size();i++){
            Map map = (Map) list.get(i);
            User user = new User();
            user.setUserId(map.get("userid").toString());
            user.setUserName(map.get("username").toString());
            user.setUserAge(map.get("userage").toString());
            listUser.add(user);
        }
        return listUser;
    }

    @Override
    public User findUser(String id) {
        String sql = "select * from test.user where userid='"+id+"'";
        List list = jdbcTemplate.queryForList(sql);
        Map map = (Map)list.get(0);
        User user = new User();
        user.setUserId(map.get("userid").toString());
        user.setUserName(map.get("username").toString());
        user.setUserAge(map.get("userage").toString());
        return user;
    }

    @Override
    public Integer updateUser(User user) {
        String sql="update test.user set username=?,userage=? where userid= ?";
        int i = jdbcTemplate.update(sql,user.getUserName(),user.getUserAge(),user.getUserId());
        return i;
    }



    @Override
    public Integer deleteUser(String id) {
        String sql="delete from test.user where userid= ?";
        int i = jdbcTemplate.update(sql,id);
        return i;
    }
}
