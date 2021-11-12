package com.lt.dao;

import com.lt.domain.User;

/**
 * Author: lt
 * Date: 2021/10/17 - 20:55
 **/

/**
 * 管理员操作的DAO---数据访问层
 */
public interface UserDao {
    /**
     * 用于判断管理员登录
     * @param username
     * @param password
     * @return
     */
    User findUserByUsernameAndPassword(String username, String password);
}
