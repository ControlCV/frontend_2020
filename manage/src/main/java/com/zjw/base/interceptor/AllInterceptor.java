package com.zjw.base.interceptor;

import com.zjw.base.util.TokenUtil;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

public class AllInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //得到传来的token
        String token = request.getHeader("token");
        //传来的userId
        InputStream inputStream=request.getInputStream();

        StringBuffer stringBuffer = new StringBuffer();


        //校验token
        if(StringUtils.isEmpty(token)){
            TokenUtil.verify(token);
        }

        return true;
    }

}
