package com.inst.mall.backstage.entity.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * 创建/更新 用户参数
 *
 * @author aaron
 * @since 2021-05-06
 */
@Data
public class UmsAdminParam {

    public interface Create {
    }

    public interface Update {
    }

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 账号
     */
    @NotBlank(groups = {Update.class},message = "账号不能为空")
    private String account;

    /**
     * 密码
     */
    @NotEmpty(groups = {Create.class},message = "密码不能为空")
    private String password;

    /**
     * 用户头像
     */
    private String icon;

    /**
     * 邮箱
     */
    @Email(message = "邮箱格式不合法")
    private String email;

    /**
     * 手机号
     */
    @Pattern(regexp = "^1[0-9]{10}$", message = "手机号格式错误")
    private String mobile;

    /**
     * 备注
     */
    private String note;

}
