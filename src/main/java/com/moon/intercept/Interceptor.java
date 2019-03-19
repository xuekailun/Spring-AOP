package com.moon.intercept;


import com.moon.invoke.Invocation;

import java.lang.reflect.InvocationTargetException;

public interface Interceptor {

    //事前方法
    boolean before();

    //事后方法
    void afrer();

    /***
     * 取代原有时间方法
     * @param invocation --回调参数，可以通过它的proceed方法，回调原有时间
     * @return 原有事件返回对象
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException;

    //是否返回方法，时间没有发生异常执行
    void afterReturning();

    //事后异常方法，当时间发生异常后执行
    void afterThrowing();

    //是否使用around方法取代原有方法
    boolean useAround();
}
