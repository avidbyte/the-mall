package com.invincible.mall.backstage.enums;

/**
 * 用户性别枚举类(1男2女3保密)
 *
 * @author aaron
 * @since 2021-02-10
 */
public enum GenderEnum {

    /**
     * 状态类型
     */
    MALE(1, "男"),
    FEMALE(2, "女"),
    SECRET(3, "保密");


    /**
     * code
     */
    private final int code;

    /**
     * description
     */
    private final String description;

    GenderEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static GenderEnum from(int code) {
        for (GenderEnum genderEnum : GenderEnum.values()) {
            if (genderEnum.code == code) {
                return genderEnum;
            }
        }
        return null;
    }

    public static boolean isValidEnum(int code) {
        for (GenderEnum genderEnum : GenderEnum.values()) {
            if (genderEnum.code == code) {
                return true;
            }
        }
        return false;
    }


    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

}
