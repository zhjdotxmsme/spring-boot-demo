package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author hongjin.zhu
 * @description
 * @date 2018年11月01日 09:52
 * @modified By
 */
@javax.persistence.Entity
@Table(name = "role")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long roleId;
    private String roleName;
    private String remark;
    private Long createUserId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

//    @ManyToMany(targetEntity = User.class)
//    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"),
//            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"))
//    private Set<User> roles = new HashSet<>();

    @ManyToMany(targetEntity = Permission.class)
    @JoinTable(name = "role_permission",
            joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "role_id")},
            inverseJoinColumns = {@JoinColumn(name = "permission_id", referencedColumnName = "permission_id")})
    private Set<Permission> permissions = new HashSet<>();
}
