package com.inst.cloud.mall.common.exception;


import com.inst.cloud.mall.common.result.CommonResult;
import com.inst.cloud.mall.common.result.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Iterator;
import java.util.List;

/**
 * @author aaron
 * @since 2020-10-10
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler{


    /**
     * MethodArgumentNotValidException 参数不合法异常
     * 配和 @Valid 注解
     * @param e 参数不合法异常
     * @return CommonResult<Object>
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    CommonResult<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        List<ObjectError> objectErrors = e.getBindingResult().getAllErrors();
        int firstIndex = 0;
        String message = objectErrors.get(firstIndex).getDefaultMessage();
        log.error("MethodArgumentNotValidException = {}",message);
        return CommonResult.failed(ErrorCode.A0400,message);
    }

    /**
     * MethodArgumentNotValidException 参数不合法异常
     * 配和 @Valid 注解
     * @param e 参数不合法异常
     * @return CommonResult<Object>
     */
    @ExceptionHandler(ConstraintViolationException.class)
    CommonResult<Object> handleMethodArgumentNotValidException(ConstraintViolationException e){
        Iterator<ConstraintViolation<?>>
                iterator = e.getConstraintViolations().iterator();
        String message = null;
        if (iterator.hasNext()) {
            message = iterator.next().getMessage();
        }
        log.error("ConstraintViolationException = {}",message);
        return CommonResult.failed(ErrorCode.A0400,message);
    }


    /**
     * 处理空指针的异常
     * @param req request
     * @param e exception
     * @return CommonResult<Boolean>
     */
    @ExceptionHandler(value = NullPointerException.class)
    public CommonResult<Boolean> exceptionHandler(HttpServletRequest req, NullPointerException e){
        log.error(req.getServletPath()+"接口发生异常！原因是:{}",e);
        return CommonResult.failed(ErrorCode.B0001,"空指针的异常");
    }

    /**
     * 异常
     * @param req request
     * @param e exception
     * @return CommonResult<Boolean>
     */
    @ExceptionHandler(value = Exception.class)
    public CommonResult<Boolean> exceptionHandler(HttpServletRequest req, Exception e){
        log.error(req.getServletPath()+"接口发生异常！原因是:{}",e);
        return CommonResult.failed(ErrorCode.B0001,e.getMessage());
    }

    /**
     * 自定义异常
     * @param req request
     * @param e   exception
     * @return CommonResult<Boolean>
     */
    @ExceptionHandler(value = CustomizeException.class)
    public CommonResult<Boolean> exceptionHandler(HttpServletRequest req, CustomizeException e) {
        log.error(req.getServletPath()+"接口发生异常！原因是:{}",e);
        return CommonResult.failed(e.getCode(), e.getMessage());
    }

    /**
     * 用户端异常
     * @param e exception
     * @return CommonResult<Boolean>
     */
    @ExceptionHandler(value = UserClientException.class)
    public CommonResult<Boolean> exceptionUserClient(UserClientException e) {
        return CommonResult.failed(e.getCode(), e.getMessage());
    }

}
