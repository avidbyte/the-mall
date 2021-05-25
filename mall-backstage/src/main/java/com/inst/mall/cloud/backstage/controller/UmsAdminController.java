package com.inst.mall.cloud.backstage.controller;


import com.inst.cloud.mall.common.result.CommonPage;
import com.inst.cloud.mall.common.result.CommonResult;
import com.inst.mall.cloud.backstage.entity.dto.EmailRegisterDto;
import com.inst.mall.cloud.backstage.entity.dto.PhoneRegisterDto;
import com.inst.mall.cloud.backstage.entity.dto.UmsAdminDto;
import com.inst.mall.cloud.backstage.entity.po.UmsAdmin;
import com.inst.mall.cloud.backstage.service.UmsAdminService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户列表
 * </p>
 *
 * @author aaron
 * @since 2021-04-12
 */
@Validated
@RestController
@RequestMapping("/admin")
public class UmsAdminController {

    private final UmsAdminService umsAdminService;

    public UmsAdminController(UmsAdminService umsAdminService){
        this.umsAdminService=umsAdminService;
    }


    /**
     * 创建用户
     *
     * @param umsAdminDto 后台用户参数
     */
    @PostMapping("/createUser")
    CommonResult<Boolean> createUser(@RequestBody @Validated(UmsAdminDto.Create.class) UmsAdminDto umsAdminDto) {
        umsAdminService.createUser(umsAdminDto);
        return CommonResult.success();
    }

    /**
     * 删除用户
     *
     * @param username 用户名
     */
    @DeleteMapping("/delUser")
    CommonResult<Boolean> delUser(@RequestParam("username") String username) {
        umsAdminService.delUser(username);
        return CommonResult.success();
    }

    /**
     * 禁用/启用 用户
     *
     * @param username 用户名
     * @param status   状态
     */
    @DeleteMapping("/disableUser")
    CommonResult<Boolean> disableUser(String username, Boolean status) {
        umsAdminService.disableUser(username,status);
        return CommonResult.success();
    }

    /**
     * 更新用户
     *
     * @param umsAdminDto 后台用户参数
     */
    @PutMapping("/updateUser")
    CommonResult<Boolean> updateUser(@RequestBody @Validated(UmsAdminDto.Update.class) UmsAdminDto umsAdminDto) {
        umsAdminService.updateUser(umsAdminDto);
        return CommonResult.success();
    }

    /**
     * 根据用户名或昵称分页查询用户
     *
     * @param keyword  关键字
     * @param pageNum  页码
     * @param pageSize 大小
     * @return List<UmsAdmin>
     */
    @GetMapping("/listData")
    CommonResult<CommonPage<UmsAdmin>> listData(@RequestParam("keyword") String keyword,
                                                @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                                @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize) {
        CommonPage<UmsAdmin> umsAdminCommonPage = umsAdminService.listData(keyword,pageNum,pageSize);
        return CommonResult.success(umsAdminCommonPage);
    }

    /**
     * 根据用户账号获取用户信息
     *
     * @param username 用户名
     * @return UmsAdmin
     */
    @GetMapping("/getDetail")
    CommonResult<UmsAdminDto> getDetail(@RequestParam("username") String username) {
        UmsAdminDto umsAdminDto =  umsAdminService.getAdminByUsername(username);
        return CommonResult.success(umsAdminDto);
    }

    /**
     * 邮箱注册
     *
     * @param emailRegisterDto 邮箱注册参数
     */
    @PostMapping("/emailRegister")
    CommonResult<Boolean> emailRegister(@RequestBody  @Validated EmailRegisterDto emailRegisterDto) {
        umsAdminService.emailRegister(emailRegisterDto);
        return CommonResult.success();
    }

    /**
     * 手机号注册
     *
     * @param phoneRegisterDto 手机号注册参数
     */
    @PostMapping("/phoneRegister")
    CommonResult<Boolean> phoneRegister(@RequestBody @Validated  PhoneRegisterDto phoneRegisterDto) {
        umsAdminService.phoneRegister(phoneRegisterDto);
        return CommonResult.success();
    }

    /**
     * 用户名 是否存在
     *
     * @param username 用户名
     * @return boolean
     */
    @GetMapping("/verifyWhetherUserExists")
    CommonResult<Boolean> isUsernameExist(@RequestParam("username") String username) {
        Boolean result = umsAdminService.isUsernameExist(username);
        return CommonResult.success(result);
    }
}
