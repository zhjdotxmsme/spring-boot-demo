package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author hongjin.zhu
 * @description
 * @date 2018年11月05日 11:21
 * @modified By
 */
@Entity
@Table(name = "permission")
@Data
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "permission_id")
    private Long permissionId;

    private String permission;

    @ManyToMany(targetEntity = Role.class)
    @JoinTable(name = "role_permission",
                joinColumns = @JoinColumn(name = "permission_id",referencedColumnName = "permission_id"),
                inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "role_id"))
    private Set<Role> roles = new HashSet<>();
}
