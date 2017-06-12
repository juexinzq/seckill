package org.seckill.exception;

/**
 * @author 苏雄伟
 * @description:
 * @create 2017-06-12 14:51
 **/

/**
 * 重复秒杀异常（运行期异常）
 */
public class RepeatKillException extends RuntimeException{
    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}