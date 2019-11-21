package com.cwz.springboot.myparnet.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class GetRequest {

    public static HttpServletRequest getHttpRequest(){
        return  ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
    }
}
