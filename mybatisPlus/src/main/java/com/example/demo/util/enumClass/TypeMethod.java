package com.example.demo.util.enumClass;

public enum TypeMethod {

    SET("set()"),

    GET("get()");

    private final String type;

    private TypeMethod(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
