package com.inst.mall.backstage.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 劳务系统用户信息表
 * </p>
 *
 * @author aaron
 * @since 2021-02-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_user")
public class SysUser extends Model<SysUser> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 出生日期
     */
    private LocalDate birthday;

    /**
     * 性别(1男女3保密)
     */
    private Integer gender;

    /**
     * 头像
     */
    private String headPortrait;

    /**
     * 手机绑定时间
     */
    private LocalDateTime mobileBindTime;

    /**
     * 邮箱绑定时间
     */
    private LocalDateTime emailBindTime;

    /**
     * 最后登录时间
     */
    private LocalDateTime loginTime;

    /**
     * 用户状态 0 禁用 1已启用
     */
    private Boolean userStatus;

    /**
     * 创建人
     */
    private Integer createBy;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改人
     */
    private Integer updateBy;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 备注

     */
    private String remarks;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
