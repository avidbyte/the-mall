package com.inst.cloud.mall.common.result;


import com.inst.cloud.mall.common.exception.PublicException;

/**
 *  断言处理类,用于抛出各种API异常
 * @author aaron
 * @since 2021-04-28
 */
public class Asserts {

    /**
     * 更新失败 抛出异常
     */
    public static void updateFail(boolean flag){
        if(!flag){
            throw new PublicException(ErrorCode.A0400.getCode(),"更新失败");
        }
    }

    /**
     * 根据参数查询对象 结尾为空 抛出异常
     * @param object 对象
     */
    public static void nullObject(Object object){
        if(object ==null){
            throw new PublicException(ErrorCode.A0400);
        }
    }

    /**
     * 参数异常
     */
    public static void parameterException(){
        throw new PublicException(ErrorCode.A0400);
    }

    /**
     * 参数异常
     * @param errorCode 枚举错误码
     */
    public static void parameterException(ErrorCode errorCode){
        throw new PublicException(errorCode);
    }

    /**
     * 参数异常
     * @param code code
     * @param msg msg
     */
    public static void parameterException(String code, String msg){
        throw new PublicException(code,msg);
    }
}
