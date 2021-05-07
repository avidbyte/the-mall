package com.inst.mall.cloud.backstage.service.impl;

import com.inst.mall.cloud.backstage.service.IncrementSequenceService;
import com.inst.mall.cloud.backstage.service.StringRedisService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author aaron
 * @since 2021-04-19
 */
@Service
public class IncrementSequenceServiceImpl implements IncrementSequenceService {

    @Value("${redis.key.account}")
    private String account;

    @Resource
    private StringRedisService stringRedisService;

    /**
     * 获取值
     *
     * @return Long
     */
    @Override
    public Long getSequence() {
        return stringRedisService.increment(account);
    }
}
