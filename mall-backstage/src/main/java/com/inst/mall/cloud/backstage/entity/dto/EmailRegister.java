package com.inst.mall.cloud.backstage.entity.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * 邮箱注册参数
 * @author aaron
 * @since 2021-05-06
 */
@Data
public class EmailRegister {

    /**
     * 邮箱
     */
    @Email(message = "邮箱格式不合法")
    private String email;


    /**
     * 验证码
     */
    @NotBlank(message = "验证码不能为空")
    private String verificationCode;
}
