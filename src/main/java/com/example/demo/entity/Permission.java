package com.example.demo.entity;

import javax.persistence.Table;

/**
 * @author hongjin.zhu
 * @description
 * @date 2018年11月05日 11:21
 * @modified By
 */
@javax.persistence.Entity
@Table(name = "permission")
public class Permission extends Entity<Permission> {

    private String permission;

//    @ManyToMany(targetEntity = Role.class)
//    @JoinTable(name = "role_permission",
//                joinColumns = @JoinColumn(name = "id",referencedColumnName = "permission_id"),
//                inverseJoinColumns = @JoinColumn(name = "id",referencedColumnName = "role_id"))
//    private Set<Role> roles = new HashSet<>();

    public String getPermission() {
        return permission;
    }

    public Permission setPermission(String permission) {
        this.permission = permission;
        return this;
    }

//    public Set<Role> getUserRoles() {
//        return roles;
//    }
//
//    public Permission setUserRoles(Set<Role> roles) {
//        this.roles = roles;
//        return this;
//    }
}
