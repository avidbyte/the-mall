package com.invincible.mall.backstage.exception;

import com.invincible.mall.common.result.CommonResult;
import com.invincible.mall.common.result.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Iterator;
import java.util.List;


/**
 * controller 参数校验 和 异常捕获 统一返回
 * @author nf
 * @since 2020/1/8 14:36
 */
@Slf4j
@RestControllerAdvice
public class RestControllerAdviceHandler {


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
}
