package com.example.demo.service;

import com.example.demo.entity.Permission;

/**
 * @author hongjin.zhu
 * @description
 * @date 2018年11月05日 11:19
 * @modified By
 */
public interface PermissionService {
    Permission createPermission(Permission permission);
    void deletePermission(Long permissionId);
}
