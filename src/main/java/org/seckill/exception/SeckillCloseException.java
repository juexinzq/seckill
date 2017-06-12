package org.seckill.exception;

/**
 * @author 苏雄伟
 * @description:
 * @create 2017-06-12 14:54
 **/

/**
 * 秒杀关闭异常
 */
public class SeckillCloseException extends RuntimeException {
    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}