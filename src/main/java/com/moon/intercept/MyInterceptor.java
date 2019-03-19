package com.moon.intercept;

import com.moon.invoke.Invocation;
import lombok.extern.slf4j.Slf4j;


import java.lang.reflect.InvocationTargetException;

@Slf4j
public class MyInterceptor implements Interceptor {
    @Override
    public boolean before() {
        log.info("before............");
        return true;
    }

    @Override
    public void afrer() {
        log.info("afrer............");
    }

    @Override
    public Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException {
        log.info("around before...............");
        Object object = invocation.proceed();
        log.info("around after...............");
        return object;
    }

    @Override
    public void afterReturning() {
        log.info("afterReturning............");
    }

    @Override
    public void afterThrowing() {
        log.info("afterThrowing............");
    }

    @Override
    public boolean useAround() {
        return true;
    }
}
