package com.inst.mall.cloud.backstage.convert;

import com.inst.mall.cloud.backstage.entity.dto.UmsAdminDto;
import com.inst.mall.cloud.backstage.entity.po.UmsAdmin;
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
     * dto to po
     * @param UmsAdminDto  dto
     * @return UmsAdmin
     */
    @Mappings({})
    UmsAdmin dtoToPo(UmsAdminDto UmsAdminDto);

    /**
     * po to dto
     * @param umsAdmin  po
     * @return UmsAdminDto
     */
    @Mappings({})
    UmsAdminDto poToDto(UmsAdmin umsAdmin);
}
