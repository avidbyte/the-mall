package com.inst.mall.cloud.backstage.service.impl;

import cn.hutool.core.util.IdUtil;
import com.inst.mall.cloud.backstage.MallBackstageApplicationTests;
import com.inst.mall.cloud.backstage.service.IncrementSequenceService;
import com.inst.mall.cloud.backstage.service.StringRedisService;
import com.inst.mall.cloud.backstage.service.UmsAdminService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import javax.annotation.Resource;
import java.util.Date;

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
        Integer uid = Math.toIntExact(incrementSequenceService.getSequence());
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

    @Autowired
    JavaMailSender javaMailSender;
    @Test
    public void sendSimpleMail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("这是一封测试邮件");
        message.setFrom("@qq.com");
        message.setTo("@163.com");
//        message.setCc("37xxxxx37@qq.com");
//        message.setBcc("14xxxxx098@qq.com");
        message.setSentDate(new Date());
        message.setText("这是测试邮件的正文");
        javaMailSender.send(message);
    }



}
