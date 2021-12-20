package com.example.demo.test;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.UUID;

public class RedisTest1 {


    public static void main(String[] args) throws InterruptedException {
        Config config = new Config();
        config.useClusterServers().setPassword("123456")
                .addNodeAddress("redis://47.99.185.225:8001")
                .addNodeAddress("redis://47.99.185.225:8002")
                .addNodeAddress("redis://47.99.185.225:8003")
                .addNodeAddress("redis://47.99.185.225:8004")
                .addNodeAddress("redis://47.99.185.225:8005")
                .addNodeAddress("redis://47.99.185.225:8006");

        RedissonClient redisson = Redisson.create(config);

        redisson.getConfig();

        RMap<Object, Object> llk = redisson.getMap("llk");
        llk.put("haha","haha");

        System.out.println(llk);

        RMap<Object, Object> tt = redisson.getMap("llk");
        System.out.println(tt.get("haha"));

        System.out.println("---------------------------------------");

        testRedissonSimpleLock(redisson);

    }

    private static void testRedissonSimpleLock(RedissonClient redisson) throws InterruptedException {
        //1.获取key为"angKey"的锁对象
        RLock lock = redisson.getLock("anyLock");

        //2.1加锁
        lock.lock();

        Thread.sleep(10 * 1000);

        //3.释放锁
        lock.unlock();


    }

}
