package com.immortal.immortal4j;

import com.immortal.immortal4j.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * @author shijieming(1026524749@qq.com)
 * @date 2018/3/5 16:40
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;


    @Test
    public void test(){
        stringRedisTemplate.opsForValue().set("aa111","12312");
        Assert.assertEquals(stringRedisTemplate.opsForValue().get("aa111"),"12312");
    }
    @Test
    public void  testobj() throws Exception{
        User user=new User("cccc", "aaaa@126.com", "ccc23243", "aa","ccc123");
        ValueOperations<String, User> operations =  redisTemplate.opsForValue();
        operations.set("test111",user);
        operations.set("test222", user, 1, TimeUnit.MINUTES);
        //Thread.sleep(61000);
        Assert.assertEquals(operations.get("test222").getUserName(), "ccc23243");;

    }
}
