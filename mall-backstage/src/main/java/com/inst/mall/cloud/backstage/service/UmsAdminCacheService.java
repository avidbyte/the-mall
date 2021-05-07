package com.inst.mall.cloud.backstage.service;

import com.inst.mall.cloud.backstage.entity.po.UmsAdmin;
import com.inst.mall.cloud.backstage.entity.po.UmsResource;

import java.util.List;

/**
 * 后台用户缓存操作接口
 *
 * @author aaron
 * @since 2021-05-07
 */
public interface UmsAdminCacheService {

    /**
     * 设置缓存后台用户信息
     *
     * @param admin 后台用户信息
     */
    void setAdmin(UmsAdmin admin);

    /**
     * 获取缓存后台用户信息
     *
     * @param username 用户名
     * @return UmsAdmin
     */
    UmsAdmin getAdmin(String username);

    /**
     * 删除后台用户缓存
     *
     * @param adminId 后台用户id
     */
    void delAdmin(Integer adminId);

    /**
     * 删除后台用户缓存
     *
     * @param username 后台用户名
     */
    void delAdmin(String username);

    /**
     * 当角色相关资源信息改变时删除相关后台用户缓存
     *
     * @param roleId 角色id
     */
    void delResourceListByRole(Long roleId);

    /**
     * 当角色相关资源信息改变时删除相关后台用户缓存
     *
     * @param roleIds 角色id集合
     */
    void delResourceListByRoleIds(List<Long> roleIds);

    /**
     * 删除后台用户资源列表缓存
     *
     * @param adminId 后台用户id
     */
    void delResourceList(Long adminId);

    /**
     * 当资源信息改变时，删除资源项目后台用户缓存
     *
     * @param resourceId 资源id
     */
    void delResourceListByResource(Long resourceId);

    /**
     * 获取缓存后台用户资源列表
     *
     * @param adminId 后台用户id
     * @return List<UmsResource>
     */
    List<UmsResource> getResourceList(Long adminId);

    /**
     * 设置后台后台用户资源列表
     *
     * @param adminId      后台用户id
     * @param resourceList 资源集合
     */
    void setResourceList(Long adminId, List<UmsResource> resourceList);

}
