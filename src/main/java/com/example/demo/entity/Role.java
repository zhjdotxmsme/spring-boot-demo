package com.example.demo.entity;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
public class Role extends Entity<Role> {

    private String roleName;
    private String remark;
    private Long createUserId;

    @OneToMany
    @JoinColumn(name = "role_id",referencedColumnName = "id")
    private Set<UserRole> userRoles = new HashSet<>();

//    @ManyToMany(targetEntity = Permission.class)
//    @JoinTable(name = "role_permission",
//            joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")},
//            inverseJoinColumns = {@JoinColumn(name = "permission_id", referencedColumnName = "id")})
//    private Set<Permission> permissions = new HashSet<>();

    public String getRoleName() {
        return roleName;
    }

    public Role setRoleName(String roleName) {
        this.roleName = roleName;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public Role setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public Role setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
        return this;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public Role setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
        return this;
    }

//    public Set<Permission> getPermissions() {
//        return permissions;
//    }
//
//    public Role setPermissions(Set<Permission> permissions) {
//        this.permissions = permissions;
//        return this;
//    }
}
