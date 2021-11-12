package com.lt.service.impl;

import com.lt.dao.UserDao;
import com.lt.dao.impl.UserDaoImpl;
import com.lt.domain.User;
import com.lt.service.UserService;

/**
 * Author: lt
 * Date: 2021/10/17 - 20:53
 **/
public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();

    @Override
    public User login(User user) {
        return dao.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }
}
