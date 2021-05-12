package com.inst.mall.cloud.backstage.entity.constant;

/**
 * @author aaron
 * @since 2021-05-06
 */
public class EmailConstant {

    private EmailConstant(){}

    public final static String FROM = "*****@qq.com";
    public final static String REGISTER_SUBJECT = "TheMall注册验证码";
    public final static String MODIFY_SUBJECT = "TheMall更改绑定邮箱验证码";
    public final static String RESET_SUBJECT = "TheMall变更重要信息";
    public final static String PREFIX = "[TheMall]您的验证码为";
    public final static String SUFFIX = ",请勿将验证码转让给其他人看。";
}
