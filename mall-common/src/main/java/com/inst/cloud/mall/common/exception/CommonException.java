package com.inst.cloud.mall.common.exception;


import com.inst.cloud.mall.common.result.ErrorCode;
import lombok.Getter;
import lombok.Setter;

/**
 * 公共异常
 * @author aaron
 * @since 2021-01-28
 */
@Getter
@Setter
public class CommonException extends RuntimeException {

    private static final long serialVersionUID = 164356938178032075L;

    protected String code;
    protected String message;

    public CommonException() {
        this.code= ErrorCode.B0001.getCode();
        this.message = ErrorCode.B0001.getMessage();
    }

    public CommonException(String msg) {
        this.code= ErrorCode.B0001.getCode();
        this.message = msg;
    }

    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public CommonException(String code, String msg) {
        this.code = code;
        this.message = msg;
    }
}
