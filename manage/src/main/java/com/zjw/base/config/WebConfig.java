package com.zjw.base.config;

import com.zjw.base.interceptor.AllInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /**
         * addResoureHandler：指的是对外暴露的访问路径
         * addResourceLocations：指的是内部文件放置的目录
         */
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/**");
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/js/css");
        registry.addResourceHandler("/image/**").addResourceLocations("classpath:/static/image/**");
    }

    @Override
    public void  addInterceptors(InterceptorRegistry registry) {
        /**
         * addInterceptor：需要一个实现HandlerInterceptor接口的拦截器实例
         * addPathPatterns：用于设置拦截器的过滤路径规则；addPathPatterns("/**")对所有请求都拦截
         * excludePathPatterns：用于设置不需要拦截的过滤规则
         */
        registry.addInterceptor(new AllInterceptor()).addPathPatterns("/**/**");
    }

}
