package com.inst.mall.cloud.backstage.entity.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * 手机号注册参数
 * @author aaron
 * @since 2021-05-06
 */
@Data
public class PhoneRegisterDto {

    /**
     * 手机号
     */
    @Pattern(regexp = "^1[0-9]{10}$", message = "手机号格式错误")
    private String phoneNumber;

    /**
     * 验证码
     */
    @NotBlank(message = "验证码不能为空")
    private String verificationCode;


}
