package com.example.demo.user;

import com.example.demo.DemoApplicationTests;
import com.example.demo.entity.QUser;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.view.HelloController;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.hibernate.Session;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * @author hongjin.zhu
 * @description
 * @date 2018年10月29日 16:49
 * @modified By
 */
public class UserServiceImplTest extends DemoApplicationTests {

    private final static Logger LOG = LoggerFactory.getLogger(UserServiceImplTest.class);

    @Autowired
    UserService userService;

    @Autowired
    HelloController helloController;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void search() throws Exception {
        Page<User> search = userService.search("", 1, 20);
        System.out.println("=====" + search);
    }

    @Test
    public void save() throws Exception {
        for (int i = 6; i < 10; i++) {
            User user = new User().setUsername("wang" + i).setPassword("123").setPasswordSalt("abcdefg");
            User user1 = userService.createUser(user);
            LOG.info("user is create : %s" , user.getUsername());
        }
    }

    @Test
    public void changePsw() throws Exception {
        Long userId = 1L;
        String newPassword = "654321";

        userService.changePasswword(userId,newPassword);
    }

    @Test
    @Transactional
    public void testMvc(){
        QUser user = new QUser("user");
        Session session = entityManager.unwrap(Session.class);
        JPAQueryFactory queryFactory = new JPAQueryFactory(session);
        User user1 = queryFactory.select(user).from(user).where(user.userId.eq(1L)).fetchFirst();
        user1.setUsername(null);
        queryFactory.update(user).where(user.userId.eq(1L)).set(user.username,"").execute();

        helloController.viewHome();
    }

}