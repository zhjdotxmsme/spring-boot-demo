package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * @author hongjin.zhu
 * @description
 * @date 2018年11月01日 09:52
 * @modified By
 */
@Entity
@Table(name = "role")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "role_permission",
            joinColumns = {@JoinColumn(name = "roleId")},
            inverseJoinColumns = {@JoinColumn(name = "permissionId")})
    private Set<Permission> permissions;
}
