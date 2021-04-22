//package com.inst.mall.backstage.config;
//
//import com.inst.mall.backstage.security.component.DynamicSecurityService;
//import com.inst.mall.backstage.security.config.SecurityConfig;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.access.ConfigAttribute;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//
//
///**
// * labor权限配置
// * @author aaron
// */
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class LanlinkerLaborSecurityConfig extends SecurityConfig {
//
//
//
//    @Bean
//    @Override
//    public UserDetailsService userDetailsService() {
//        //获取登录用户信息
//        return null;
//    }
//
//
//    @Bean
//    public DynamicSecurityService dynamicSecurityService() {
//        return new DynamicSecurityService() {
//            @Override
//            public Map<String, ConfigAttribute> loadDataSource() {
//                Map<String, ConfigAttribute> map = new ConcurrentHashMap<>();
//                return map;
//            }
//        };
//    }
//
//}
