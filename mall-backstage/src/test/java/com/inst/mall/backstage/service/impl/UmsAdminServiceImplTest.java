package com.inst.mall.backstage.service.impl;

import com.inst.mall.backstage.MallBackstageApplicationTests;
import com.inst.mall.backstage.entity.po.UmsAdmin;
import com.inst.mall.backstage.service.UmsAdminService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

/**
 * @author aaron
 * @since 2021-04-23
 */
@Slf4j

class UmsAdminServiceImplTest extends MallBackstageApplicationTests {

    @Resource
    private UmsAdminService umsAdminService;


    @Test
    public void todo() {
        UmsAdmin umsAdmin = umsAdminService.getUmsAdmin();
        log.info(umsAdmin.getAccount());
    }
}
