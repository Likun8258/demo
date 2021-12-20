package com.example.demo.test;

import com.google.common.collect.Maps;
import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.TimerTask;
import org.redisson.RedissonLock;
import org.redisson.api.RFuture;
import org.redisson.client.codec.LongCodec;
import org.redisson.client.protocol.RedisCommands;
import org.redisson.connection.ConnectionManager;

import java.util.Collections;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TaskTest {


    public static void main(String[] args) {


        Map<String, String> map = Maps.newHashMap();
        map.put("1", "1");
        System.out.println(map.get("1"));


        System.out.println(map.put("1","2"));
        System.out.println(map.put("1","3"));
        System.out.println(map.get("1"));

        System.out.println(map.putIfAbsent("1","44"));
        System.out.println(map.get("1"));


        scheduleExpirationRenewal(1);
    }

    private static void scheduleExpirationRenewal(long  threadId){
        new HashedWheelTimer().newTimeout(new TimerTask() {
            @Override
            public void run(Timeout timeout) throws Exception {
                System.out.println("====开始执行===");

                int aa = new Random().nextInt(10);
                System.out.println(aa);
                if (aa == 5) {
                    System.out.println("=====结束本次循环");
                    return;

                }else {
                    // reschedule itself
                    System.out.println("===再次执行===");
                    scheduleExpirationRenewal(threadId);
                }
            }

        }, 10 * 1000, TimeUnit.MILLISECONDS);

        if (1== 1){
            System.out.println("hahahhaha");
        }
    }

}
