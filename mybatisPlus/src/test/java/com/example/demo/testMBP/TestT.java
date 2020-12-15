package com.example.demo.testMBP;

import cn.hutool.core.util.ReflectUtil;
import com.example.demo.mbpDemo.entity.User;
import com.example.demo.util.ClassMethod;
import com.example.demo.util.enumClass.TypeMethod;
import com.power.doc.builder.ApiDocBuilder;
import com.power.doc.model.ApiConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootTest
public class TestT{
    @Test
    public void te1(){
        User user = new User();
        user.setId("12");
        user.setAge(12);
        user.setName("宋志伟");
        user.setEmail("123@qq.com");
        Class<? extends User> aClass = user.getClass();
        String[] gets = ClassMethod.method.getClassMethod(user, "set");
        List list = new ArrayList<>();
        for (String get : gets) {
            System.out.print("... " + get);
            try {
                //setId()
                Method method = user.getClass().getMethod(get,new Class[] {Class.forName("com.example.demo.mbpDemo.entity.User"),Integer.TYPE});


                list.add(method.invoke(user));
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
        System.out.println("======================");
        list.forEach(System.out::println);
        System.out.println("======================");

    }
    @Test
    public void te3(){
        User user = new User();
        //List get = ClassMethod1.method.getClassMethod(user, "get");
        //get.forEach(System.out::println);
        Method[] methods = ReflectUtil.getMethods(user.getClass());
        for (Method method : methods) {
            System.out.println(method);
        }
    }
    @Test
    public void te2(){
//        String name = TypeMethod.SET.getType();
//        String name1 = TypeMethod.GET.getType();
        //System.out.println("name="+name   +"           name1 = "+name1);
        TypeMethod[] values = TypeMethod.values();
        for (TypeMethod value : values) {
            System.out.println(value.getType());
        }
        String set = TypeMethod.valueOf("SET").getType();
        System.out.println("typeMethod = " + set);
    }
    @Test
    public void te4(){
        for (int i = 0; i < 10000; i++) {
            String uuid = UUID.randomUUID().toString().replaceAll("-","");
            System.out.println("uuid = " + uuid);

        }
        //String uuid = UUID.randomUUID().toString().replaceAll("-","");
    }

    /**
     * 包括设置请求头，缺失注释的字段批量在文档生成期使用定义好的注释
     */
    @Test
    public void testBuilderControllersApi() {
        ApiConfig config = new ApiConfig();
        //接口地址
        config.setServerUrl("http://localhost:8082");
        //true会严格要求代码中必须有java注释，首次体验可关闭，正式产品推荐设置true,也就是控制层必须写注释,写成false则不用写
        config.setStrict(true);
        //当把AllInOne设置为true时，Smart-doc将会把所有接口生成到一个Markdown、HHTML或者AsciiDoc中
        config.setAllInOne(true);
        //config.setCoverOld(true);
        //设置api文档输出路径。
        config.setOutPath("d:\\md");
        //生成Markdown文件
        ApiDocBuilder.buildApiDoc(config);
    }


}
