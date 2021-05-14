package com.inst.mall.cloud.backstage.controller;

import com.inst.cloud.mall.common.entity.constant.CheckRule;
import com.inst.cloud.mall.common.result.CommonResult;
import com.inst.mall.cloud.backstage.service.MessageService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.Pattern;

/**
 * @author aaron
 * @since 2021-05-12
 */

@Validated
@RestController
@RequestMapping("/msg")
public class MessageController {

    @Resource
    private MessageService messageService;

    @GetMapping("/sendCode")
    public CommonResult<Boolean> sendPhoneVerificationCode(@RequestParam("phoneNumber") @Pattern(regexp = CheckRule.PHONE_NUMBER, message = "手机号格式错误") String phoneNumber) {
        messageService.sendPhoneVerificationCode(phoneNumber);
        return CommonResult.success();
    }


}
