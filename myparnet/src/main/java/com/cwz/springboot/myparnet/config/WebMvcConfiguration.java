package com.cwz.springboot.myparnet.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebMvcConfiguration extends WebMvcConfigurationSupport {

    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/register").setViewName("register");
        registry.addViewController("/tourist_index").setViewName("tourist_index");
        registry.addViewController("/growup").setViewName("growup");
        registry.addViewController("/impression").setViewName("impression");
        registry.addViewController("/recommend").setViewName("recommend");
        registry.addViewController("/admin").setViewName("admin");
        registry.addViewController("/bar").setViewName("bar");
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/image/**").addResourceLocations("classpath:/static/image/");
        registry.addResourceHandler("/music/**").addResourceLocations("classpath:/static/music/");
        registry.addResourceHandler("/movie/**").addResourceLocations("classpath:/static/movie/");
        registry.addResourceHandler("/webjars/**") .addResourceLocations("classpath:/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);
    }

}
