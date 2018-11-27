package com.example.demo.service;

import com.example.demo.entity.Role;

/**
 * @author hongjin.zhu
 * @description
 * @date 2018年11月05日 11:22
 * @modified By
 */
public interface RoleService {
    void createRole(Role role);

    void deleteRole(Long roleId);

    /**
     * 关联权限和角色之间的关系
     * @param roleId
     * @param permissions
     */
    void correlationPermissions(Long roleId,Long... permissions);

    /**
     * 移除角色和权限之间的关系
     * @param roleId
     * @param permissions
     */
    void uncorrelationPermissions(Long roleId,Long... permissions);
}
