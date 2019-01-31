package com.example.demo.dao;

import com.example.demo.entity.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author hongjin.zhu
 * @description
 * @date 2018年11月27日 15:30
 * @modified By
 */
@Repository
public interface RolePermissionDao extends JpaRepository<RolePermission, Long> {
}
