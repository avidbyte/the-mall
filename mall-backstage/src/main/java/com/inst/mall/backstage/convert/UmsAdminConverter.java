package com.inst.mall.backstage.convert;

import com.inst.mall.backstage.entity.dto.UmsAdminParam;
import com.inst.mall.backstage.entity.po.UmsAdmin;
import org.apache.ibatis.annotations.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * 后台用户实体转换接口
 *
 * @author aaron
 * @since 2021-05-06
 */

@Mapper
public interface UmsAdminConverter {

    UmsAdminConverter INSTANCE = Mappers.getMapper(UmsAdminConverter.class);


    /**
     * param to po
     * @param umsAdminParam  创建/更新 用户参数
     * @return UmsAdmin
     */
    @Mappings({})
    UmsAdmin paramToPo(UmsAdminParam umsAdminParam);
}
