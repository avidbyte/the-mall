package com.invincible.mall.common.exception;

import com.invincible.mall.common.result.IErrorCode;

/**
 * 自定义异常
 * @author aaron
 * @since 2021-01-28
 */
public class CustomizeException extends CommonException{

    private static final long serialVersionUID = -3829055812146544592L;

    public CustomizeException() {
        super();
    }

    public CustomizeException(IErrorCode iErrorCode) {
        super(iErrorCode.getCode(), iErrorCode.getMessage());
    }

    public CustomizeException(String code, String msg) {
        super(code, msg);
    }

    public CustomizeException(String msg) {
        super(msg);
    }
}
