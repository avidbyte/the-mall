package com.inst.cloud.mall.common.exception;


import com.inst.cloud.mall.common.result.IErrorCode;

/**
 * 公共异常
 * @author aaron
 * @since 2021-01-28
 */
public class PublicException extends CommonException {

    private static final long serialVersionUID = 4790064787927579753L;

    public PublicException() {
        super();
    }

    public PublicException(IErrorCode iErrorCode) {
        super(iErrorCode.getCode(), iErrorCode.getMessage());
    }

    public PublicException(String code, String msg) {
        super(code, msg);
    }

    public PublicException(String msg) {
        super(msg);
    }
}
