package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.data.domain.Page;

/**
 * @author hongjin.zhu
 * @description
 * @date 2018年10月29日 13:45
 * @modified By
 */

public interface UserService {


    Page<User> search(String searchInfo, Integer pageNo, Integer pageSize);
}
