package com.inst.cloud.mall.security.exception;


/**
 *
 * @author aaron
 */
public class JwtExpiredException extends RuntimeException {
    private static final long serialVersionUID = 4192741894448187639L;

    public JwtExpiredException(String message) {
        super(message);
    }
}
