//package com.invincible.mall.backstage.config;
//
//import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
//import com.lanlinker.cloud.labor.util.UserUtils;
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
//public class MyMetaObjectHandler implements MetaObjectHandler {
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
//        this.setFieldValByName("createTime", LocalDateTime.now(), metaObject);
//        this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
//        this.setFieldValByName("createBy", userId, metaObject);
//        this.setFieldValByName("updateBy", userId, metaObject);
//        this.setFieldValByName("delFlag", "0", metaObject);
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
