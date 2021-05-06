package com.inst.mall.backstage.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.inst.mall.backstage.convert.UmsAdminConverter;
import com.inst.mall.backstage.entity.dto.EmailRegister;
import com.inst.mall.backstage.entity.dto.PhoneNumberRegister;
import com.inst.mall.backstage.entity.dto.UmsAdminParam;
import com.inst.mall.backstage.entity.po.UmsAdmin;
import com.inst.mall.backstage.mapper.UmsAdminMapper;
import com.inst.mall.backstage.service.IncrementSequenceService;
import com.inst.mall.backstage.service.UmsAdminService;
import com.inst.mall.common.result.Asserts;
import com.inst.mall.common.result.CommonPage;
import com.inst.mall.common.result.ErrorCode;
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
        Integer uid = Math.toIntExact(incrementSequenceService.getSequence());
        umsAdmin.setAccount(uid);
        save(umsAdmin);
    }

    /**
     * 删除用户
     *
     * @param account 账号
     */
    @Override
    public void delUser(Integer account) {
        lambdaUpdate().eq(UmsAdmin::getAccount,account).remove();
    }

    /**
     * 禁用/启用 用户
     *
     * @param account 账号
     */
    @Override
    public void disableUser(Integer account,Boolean status) {
        UmsAdmin umsAdmin = new UmsAdmin();
        umsAdmin.setStatus(status);
        update(umsAdmin,lambdaUpdate().eq(UmsAdmin::getAccount,account));
    }

    /**
     * 更新用户
     *
     * @param umsAdminParam 后台用户参数
     */
    @Override
    public void updateUser(UmsAdminParam umsAdminParam) {
        UmsAdmin umsAdmin = UmsAdminConverter.INSTANCE.paramToPo(umsAdminParam);
        update(umsAdmin,lambdaUpdate().eq(UmsAdmin::getAccount,umsAdmin.getAccount()));
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
        Page<UmsAdmin> page = page(pageInfo,lambdaQuery().like(UmsAdmin::getNickName,keyword));
        return CommonPage.restPage(page);
    }

    /**
     * 根据用户名获取用户信息
     *
     * @param account 账号
     * @return UmsAdmin
     */
    @Override
    public UmsAdmin getAdminByAccount(Integer account) {
        return getOne(lambdaQuery().eq(UmsAdmin::getAccount,account));
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
        if(isEmailExist(emailRegister.getEmail())){
            UmsAdmin umsAdmin = new UmsAdmin();
            umsAdmin.setStatus(true);
            umsAdmin.setCreateBy(-1);
            Integer uid = Math.toIntExact(incrementSequenceService.getSequence());
            umsAdmin.setAccount(uid);
        }else{
            Asserts.parameterException(ErrorCode.A0400.getCode(),"邮箱已被注册");
        }
    }

    /**
     * 手机号注册
     *
     * @param phoneNumberRegister 手机号注册参数
     */
    @Override
    public void registerByPhoneNumber(PhoneNumberRegister phoneNumberRegister) {
        if(isEmailExist(phoneNumberRegister.getPhoneNumber())){
            UmsAdmin umsAdmin = new UmsAdmin();
            umsAdmin.setStatus(true);
            umsAdmin.setCreateBy(-1);

        }else{
            Asserts.parameterException(ErrorCode.A0400.getCode(),"邮箱已被注册");
        }
    }

    /**
     * 根据用户账号获取用户信息
     *
     * @param account 用户账号
     * @return UserDetails
     */
    @Override
    public UserDetails loadUserByUsername(Integer account) {
        return new User("test", "test", null);
    }

    /**
     * 手机号 是否存在
     *
     * @param phoneNumber 手机号
     * @return boolean
     */
    @Override
    public boolean isPhoneNumberExist(String phoneNumber) {
        UmsAdmin umsAdmin = getOne(lambdaQuery().eq(UmsAdmin::getPhoneNumber,phoneNumber));
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
        UmsAdmin umsAdmin = getOne(lambdaQuery().eq(UmsAdmin::getEmail,email));
        return umsAdmin != null;
    }

}
