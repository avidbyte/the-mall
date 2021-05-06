package com.inst.mall.backstage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.inst.mall.backstage.entity.dto.EmailRegister;
import com.inst.mall.backstage.entity.dto.PhoneNumberRegister;
import com.inst.mall.backstage.entity.dto.UmsAdminParam;
import com.inst.mall.backstage.entity.po.UmsAdmin;
import com.inst.mall.common.result.CommonPage;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author aaron
 * @since 2021-04-12
 */
public interface UmsAdminService extends IService<UmsAdmin> {


    /**
     * 创建用户
     * @param umsAdminParam 后台用户参数
     */
    void createUser(UmsAdminParam umsAdminParam);

    /**
     * 删除用户
     * @param account 账号
     */
    void delUser(Integer account);

    /**
     * 禁用/启用 用户
     * @param account 账号
     * @param status 状态
     */
    void disableUser(Integer account,Boolean status);

    /**
     * 更新用户
     * @param umsAdminParam 后台用户参数
     */
    void updateUser(UmsAdminParam umsAdminParam);

    /**
     * 根据用户名或昵称分页查询用户
     * @param keyword 关键字
     * @param pageNum 页码
     * @param pageSize 大小
     * @return List<UmsAdmin>
     */
    CommonPage<UmsAdmin> listData(String keyword, Integer pageNum, Integer pageSize);

    /**
     * 根据用户账号获取用户信息
     *
     * @param account 用户名
     * @return UmsAdmin
     */
    UmsAdmin getAdminByAccount(Integer account);

    /**
     * 根据用户id获取用户信息
     *
     * @param id 用户id
     * @return UmsAdmin
     */
    UmsAdmin getAdminById(Integer id);

    /**
     * 邮箱注册
     *
     * @param emailRegister 邮箱注册参数
     */
    void registerByEmail(EmailRegister emailRegister);

    /**
     * 手机号注册
     *
     * @param phoneNumberRegister 手机号注册参数
     */
    void registerByPhoneNumber(PhoneNumberRegister phoneNumberRegister);

    /**
     * 根据用户账号获取用户信息
     *
     * @param account 用户账号
     * @return UserDetails
     */
    UserDetails loadUserByUsername(Integer account);


    /**
     * 检查邮箱
     * @param email 邮箱
     */
    void checkEmail(String email);

    /**
     * 检查手机号
     * @param phoneNumber 手机号
     */
    void checkPhoneNumber(String phoneNumber);


    /**
     * 手机号 是否存在
     * @param phoneNumber 手机号
     * @return boolean
     */
    boolean isPhoneNumberExist(String phoneNumber);


    /**
     * 邮箱 是否存在
     * @param email 邮箱
     * @return boolean
     */
    boolean isEmailExist(String email);

}
