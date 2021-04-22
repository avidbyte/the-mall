package com.inst.mall.backstage.service.impl;

import com.inst.mall.backstage.entity.po.UmsAdmin;
import com.inst.mall.backstage.mapper.UmsAdminMapper;
import com.inst.mall.backstage.service.UmsAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author aaron
 * @since 2021-04-12
 */
@Service
public class UmsAdminServiceImpl extends ServiceImpl<UmsAdminMapper, UmsAdmin> implements UmsAdminService {

    @Override
    public UserDetails loadUserByUsername(String username) {
        return null;
    }
}
