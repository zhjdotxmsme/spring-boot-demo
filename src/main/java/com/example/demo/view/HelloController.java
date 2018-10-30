package com.example.demo.view;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hongjin.zhu
 * @description
 * @date 2018年10月29日 09:36
 * @modified By
 */
@RestController
public class HelloController {
    @GetMapping(value = "/home")
    public String viewHome(){
        return "hello Spring security";
    }
}
