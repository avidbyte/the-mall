package com.inst.mall.common.util;


import com.inst.mall.common.enums.AccountType;

/**
 * 正则表达式判断工具类
 *
 * @author battle
 * @since 2020-01-16 16:29:03
 */
public class AccountUtils {

    /**
     * 数字帐号 1-10 位的全数字
     */
    private static final String ID_REGEX = "^\\d{1,10}$";
    /**
     * 登录账号 由简体中文或大小写英文字母或 数字或下划线组成 ，首字母只能是简体中文或大小写英文字母 ,长度 1-18 位字符
     */
    private static final String ACCOUNT_NUMBER = "^[A-Za-z\\u4e00-\\u9fa5][\\w\\u4e00-\\u9fa5]{0,17}$";
    /**
     * 手机帐号 1开头+10位数字
     */
    private static final String MOBILE_REGEX = "^1[0-9]{10}$";
    /**
     * 邮箱帐号 字符串中包含 @, 长度 36 位(由程序判断字符串长度)，中间有小数点
     */
    private static final String EMAIL_REGEX = "^\\w[-\\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\\.)+[A-Za-z]{2,}$";
    /**
     * 身份证帐号 18位(前17位全数字,最后一位是数字或X)，并符合公安局正则表达式
     */
    private static final String IDENTITY_REGEX = "^[1-9]\\d{5}(18|19|20){1}\\d{2}(0[1-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])\\d{3}[\\d|X]$";
    /**
     * 营业执照帐号 18位统一社会信用代码编号（由数字和大写字母组成）+下划线+13位部门序号（可以是英文字母和数字和下划线的组合）=最长32位字符(序号是为了生成不同地区的部门)
     */
    private static final String LICENSE_REGEX = "^[A-Z0-9]{18}(_[A-Z0-9]+)*$";

    /**
     * 用户账号类型判断
     *
     * @param account 账号
     * @return UserAccountTypeEnum 英文类型标识
     */
    public static String accountRegexMatch(String account) {

        //判断是否是昵称帐号
        if (account.matches(ACCOUNT_NUMBER)) {
            return AccountType.ACCOUNT_NUMBER.getCode();
        }

        //判断是否是手机帐号
        if (account.matches(MOBILE_REGEX)) {
            return AccountType.MOBILE.getCode();
        }

        //判断是否是邮箱帐号
        if (account.matches(EMAIL_REGEX)) {
            return AccountType.EMAIL.getCode();
        }
        return null;
    }
}
