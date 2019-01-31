package com.example.demo.service.user;

import com.example.demo.dao.UserRoleDao;
import com.example.demo.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hongjin.zhu
 * @description
 * @date 2018年11月27日 15:16
 * @modified By
 */
@Service("userRoleService")
public class UserRoleServiceImpl {

    @Autowired
    UserRoleDao userRoleDao;

    public void createUserRole(UserRole userRole){
        //todo 数据校验
        userRoleDao.save(userRole);
    }
}
