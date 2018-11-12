package com.example.demo.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author hongjin.zhu
 * @description
 * @date 2018年10月29日 10:53
 * @modified By
 */
@Entity
@Table(name = "users")
@Data
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @NotBlank(message = "name 不能为空！！！！！！！！！！！")
    private String username;

    private String password;

    private String passwordSalt;

    @ManyToMany(targetEntity = Role.class)
    @JoinTable(name = "user_role",
                    joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "user_id"),
                    inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "role_id"))
    private Set<Role> roles = new HashSet<>();
}
