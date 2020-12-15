package com.example.demo.mbpDemo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.demo.mbpDemo.entity.User;
import com.example.demo.mbpDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 这是一个给长梅用的demo接口
     * @param user
     * @return
     */
    @PostMapping("/user/select")
    public List<User> selectAll(User user) {
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.eq(User::getAge, 1);
        List<User> select = userService.select(user);
        return select;
    }
}
