package com.govhub.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Sin
 * @date 2022/7/31
 */
@ControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler(Exception.class)
    public void doException(Exception exception) {
        System.out.println("出现了这个异常" + exception);
        System.out.println("所有类型异常处理中心");
    }
}


