package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author hongjin.zhu
 * @description
 * @date 2018年11月01日 10:01
 * @modified By
 */
@javax.persistence.Entity
@Table(name = "user_role")
@Data
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
//    @JoinColumn(name = "userId")
    private Long userId;

    @Column(name = "role_id")
//    @JoinColumn(name = "roleId")
    private Long roleId;
}
