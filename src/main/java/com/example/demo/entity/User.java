package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author hongjin.zhu
 * @description
 * @date 2018年10月29日 10:53
 * @modified By
 */

@javax.persistence.Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User extends Entity<User> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @NotBlank(message = "name 不能为空！！！！！！！！！！！")
    private String username;

    private String password;

    private String passwordSalt;

    private String phone = "";

    private String email = "";

    private Integer status = 1;

    @Enumerated(EnumType.STRING)
    private Gender gender = Gender.未知性别;

//    @ManyToMany(targetEntity = Role.class)
//    @JoinTable(name = "user_role",
//            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"))
//    private Set<Role> roles = new HashSet<>();
}
