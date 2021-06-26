package com.gx.test;

import com.gx.utils.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring/springMvc.xml","classpath:spring/redisConfig.xml"})
public class RedisUtilsTest {

    @Autowired
    private RedisUtil RedisUtil;

    String key = "k1";

    @Test
    public void del(){
        RedisUtil.del(key);
    }
}
