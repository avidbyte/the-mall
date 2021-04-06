package com.invincible.mall.backstage.security.component;

import org.springframework.security.access.ConfigAttribute;

import java.util.Map;

/**
 * 动态权限相关业务类
 * Created by tyh
 */
public interface DynamicSecurityService {
    /**
     * 加载资源ANT通配符和资源对应MAP
     */
    Map<String, ConfigAttribute> loadDataSource();
}
