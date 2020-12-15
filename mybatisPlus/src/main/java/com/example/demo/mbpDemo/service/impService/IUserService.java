package com.example.demo.mbpDemo.service.impService;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.demo.mbpDemo.dao.UserMapper;
import com.example.demo.mbpDemo.entity.User;
import com.example.demo.mbpDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class IUserService implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> select(User user) {
        //mybatis plus的条件构造器
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();

        //eq等于 = column是属性，这里的属性取数据库的字段
        wrapper.eq(Objects.nonNull(user.getName()), User::getName, user.getName());
        wrapper.ne(user.getAge() != null, User::getAge, user.getAge());
        List<User> userList = userMapper.selectList(wrapper);
        return userList;
    }
}
