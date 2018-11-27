package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/**
 * Created by alexzhu on 2018/11/11 1:05 .
 * No bug No pain
 */
@javax.persistence.Entity
@Table(name = "role_permission")
@Data
public class RolePermission extends Entity<RolePermission> {

    @Column(name = "role_id")
    @JoinColumn(name = "id")
    private Long roleId;

    @Column(name = "permission_id")
    @JoinColumn(name = "id")
    private Long permissionId;
}
