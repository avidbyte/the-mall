package com.inst.mall.cloud.backstage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.inst.cloud.mall.common.result.CommonPage;
import com.inst.mall.cloud.backstage.entity.dto.EmailRegisterDto;
import com.inst.mall.cloud.backstage.entity.dto.PhoneRegisterDto;
import com.inst.mall.cloud.backstage.entity.dto.UmsAdminDto;
import com.inst.mall.cloud.backstage.entity.po.UmsAdmin;
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


    //controller 调用

    /**
     * 创建用户
     * @param UmsAdminDto 后台用户参数
     */
    void createUser(UmsAdminDto UmsAdminDto);

    /**
     * 删除用户
     * @param username 用户名
     */
    void delUser(String username);

    /**
     * 禁用/启用 用户
     * @param username 用户名
     * @param status 状态
     */
    void disableUser(String username,Boolean status);

    /**
     * 更新用户
     * @param UmsAdminDto 后台用户参数
     */
    void updateUser(UmsAdminDto UmsAdminDto);

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
     * @param username 用户名
     * @return UmsAdminDto
     */
    UmsAdminDto getAdminByUsername(String username);

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
     * @param emailRegisterDto 邮箱注册参数
     */
    void emailRegister(EmailRegisterDto emailRegisterDto);

    /**
     * 手机号注册
     *
     * @param phoneRegisterDto 手机号注册参数
     */
    void phoneRegister(PhoneRegisterDto phoneRegisterDto);

    /**
     * 用户名 是否存在
     * @param username 用户名
     * @return boolean
     */
    boolean isUsernameExist(String username);


    // service 调用


    /**
     * 根据用户账号获取用户信息
     *
     * @param username 用户账号
     * @return UserDetails
     */
    UserDetails loadUserByUsername(String username);

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
