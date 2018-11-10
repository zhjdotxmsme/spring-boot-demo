package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long permissionId;

    private String permission;

    @ManyToMany(mappedBy = "permissions")
    private Set<Role> roles;
}
