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
@Table(name = "user")
@Data
@NoArgsConstructor
public class User extends Entity<User> implements Serializable {

    @NotBlank(message = "name 不能为空！！！！！！！！！！！")
    private String username;

    private String password;

    private String passwordSalt;

    private String phone = "";

    private String email = "";

    private Integer status = 1;

    @Enumerated(EnumType.STRING)
    private Gender gender = Gender.未知性别;

    @OneToMany
    @JoinColumn(name = "user_id")
    private Set<UserRole> roles = new HashSet<>();

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public User setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public User setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public User setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public User setGender(Gender gender) {
        this.gender = gender;
        return this;
    }
}
