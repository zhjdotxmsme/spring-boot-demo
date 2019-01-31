package com.example.demo.service.user;

import com.example.demo.dao.RoleDao;
import com.example.demo.entity.Role;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hongjin.zhu
 * @description
 * @date 2018年11月27日 14:32
 * @modified By
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roleDao;

    @Override
    public void createRole(Role role) {
        //todo 数据校验
        roleDao.save(role);
    }

    @Override
    public void deleteRole(Long roleId) {

    }

    @Override
    public void correlationPermissions(Long roleId, Long... permissions) {

    }

    @Override
    public void uncorrelationPermissions(Long roleId, Long... permissions) {

    }
}
