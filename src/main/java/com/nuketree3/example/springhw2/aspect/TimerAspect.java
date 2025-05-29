package com.nuketree3.example.springhw2.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import static java.rmi.server.LogStream.log;

@Slf4j
@Aspect
@Component
public class TimerAspect {
    @Around("@annotation(CustomTimerInter) || @within(CustomTimerInter)")
    public Object timerAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis() - start;

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String methodName = methodSignature.getMethod().getName();
        String className = joinPoint.getTarget().getClass().getName();
        log(className + "- " + methodName + " #" + end);
        return result;
    }
}
