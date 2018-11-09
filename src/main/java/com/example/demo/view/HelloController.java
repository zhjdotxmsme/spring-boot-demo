package com.example.demo.view;

import com.example.demo.entity.UserValidator;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author hongjin.zhu
 * @description
 * @date 2018年10月29日 09:36
 * @modified By
 */
@RestController
@RequestMapping(value = "/api")
public class HelloController {
    @InitBinder
    protected void initBinder(WebDataBinder binder){
        binder.addValidators(new UserValidator());
    }

    @GetMapping(value = "/home")
    @RequiresRoles("admin")
    public String viewHome(){
        System.out.println(" === ");
        return "hello Spring security";
    }

    @PostMapping(value = "/login")
    public String login(Map map){
        Subject subject = SecurityUtils.getSubject();
        String name = (String) map.get("name");
        String password = (String) map.get("password");

        UsernamePasswordToken token = new UsernamePasswordToken(name, password);
        subject.login(token);
        return "index";
    }
}
