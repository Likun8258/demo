package com.example.demo.test;

import com.google.common.collect.Sets;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Set;

public class RedisTest {

    public static void main(String[] args) {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(1);
        poolConfig.setMaxIdle(1);
        poolConfig.setMaxWaitMillis(1000);

        Set<HostAndPort> nodes = Sets.newHashSet();
        nodes.add(new HostAndPort("47.99.185.225", 8001));
        nodes.add(new HostAndPort("47.99.185.225", 8002));
        nodes.add(new HostAndPort("47.99.185.225", 8003));
        nodes.add(new HostAndPort("47.99.185.225", 8004));
        nodes.add(new HostAndPort("47.99.185.225", 8005));
        nodes.add(new HostAndPort("47.99.185.225", 8006));

        System.out.println("开始连接集群");
        JedisCluster cluster = new JedisCluster(nodes,1000,1000,100, "123456",poolConfig);
        System.out.println("集群已连接");
        cluster.set("asdasd", "1234");
        System.out.println(cluster.set("asdasd", "1234"));
        System.out.println(cluster.get("asdasd"));

        System.out.println(cluster.getClusterNodes());

        cluster.set("aa", "hahah");
        System.out.println("hahahha");

        cluster.set("age", "18");
        System.out.println(cluster.get("age"));
        System.out.println("========");

        String name = cluster.get("name");
        System.out.println(name);

        System.out.println("=========");

        cluster.set("age", "18");
        System.out.println(cluster.get("age"));


    }

}
