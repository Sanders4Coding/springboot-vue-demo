package com.example.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author: Tian_Jie
 * @date: 2022/6/30 15:53
 * @description: 用户实体类
 */

@TableName("user")
@Data
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("username")
    private String userName;
    @TableField(value = "password")
    private String passWord;
    @TableField(value = "nick_name")
    private String nickName;
    private Integer age;
    private String sex;
    private String address;
}
