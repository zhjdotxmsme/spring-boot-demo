package com.example.demo.user;

import com.example.demo.DemoApplicationTests;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author hongjin.zhu
 * @description
 * @date 2018年11月01日 11:26
 * @modified By
 */
public class ShiroTest extends DemoApplicationTests {

    @Test(expected = Exception.class)
    public void testLDAP(){
        IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro.ini");

        SecurityManager manager = factory.getInstance();

        SecurityUtils.setSecurityManager(manager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "1234");

        subject.login(token);

        Assert.assertEquals(true,subject.isAuthenticated());

        subject.logout();
    }
}
