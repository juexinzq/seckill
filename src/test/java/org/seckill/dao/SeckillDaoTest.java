package org.seckill.dao;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author 苏雄伟
 * @description:
 * @create 2017-06-11 13:19
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/applicationContext.xml"})
//@ActiveProfiles("mysql")
public class SeckillDaoTest {
    @Autowired
    private SeckillDao seckillDao;
    @Test
    public void testQueryById(){
        long id=1000;
        Seckill seckill=seckillDao.queryById(id);
        System.out.println(seckill.getName());
        System.out.println(id);
    }
    @Test
    public void testQueryAll(){
        /**
         * Caused by: org.apache.ibatis.binding.BindingException:
         * Parameter 'offset' not found. Available parameters are [0, 1, param1, param2]
         * java没有保存形参的记录，queryAll（arg0,arg1）
         * 用@param解决
         */
        List<Seckill> seckillList=seckillDao.queryAll(0,100);
        for (Seckill seckill:seckillList) {
            System.out.println(seckill);
        }
    }
    @Test
    public void testReduceMumber(){
        Date date=new Date();
        int updateCount=seckillDao.reduceNumber(1000L,date);
        System.out.println(updateCount);
    }



}