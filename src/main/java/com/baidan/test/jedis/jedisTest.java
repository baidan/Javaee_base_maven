package com.baidan.test.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

public class jedisTest {

    @Test
    public void test1(){
        Jedis jedis = new Jedis("");  //默认 new Jedis("localhost",6379)
        jedis.set("password", "sadhfjk");
        jedis.close();
    }
}
