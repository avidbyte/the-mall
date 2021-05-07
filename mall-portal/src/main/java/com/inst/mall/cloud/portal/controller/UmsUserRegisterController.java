package com.inst.mall.cloud.portal.controller;

import com.inst.cloud.mall.common.result.CommonResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 注册接口
 * </p>
 *
 * @author aaron
 * @since 2021-04-19
 */
@RestController
@RequestMapping("/register")
public class UmsUserRegisterController {


    @PostMapping("email")
    public CommonResult<Boolean> emailRegister(){
        return CommonResult.success();
    }


    @PostMapping("mobile")
    public CommonResult<Boolean> mobileRegister(){
        return CommonResult.success();
    }



}
