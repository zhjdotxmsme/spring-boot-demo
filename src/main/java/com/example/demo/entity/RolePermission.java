package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by alexzhu on 2018/11/11 1:05 .
 * No bug No pain
 */
@javax.persistence.Entity
@Table(name = "role_permission")
@Data
public class RolePermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_id")
//    @JoinColumn(name = "roleId")
    private Long roleId;

    @Column(name = "permission_id")
//    @JoinColumn(name = "permissionId")
    private Long permissionId;
}
