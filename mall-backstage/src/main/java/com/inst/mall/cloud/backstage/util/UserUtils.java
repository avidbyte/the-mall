//package com.inst.mall.cloud.backstage.util;
//;
//
//import com.inst.mall.cloud.backstage.entity.po.UmsAdmin;
//import org.springframework.security.core.context.SecurityContextHolder;
//
///**
// * 用户工具类
// *
// * @author aaron
// * @since 2021-02-09
// */
//public class UserUtils {
//
//    /***
//     * 从当前 线程中 取出 当前的 登录人
//     * @return LoginUser 当前登录人
//     */
//    public static UmsAdmin getCurrentLoginUser() {
////        AdminUserDetails userDetails = (AdminUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if (object == null) {
//            return null;
//        }
//        if(object instanceof String){
//            return null;
//        }
//        AdminUserDetails userDetails = (AdminUserDetails) object;
//        return userDetails.getLoginUser();
//    }
//
//
//    /**
//     * 获取当前登录人的 id
//     *
//     * @return Integer 当前登录人的 id
//     */
//    public static Integer getCurrentLoginUserId() {
//        Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if (object == null) {
//            return null;
//        }
//        if(object instanceof String){
//            return null;
//        }
//        AdminUserDetails userDetails = (AdminUserDetails) object;
//
//        UmsUser loginUser = userDetails.getLoginUser();
//        if (loginUser != null) {
//            return loginUser.getId();
//        }
//        return null;
//    }
//}
