package com.example.demo.util;

import com.example.demo.util.enumClass.TypeMethod;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ClassMethod1 {


    public static ClassMethod1 method = new ClassMethod1();
    /**
     *    传进来一个类的实例对象,拿到所有的get或者set方法类型
     */
    public List getClassMethod(Object obj, String type) {
        List list = new ArrayList<>();

        //Method[] method2 = null;//返回值类型
        Class<?> clazz = obj.getClass();//根据传过来的类型反射到对象
        Field[] fields = clazz.getDeclaredFields();//返回一个Field对象数组，该数组反映由该Class对象表示的类或接口声明的所有字段。
        String[] strings=new String[fields.length];//将字段长度作为数组长度
        String str;//创建一个对象
        for (int i = 0; i < fields.length; i++) {//循环操作
            str = String.valueOf(fields[i]);
            str = str.substring(str.lastIndexOf(".")+1);
            str = str.substring(0, 1).toUpperCase() + str.substring(1);
            if (type == TypeMethod.GET.getType()) {
                str="get()"+str;
            }else if (type == TypeMethod.SET.getType()) {
                str = "set("+")"+str;
            }else {
                System.err.println("type类型只能为get或者set");
                break;
            }
            strings[i] = str;
            System.out.println(str);
        }
        for (String string : strings) {
            try {
                Method method1 = clazz.getMethod(string);
                list.add(method1.invoke(obj));
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        list.forEach(System.out::println);
        return list;

    }

}
