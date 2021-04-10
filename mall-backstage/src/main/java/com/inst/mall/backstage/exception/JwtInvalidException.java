package com.inst.mall.backstage.exception;



/**
 * @author aaron
 */
public class JwtInvalidException extends RuntimeException {
    private static final long serialVersionUID = 3622968027873891667L;

    public JwtInvalidException(String message) {
        super(message);
    }
}
