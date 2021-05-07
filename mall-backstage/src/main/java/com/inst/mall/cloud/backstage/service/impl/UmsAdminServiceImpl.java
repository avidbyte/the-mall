package com.inst.mall.cloud.backstage.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.inst.mall.cloud.backstage.convert.UmsAdminConverter;
import com.inst.mall.cloud.backstage.entity.dto.EmailRegister;
import com.inst.mall.cloud.backstage.entity.dto.PhoneNumberRegister;
import com.inst.mall.cloud.backstage.entity.dto.UmsAdminParam;
import com.inst.mall.cloud.backstage.entity.po.UmsAdmin;
import com.inst.mall.cloud.backstage.mapper.UmsAdminMapper;
import com.inst.mall.cloud.backstage.service.IncrementSequenceService;
import com.inst.mall.cloud.backstage.service.UmsAdminService;
import com.inst.cloud.mall.common.result.Asserts;
import com.inst.cloud.mall.common.result.CommonPage;
import com.inst.cloud.mall.common.result.ErrorCode;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author aaron
 * @since 2021-04-12
 */
@Service
public class UmsAdminServiceImpl extends ServiceImpl<UmsAdminMapper, UmsAdmin> implements UmsAdminService {

    @Resource
    private IncrementSequenceService incrementSequenceService;

    /**
     * 创建用户
     *
     * @param umsAdminParam 后台用户参数
     */
    @Override
    public void createUser(UmsAdminParam umsAdminParam) {
        UmsAdmin umsAdmin = UmsAdminConverter.INSTANCE.paramToPo(umsAdminParam);
        save(umsAdmin);
    }

    /**
     * 删除用户
     *
     * @param username 用户名
     */
    @Override
    public void delUser(String username) {
        lambdaUpdate().eq(UmsAdmin::getUsername, username).remove();
    }

    /**
     * 禁用/启用 用户
     * @param username 用户名
     * @param status 状态
     */
    @Override
    public void disableUser(String username, Boolean status) {
        UmsAdmin umsAdmin = new UmsAdmin();
        umsAdmin.setStatus(status);
        update(umsAdmin, lambdaUpdate().eq(UmsAdmin::getUsername, username));
    }

    /**
     * 更新用户
     *
     * @param umsAdminParam 后台用户参数
     */
    @Override
    public void updateUser(UmsAdminParam umsAdminParam) {
        UmsAdmin umsAdmin = UmsAdminConverter.INSTANCE.paramToPo(umsAdminParam);
        update(umsAdmin, lambdaUpdate().eq(UmsAdmin::getUsername, umsAdmin.getUsername()));
    }

    /**
     * 根据用户名或昵称分页查询用户
     *
     * @param keyword  关键字
     * @param pageNum  页码
     * @param pageSize 大小
     * @return List<UmsAdmin>
     */
    @Override
    public CommonPage<UmsAdmin> listData(String keyword, Integer pageNum, Integer pageSize) {
        Page<UmsAdmin> pageInfo = new Page<>();
        Page<UmsAdmin> page = page(pageInfo, lambdaQuery().like(UmsAdmin::getNickName, keyword));
        return CommonPage.restPage(page);
    }

    /**
     * 根据用户名获取用户信息
     *
     * @param username 用户名
     * @return UmsAdmin
     */
    @Override
    public UmsAdmin getAdminByAccount(String username) {
        return getOne(lambdaQuery().eq(UmsAdmin::getUsername, username));
    }

    /**
     * 根据用户id获取用户信息
     *
     * @param id 用户id
     * @return UmsAdmin
     */
    @Override
    public UmsAdmin getAdminById(Integer id) {
        return getById(id);
    }

    /**
     * 邮箱注册
     *
     * @param emailRegister 用户登录参数
     */
    @Override
    public void registerByEmail(EmailRegister emailRegister) {
        checkEmail(emailRegister.getEmail());
        UmsAdmin umsAdmin = new UmsAdmin();
        umsAdmin.setStatus(true);
        umsAdmin.setCreateBy(-1);
    }

    /**
     * 手机号注册
     *
     * @param phoneNumberRegister 手机号注册参数
     */
    @Override
    public void registerByPhoneNumber(PhoneNumberRegister phoneNumberRegister) {
        checkPhoneNumber(phoneNumberRegister.getPhoneNumber());
        UmsAdmin umsAdmin = new UmsAdmin();
        umsAdmin.setStatus(true);
        umsAdmin.setCreateBy(-1);
    }

    /**
     * 根据用户账号获取用户信息
     *
     * @param account 用户账号
     * @return UserDetails
     */
    @Override
    public UserDetails loadUserByUsername(String account) {

        return new User("test", "test", null);
    }

    /**
     * 检查邮箱
     *
     * @param email 邮箱
     */
    @Override
    public void checkEmail(String email) {
        if (!isEmailExist(email)) {
            Asserts.parameterException(ErrorCode.A0400.getCode(), "邮箱已被注册");
        }
    }


    /**
     * 检查手机号
     *
     * @param phoneNumber 手机号
     */
    @Override
    public void checkPhoneNumber(String phoneNumber) {
        if (!isPhoneNumberExist(phoneNumber)) {
            Asserts.parameterException(ErrorCode.A0400.getCode(), "手机号已被注册");
        }
    }

    /**
     * 手机号 是否存在
     *
     * @param phoneNumber 手机号
     * @return boolean
     */
    @Override
    public boolean isPhoneNumberExist(String phoneNumber) {
        UmsAdmin umsAdmin = getOne(lambdaQuery().eq(UmsAdmin::getPhoneNumber, phoneNumber));
        return umsAdmin != null;
    }

    /**
     * 邮箱 是否存在
     *
     * @param email 邮箱
     * @return boolean
     */
    @Override
    public boolean isEmailExist(String email) {
        UmsAdmin umsAdmin = getOne(lambdaQuery().eq(UmsAdmin::getEmail, email));
        return umsAdmin != null;
    }

    /**
     * 用户名 是否存在
     *
     * @param username 用户名
     * @return boolean
     */
    @Override
    public boolean isUsernameExist(String username) {
        UmsAdmin umsAdmin = getOne(lambdaQuery().eq(UmsAdmin::getUsername, username));
        return umsAdmin != null;
    }

}
