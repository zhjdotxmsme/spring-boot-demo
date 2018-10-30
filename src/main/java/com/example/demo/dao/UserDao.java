package com.example.demo.dao;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author hongjin.zhu
 * @description
 * @date 2018年10月29日 11:02
 * @modified By
 */
@Repository
@SuppressWarnings("unchecked")
public interface UserDao extends JpaRepository<User, Long>,CrudRepository<User,Long>, JpaSpecificationExecutor<User>,QuerydslPredicateExecutor<User> {

    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return
     */
    Optional<User> findByUsername(String username);

    /**
     * save entity
     *
     * @param user 用户实体
     * @return
     */
//    @Async()
//    @Override
//    CompletableFuture<User> save(User user);

}
