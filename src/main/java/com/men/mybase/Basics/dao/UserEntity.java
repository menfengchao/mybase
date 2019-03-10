package com.men.mybase.Basics.dao;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "sys_user")
public class UserEntity {

    @Id
    @GeneratedValue
    private String id;

    @Column
    private String name;

    @Column
    private String passWork;

    @Column
    private String createTime;

}
