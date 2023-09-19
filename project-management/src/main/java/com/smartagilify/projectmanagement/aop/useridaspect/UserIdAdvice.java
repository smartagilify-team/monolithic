package com.smartagilify.projectmanagement.aop.useridaspect;

import com.smartagilify.core.model.InputDTO;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class UserIdAdvice {
    @Before(value = "execution(* com.smartagilify.core.controllers.BaseController.*(com.smartagilify.core.model.InputDTO)) " +
            "&& args(input)", argNames = "input")
    public void userIdSetter(InputDTO<?> input) {
            input.setUserId(1L);
    }
}