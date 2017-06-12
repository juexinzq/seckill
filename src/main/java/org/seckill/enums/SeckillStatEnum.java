package org.seckill.enums;/**
 * Created by ${苏雄伟} on 2017/6/12.
 */

/**
 * @author 苏雄伟
 * @description:
 * @create 2017-06-12 16:02
 **/

public enum SeckillStatEnum {
    SUCCESS(1,"秒杀成功"),
    END(2,"秒杀结束"),
    REPEAT_KILL(-1,"重复秒杀"),
    INNER_ERROR(-2,"系统异常"),
    DATA_REWRITE(-3,"数据篡改");

    private int state;
    private String stateInfo;

    SeckillStatEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static SeckillStatEnum stateof(int index){
        for (SeckillStatEnum state:values()) {
            if (state.getState()==index){
                return state;
            }
        }
        return null;
    }
}
