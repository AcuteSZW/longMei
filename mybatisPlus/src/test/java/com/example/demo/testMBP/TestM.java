package com.example.demo.testMBP;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.mbpDemo.dao.UserMapper;
import com.example.demo.mbpDemo.entity.User;
import com.example.demo.util.ClassMethod;
import com.example.demo.util.ClassMethod1;
import com.example.demo.util.UtilList;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
@Slf4j
@SpringBootTest
public class TestM {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void  te(){
        QueryWrapper<User> wrapper = new QueryWrapper();
        //wrapper.like("name","o");
        wrapper.in("name","Tom");
        List<User> userList = userMapper.selectList(wrapper);

        userList.forEach(System.out::println);
    }
    @Test
    public void te2(){

        User user = new User();
        user.setId(UtilList.getUUID());
        user.setName("长梅");
        user.setAge(19);
        user.setEmail("1234@qq.com");
        int insert = userMapper.insert(user);
        System.out.println(insert);
        System.out.println(user);

    }
    @Test
    public void te3(){
        User user = new User();
        user.setId(UtilList.getUUID());
        user.setName("宋志伟");
        user.setAge(19);
        user.setEmail("1234567@qq.com");
        System.out.println(user);
        int insert = userMapper.insert(user);
        System.out.println(insert);

    }
    @Test
    public void te4(){
        userMapper.selectList(null);
    }
    @Test
    public void te5(){
        QueryWrapper<User> wrapper = new QueryWrapper();
        wrapper.in("name","Tom");
        //wrapper.eq()
        List<User> userList = userMapper.selectList(wrapper);
        System.out.println(userList);
    }
    @Test
    public void te6(){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("name","长梅");
        int delete = userMapper.delete(wrapper);
    }
    @Test
    public void te7(){
        User user = new User();
        user.setId(UtilList.getUUID());
        user.setName("小长梅");
        user.setAge(18);
        user.setEmail("123456@qq.com");
        int insert = userMapper.insert(user);
        System.out.println(insert);
        System.out.println(user);
    }
    @Test
    public void te8(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name","小长梅");
        int delete = userMapper.delete(wrapper);
        System.out.println(delete);
    }
    @Test
    public void te9(){
        User user = new User();
        String[] sets = ClassMethod.method.getClassMethod(user, "set");
        String[] s = {"123","宋志伟","18","123@qq.com"};
        for (int i = 0; i < user.getClass().getDeclaredFields().length; i++) {
            try {
                Method method = user.getClass().getMethod(sets[i]);
                method.invoke(user);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
