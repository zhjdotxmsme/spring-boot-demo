package com.example.demo.user;

import com.example.demo.DemoApplicationTests;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

/**
 * @author hongjin.zhu
 * @description
 * @date 2018年10月29日 16:49
 * @modified By
 */
public class UserServiceImplTest extends DemoApplicationTests {


    @Autowired
    UserService userService;

    @Test
    public void search() throws Exception {
        Page<User> search = userService.search("", 1, 20);
        System.out.println("=====" + search);
    }

    @Test
    public void save() throws Exception {
    }

}