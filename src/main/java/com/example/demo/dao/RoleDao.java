package com.example.demo.dao;

import com.example.demo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author hongjin.zhu
 * @description
 * @date 2018年11月27日 14:33
 * @modified By
 */
@Repository
public interface RoleDao extends JpaRepository<Role,Long> {
}
