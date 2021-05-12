package com.inst.mall.cloud.backstage.controller;

import com.inst.cloud.mall.common.result.CommonResult;
import com.inst.mall.cloud.backstage.service.MessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author aaron
 * @since 2021-05-12
 */

@RestController
@RequestMapping("/msg")
public class MessageController {

    @Resource
    private MessageService messageService;

    @GetMapping("/sendCode")
    CommonResult<String> sendPhoneVerificationCode(@RequestParam("phoneNumber") String phoneNumber) {
        String code = messageService.sendPhoneVerificationCode(phoneNumber);
        return CommonResult.success(code);
    }


}
