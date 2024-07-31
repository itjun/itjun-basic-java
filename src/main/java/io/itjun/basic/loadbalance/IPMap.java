package io.itjun.basic.loadbalance;

import java.util.HashMap;

public class IPMap {

    // 待路由的IP列表，Key代表IP，Value代表该Ip的权重
    public static HashMap<String, Integer> items = new HashMap<String, Integer>();

    static {
        items.put("192.168.1.100", 1);
        items.put("192.168.1.101", 1);

        // 权重为4
        items.put("192.168.1.102", 4);
        items.put("192.168.1.103", 1);
        items.put("192.168.1.104", 1);

        // 权重为3
        items.put("192.168.1.105", 3);
        items.put("192.168.1.106", 1);

        // 权重为2
        items.put("192.168.1.107", 2);
        items.put("192.168.1.108", 1);
        items.put("192.168.1.109", 1);
        items.put("192.168.1.110", 1);
    }
}