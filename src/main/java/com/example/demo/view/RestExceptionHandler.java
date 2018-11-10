package com.example.demo.view;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author hongjin.zhu
 * @description
 * @date 2018年10月30日 10:56
 * @modified By
 */
@ControllerAdvice
@ResponseBody
public class RestExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public Map handleConstraintViolationException(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> cves = e.getConstraintViolations();
//        for (ConstraintViolation<?> cv : cves){
//            System.out.println(" ==== " + cv.getMessage());
//        }
        System.out.println("=====   异常来了 ");

        Map result = new HashMap<String, Object>(64);
        for (int i = 0; i < 50; i++) {
            result.put("code" + i, "happy new year!");
        }

        System.out.println("====" + result);
        return result;
    }
}
