package com.example.demo.mbpDemo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("user")
public class User implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.ASSIGN_ID)
    private String id;
    private String name;
    private Integer age;
    private String email;
    //逻辑删除
    @TableLogic
    @TableField(fill = FieldFill.INSERT_UPDATE)//自动填充，影响插入和更新
    private int isdeleted;
}
