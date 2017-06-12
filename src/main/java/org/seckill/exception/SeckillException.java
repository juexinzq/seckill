package org.seckill.exception;

/**
 * @author 苏雄伟
 * @description:
 * @create 2017-06-12 14:55
 **/

public class SeckillException extends RuntimeException {
    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(Throwable cause) {
        super(cause);
    }
}