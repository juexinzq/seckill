package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessKilled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author 苏雄伟
 * @description:
 * @create 2017-06-12 14:00
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/applicationContext.xml"})
public class SuccessKilledDaoTest {
    @Resource SuccessKilledDao successKilledDao;
    @Test
    public void TestInsertSuccessKilled(){
        long id=1000L;
        Long phone=13502181181L;
        int count=successKilledDao.insertSuccessKilled(id,phone);
        System.out.println(count);
    }

    @Test
    public void TestQueryByIdWithSeckill(){
        long id=1000L;
        Long phone=13502181181L;
        SuccessKilled successKilled=successKilledDao.queryByIdWithSeckill(id,phone);
        System.out.println(successKilled);
        System.out.println(successKilled.getSecKill());
    }
}