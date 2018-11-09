package com.example.demo.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

/**
 * @author hongjin.zhu
 * @description
 * @date 2018年10月29日 10:53
 * @modified By
 */
@Entity
@Table(name = "users")
@DynamicUpdate
@DynamicInsert
@Data
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotBlank(message = "name 不能为空！！！！！！！！！！！")
    private String username;

    private String password;

    private String passwordSalt;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role",
                    joinColumns = {@JoinColumn(name = "user_id")},
                    inverseJoinColumns = {@JoinColumn(name = "role_id")})
    @OrderBy("user_id desc")
    private Set<Role> roles;
}
