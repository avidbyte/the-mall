package com.inst.cloud.mall.common.exception;

import com.inst.cloud.mall.common.result.ErrorCode;
import com.inst.cloud.mall.common.result.IErrorCode;

/**
 * 用户端异常
 * @author aaron
 * @since 2021-05-12
 */
public class UserClientException extends CommonException {

    private static final long serialVersionUID = 4790064687927579753L;

    public UserClientException() {
        super();
    }

    public UserClientException(IErrorCode iErrorCode) {
        super(iErrorCode.getCode(), iErrorCode.getMessage());
    }

    public UserClientException(String code, String msg) {
        super(code, msg);
    }

    public UserClientException(String msg) {
        super(ErrorCode.A0400.getCode(),msg);
    }

}
