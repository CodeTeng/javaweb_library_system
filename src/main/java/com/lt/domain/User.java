package com.lt.domain;

/**
 * Author: lt
 * Date: 2021/10/17 - 17:19
 **/

/**
 * 管理员类
 */
public class User {
    private int id; //管理员的id
    private String username;    //管理员的姓名
    private String password;    //管理员的密码

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
