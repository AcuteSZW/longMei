package com.example.demo.util;



import com.example.demo.util.staticConstant.StaticConstant;

import java.util.UUID;

/**
 * 自己封装的工具类
 */
public class UtilList {
    /**
     * 生成一个8位的uuid
     */
    public static String getUUID(){
        /**
         * StringBuffer线程安全但是速度慢
         */
        StringBuffer shortBuffer = new StringBuffer();
        //生成uuid
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        //转化uuid为8位
        for (int i = 0; i < 8; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            shortBuffer.append(StaticConstant.CHARS[x % 0x3E]);
        }
        uuid= String.valueOf(shortBuffer);
        return uuid;
    }

}
