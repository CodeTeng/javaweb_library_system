package com.lt.service;

import com.lt.domain.User;

/**
 * Author: lt
 * Date: 2021/10/17 - 20:53
 **/

/**
 * 系统管理员的业务接口---业务逻辑层
 */
public interface UserService {
    /**
     * 管理员登录
     * @param user
     * @return
     */
    User login(User user);
}
