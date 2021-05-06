package com.inst.mall.backstage.service.impl;

import cn.hutool.core.util.IdUtil;
import com.inst.mall.backstage.MallBackstageApplicationTests;
import com.inst.mall.backstage.service.IncrementSequenceService;
import com.inst.mall.backstage.service.StringRedisService;
import com.inst.mall.backstage.service.UmsAdminService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;

/**
 * @author aaron
 * @since 2021-04-23
 */
@Slf4j
class UmsAdminServiceImplTest extends MallBackstageApplicationTests {


    @Value("${redis.key.account}")
    private String account;

    @Resource
    private UmsAdminService umsAdminService;

    @Resource
    private IncrementSequenceService incrementSequenceService;

    @Resource
    private StringRedisService stringRedisService;

    @Test
    public void todo() {
        stringRedisService.set(account,"20000");
        Long id = incrementSequenceService.getSequence();
        System.out.println(id);

    }

    public static void main(String[] args) {
        String fastSimpleUUID =  IdUtil.fastSimpleUUID();
        String simpleUUID =  IdUtil.simpleUUID();
        String fastUUID =  IdUtil.fastUUID();
        String randomUUID =  IdUtil.randomUUID();
        String objectId =  IdUtil.objectId();


        System.out.println("fastSimpleUUID："+fastSimpleUUID+"："+fastSimpleUUID.length());
        System.out.println("simpleUUID："+simpleUUID+"："+simpleUUID.length());
        System.out.println("fastUUID："+fastUUID+"："+fastUUID.length());
        System.out.println("randomUUID："+randomUUID+"："+randomUUID.length());
        System.out.println("objectId："+objectId+"："+objectId.length());
    }

}
