package com.inst.cloud.mall.security.exception;



/**
 * @author aaron
 */
public class JwtInvalidException extends RuntimeException {
    private static final long serialVersionUID = 3622968027873891667L;

    public JwtInvalidException(String message) {
        super(message);
    }
}
