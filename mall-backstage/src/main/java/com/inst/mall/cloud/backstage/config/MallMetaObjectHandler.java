//package com.inst.mall.backstage.config;
//
//import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
//import com.inst.mall.backstage.util.UserUtils;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.ibatis.reflection.MetaObject;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDateTime;
//
///**
// * @author aaron
// */
//@Slf4j
//@Component
//public class MallMetaObjectHandler implements MetaObjectHandler {
//
//
//    /**
//     * 插入时的填充策略
//     *
//     * @param metaObject 对象
//     */
//    @Override
//    public void insertFill(MetaObject metaObject) {
//
//        Integer userId = UserUtils.getCurrentLoginUserId();
//        if(userId==null){
//            userId = -1;
//        }
//        LocalDateTime now = LocalDateTime.now();
//        this.setFieldValByName("createBy", userId, metaObject);
//        this.setFieldValByName("createTime",now, metaObject);
//        this.setFieldValByName("updateBy", userId, metaObject);
//        this.setFieldValByName("updateTime", now, metaObject);
//        this.setFieldValByName("delFlag", false, metaObject);
//
//    }
//
//    /**
//     * 更新时的填充策略
//     *
//     * @param metaObject 对象
//     */
//    @Override
//    public void updateFill(MetaObject metaObject) {
//        Integer userId = UserUtils.getCurrentLoginUserId();
//        if(userId==null){
//            userId = -1;
//        }
//        this.setFieldValByName("updateBy", userId, metaObject);
//        this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
//    }
//
//}
