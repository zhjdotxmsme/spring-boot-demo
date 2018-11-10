package com.example.demo.entity;

import org.springframework.lang.Nullable;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author hongjin.zhu
 * @description
 * @date 2018年10月30日 09:59
 * @modified By
 */
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(@Nullable Object o, Errors errors) {
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.empty");
//        User user = (User) o;
//        if (((User) o).getPassword().length() < 6) {
//            errors.rejectValue("password", "too short");
//        }
    }
}
