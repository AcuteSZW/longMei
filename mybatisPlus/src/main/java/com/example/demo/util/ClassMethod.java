package com.example.demo.util;

import java.lang.reflect.Field;

public class ClassMethod {
    public static ClassMethod method = new ClassMethod();

    /**
     * 传进来一个反射类,拿到所有的get或者set方法类型
     * getId   setId
     */
    public String[] getClassMethod(Object obj, String type) {

        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        String[] strings = new String[fields.length];
        String str;
        for (int i = 0; i < fields.length; i++) {
            str = String.valueOf(fields[i]);
            str = str.substring(str.lastIndexOf(".") + 1);
            str = str.substring(0, 1).toUpperCase() + str.substring(1);
            if (type == "get") {
                str = "get" + str;
            } else if (type == "set") {
                str = "set" + str;
            } else {
                System.out.println("type类型只能为get或者set");
                break;
            }

            strings[i] = str;
            System.out.println(str);
        }
        return strings;
    }
}
