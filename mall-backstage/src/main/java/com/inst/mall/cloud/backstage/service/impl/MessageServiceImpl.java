package com.inst.mall.cloud.backstage.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.inst.cloud.mall.common.exception.PublicException;
import com.inst.cloud.mall.common.exception.UserClientException;
import com.inst.cloud.mall.security.service.RedisService;
import com.inst.mall.cloud.backstage.service.MessageService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author aaron
 * @since 2021-05-12
 */
@Service
public class MessageServiceImpl implements MessageService {


    @Value("${redis.key.account}")
    private String businessKey;


    @Resource
    private RedisService redisService;

    @Override
    public String sendPhoneVerificationCode(String phoneNumber) {
        String result = (String)redisService.get(businessKey+phoneNumber);
        if(StringUtils.isNotBlank(result)){
            throw new UserClientException("频率过快，请稍后再试");
        }
        String code = RandomUtil.randomNumbers(6);
        redisService.set(businessKey+phoneNumber,code,60);
        return code;
    }
}
