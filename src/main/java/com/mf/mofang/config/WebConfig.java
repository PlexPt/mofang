//package com.mf.mofang.config;
//
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//import lombok.extern.slf4j.Slf4j;
//
//
///**
// * 静态资源配置类
// *
// * @author pt
// * @email plexpt@gmail.com
// * @date 2019-09-17 14:11
// */
//@Slf4j
//@Configuration
//@EnableWebMvc
//public class WebConfig extends WebMvcConfigurerAdapter {
//
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        log.info("配置静态资源所在目录");
//        // 和页面有关的静态目录都放在项目的static目录下
//        registry.addResourceHandler("/static/**")
//                .addResourceLocations("classpath:/static/");
//    }
//}
