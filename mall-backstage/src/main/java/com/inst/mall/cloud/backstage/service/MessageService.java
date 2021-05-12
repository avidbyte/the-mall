package com.inst.mall.cloud.backstage.service;

import org.springframework.beans.factory.annotation.Value;

/**
 * 信息服务
 *
 * @author aaron
 * @since 2021-05-12
 */
public interface MessageService {


    /**
     * 发送手机验证码 频率限制60秒一次
     * @param phoneNumber 手机号
     * @return String
     */
    String sendPhoneVerificationCode(String phoneNumber);
}
