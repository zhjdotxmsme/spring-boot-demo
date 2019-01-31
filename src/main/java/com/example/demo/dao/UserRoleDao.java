package com.example.demo.dao;

import com.example.demo.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author hongjin.zhu
 * @description
 * @date 2018年11月27日 15:15
 * @modified By
 */
@Repository
public interface UserRoleDao extends JpaRepository<UserRole,Long> {
}
