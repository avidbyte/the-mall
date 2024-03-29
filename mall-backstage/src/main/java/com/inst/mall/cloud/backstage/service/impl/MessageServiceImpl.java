package com.inst.mall.cloud.backstage.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.inst.cloud.mall.common.exception.UserClientException;
import com.inst.cloud.mall.security.service.RedisService;
import com.inst.mall.cloud.backstage.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author aaron
 * @since 2021-05-12
 */
@Service
@Slf4j
public class MessageServiceImpl implements MessageService {


    @Value("${redis.key.account}")
    private String businessKey;


    @Resource
    private RedisService redisService;

    @Override
    public void sendPhoneVerificationCode(String phoneNumber) {
        String result = (String)redisService.get(businessKey+phoneNumber);
        if(StringUtils.isNotBlank(result)){
            throw new UserClientException("频率过快，请稍后再试");
        }
        String code = RandomUtil.randomNumbers(6);
        log.info(code);
        redisService.set(businessKey+phoneNumber,code,60);
    }
}
