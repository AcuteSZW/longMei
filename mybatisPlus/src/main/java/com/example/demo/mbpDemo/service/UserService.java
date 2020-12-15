package com.example.demo.mbpDemo.service;

import com.example.demo.mbpDemo.entity.User;

import java.util.List;

public interface UserService {
    /**
     * 查询记录
     * @param user
     * @return
     */
    public List<User> select(User user);
}
