package com.inst.mall.cloud.backstage.config;

import com.inst.cloud.mall.security.component.DynamicSecurityService;
import com.inst.cloud.mall.security.config.SecurityConfig;
import com.inst.mall.cloud.backstage.entity.po.UmsResource;
import com.inst.mall.cloud.backstage.service.UmsAdminService;
import com.inst.mall.cloud.backstage.service.UmsResourceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * 权限配置
 *
 * @author aaron
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MallSecurityConfig extends SecurityConfig {


    private final UmsAdminService adminService;

    private final UmsResourceService resourceService;

    public MallSecurityConfig(UmsAdminService adminService, UmsResourceService resourceService) {
        this.adminService = adminService;
        this.resourceService = resourceService;
    }


    @Override
    @Bean
    public UserDetailsService userDetailsService() {
        //获取登录用户信息
        return adminService::loadUserByUsername;
    }

    @Bean
    public DynamicSecurityService dynamicSecurityService() {
        return new DynamicSecurityService() {
            @Override
            public Map<String, ConfigAttribute> loadDataSource() {
                Map<String, ConfigAttribute> map = new ConcurrentHashMap<>();
                List<UmsResource> resourceList = resourceService.list();
                for (UmsResource resource : resourceList) {
                    map.put(resource.getUrl(), new org.springframework.security.access.SecurityConfig(resource.getId() + ":" + resource.getName()));
                }
                return map;
            }
        };
    }

}
