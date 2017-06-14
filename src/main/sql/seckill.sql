--秒杀执行的存储过程
DELIMITER $$ -- console;转换为$$
--定义存储过程
--参数：in 输入参数 out 输出参数
--row_count():返回上一条修改数据sql（delete,insert,update）的影响行数
--row_count:0:未修改数据;>0表示修改的行数；<0：sql错误/未执行修改sql
CREATE PROCEDURE 'seckill'.'execute_seckill'
  (in v_seclill_id bigint,in v_phone bigint,
    in v_kill_time timestamp,out r_result int)
  BEGIN
    DECLARE insert_count int DEFAULT 0;
    START TRANSACTION;
    insert ignore into success_killed
      (seckill_id,user_phone,create_time)
      values (v_seckill_id,v_phone,v_kill_time);
    select row_count() into insert_count;
    IF (insert_count==0) THEN
      ROLLBACK;
      SET r_result=-1;
    ELSELF(insert_count<0) THEN
      ROLLBACK;
      SET r_result=-2;
    ELSE
      update seckill
      set number=number-1
      where seckill_id=v_seckill_id
        and end_time>v_kill_time
        and start_time<v_kill_time
        and number>0;
        select row_count() into insert_count;
        IF (insert_count==0) THEN
          ROLLBACK;
          SET r_result=0;
        ELSEIF (insert_count<0) THEN
          ROLLBACK;
          SET r_result=-2;
        ELSE
          COMMIT;
          set r_result=1;
        END IF;
    END IF;
  END;
$$
--存储过程定义结束
DELIMITER ;
set @r_result=-3;
--执行存储过程
call execute_seckill(1003,13502178891,now(),@r_result);

--获取结果
select @r_result;


--github别人的
DELIMITER $$
CREATE PROCEDURE excuteSeckill(IN fadeSeckillId INT,IN fadeUserPhone VARCHAR (15),IN fadeKillTime TIMESTAMP ,OUT fadeResult INT)
  BEGIN
    DECLARE insert_count INT DEFAULT 0;
    START TRANSACTION ;
    INSERT ignore success_kill(seckill_id,user_phone,status,create_time) VALUES(fadeSeckillId,fadeUserPhone,0,fadeKillTime);
    SELECT ROW_COUNT() INTO insert_count;
    IF(insert_count = 0) THEN
      ROLLBACK ;
      SET fadeResult = -1;
    ELSEIF(insert_count < 0) THEN
      ROLLBACK ;
      SET fadeResult = -2;
    ELSE
      UPDATE seckill SET number = number -1 WHERE seckill_id = fadeSeckillId AND start_time < fadeKillTime AND end_time > fadeKillTime AND number > 0;
      SELECT ROW_COUNT() INTO insert_count;
      IF (insert_count = 0)  THEN
        ROLLBACK ;
        SET fadeResult = 0;
      ELSEIF (insert_count < 0) THEN
        ROLLBACK ;
        SET fadeResult = -2;
      ELSE
        COMMIT ;
        SET  fadeResult = 1;
      END IF;
    END IF;
  END
$$

DELIMITER ;
SET @fadeResult = -3;
CALL excuteSeckill(8,13813813822,NOW(),@fadeResult);
SELECT @fadeResult;