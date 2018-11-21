package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Set;

/**
 * @author hongjin.zhu
 * @description
 * @date 2018年10月29日 13:45
 * @modified By
 */

public interface UserService {

    User createUser(User user);

    Boolean login(String username,String password);

    void batchRegistryUser(List<User> users);

    void changePasswword(Long userId, String newPassword);

    void correlationRoles(Long userId,Long... roleIds);

    void uncorrelationRoles(Long userId,Long... roleIds);

    User findByUsername(String username);

    Set<String> findRoles(String username);

    Set<String> findPermissions(String username);

    Page<User> search(String searchInfo, Integer pageNo, Integer pageSize);
}
