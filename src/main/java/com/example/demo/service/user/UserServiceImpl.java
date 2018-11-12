package com.example.demo.service.user;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.QUser;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.Set;

/**
 * @author hongjin.zhu
 * @description
 * @date 2018年10月29日 13:46
 * @modified By
 */
@Service("userService")
@ConfigurationProperties(prefix = "prop")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @PersistenceContext
    private EntityManager entityManager;

    private String name;

    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public void changePasswword(Long userId, String newPassword) {

    }

    @Override
    public void correlationRoles(Long userId, Long... roleIds) {

    }

    @Override
    public void uncorrelationRoles(Long userId, Long... roleIds) {

    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username).get();
    }

    @Override
    public Set<String> findRoles(String username) {
        return null;
    }

    @Override
    public Set<String> findPermissions(String username) {
        return null;
    }

    @Override
    @Transactional
    public Page<User> search(final String searchInfo, final Integer pageNo, final Integer pageSize) {

        // todo 分页没有去做处理，使用的默认分页
        PageRequest pageRequest = PageRequest.of(1, 10);

        /**
         * 查询的时候用的是 JPAQuery
         * 删除/更新用的是 JPAQueryFactory
         */
        QUser user = QUser.user;
//        JPAQuery<User> query = new JPAQuery<>(entityManager);
//        User resutl = query.select(user).from(user).where(user.username.eq("zhang")).fetchOne();
//        System.out.println(" === " + resutl.getPassword());
        Session session = entityManager.unwrap(Session.class);
        JPAQueryFactory queryFactory = new JPAQueryFactory(session);
        queryFactory.update(user).where(user.username.eq("zhang")).set(user.username,"li")
                .set(user.password,"456").execute();

        System.out.println(" ==== " + name);

        return userDao.findAll(new Specification<User>() {
            @Nullable
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Predicate predicate = cb.equal(root.get("username"),"zhang");

                CriteriaQuery result = query.where(predicate);

                return predicate;
            }
        }, pageRequest);
    }

    public void save(){
//        User user = new User().setUsername("li").setPassword("123");
//
//        try {
//            Object o = userDao.save(user).get();
//            System.out.println("====" + o);
//        } catch (InterruptedException | ExecutionException e) {
//            System.out.println(e.getMessage());
//        }

    }

    public void setName(String name) {
        this.name = name;
    }
}
