package com.inst.mall.backstage.service;

import com.inst.mall.backstage.entity.po.UmsAdmin;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author aaron
 * @since 2021-04-12
 */
public interface UmsAdminService extends IService<UmsAdmin> {



    /**
     * 根据用户名获取用户信息
     * @param username 获取用户信息
     * @return UserDetails
     */
    UserDetails loadUserByUsername(String username);


    UmsAdmin getUmsAdmin();
}
