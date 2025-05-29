package com.nuketree3.example.springhw2.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class RecoverExceptionAspect {

    @Around("@annotation(RecoverException)")
    public Object processRecoverException(ProceedingJoinPoint joinPoint) throws Throwable {

        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        RecoverException annotation = method.getAnnotation(RecoverException.class);
        Class<?> returnType = method.getReturnType();

        try {
            return joinPoint.proceed();
        } catch (RuntimeException e) {
            for (Class<? extends RuntimeException> exceptionClass : annotation.noRecoverFor()) {
                if (exceptionClass.isAssignableFrom(e.getClass())) {
                    throw e;
                }
            }
            if (returnType.equals(void.class)) {
                return null;
            } else if (returnType.equals(boolean.class)) {
                return false;
            } else if (returnType.equals(int.class) || returnType.equals(long.class) || returnType.equals(float.class) || returnType.equals(double.class)) {
                return 0;
            } else {
                return null;
            }
        }
    }
}
