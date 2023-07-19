package com.smartagilify.projectmanagement.aop.useridaspect;

import com.smartagilify.core.model.InputDTO;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Slf4j
@Aspect
@Component
public class UserIdAdvice {
    @Around("execution(* com.smartagilify.core.controllers.BaseController.*(..) )")
    public Object userIdSetter(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        Object argument = args[0];
        if (argument instanceof InputDTO<?>){
            log.info("Intercepting the post request");
            InputDTO<?> input = (InputDTO<?>) argument;
            input.setUserId(1L); args[0] = input;
            return joinPoint.proceed(args);
        }
        return joinPoint.proceed(args);
    }
}