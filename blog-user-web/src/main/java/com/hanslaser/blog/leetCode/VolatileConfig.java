package com.hanslaser.blog.leetCode;

import java.util.Properties;

/**
 * @author luoju description:volatile防止指令重排在实际生产中的运用
 */
public class VolatileConfig {
    //必须使用volatile修饰
    private static volatile boolean flag = false;

    void doSomeThing() {

        //以下代码在线程A执行
        Properties properties = new Properties();
        properties.put("config_1", "xxx");
        properties.put("config_2", "xxx");

        //初始化配置
        initProperties(properties);
        //标记初始化完成
        flag = true;


        //以下代码在线程B执行
        while (flag) {
            System.out.println(properties.get("config_1"));
        }
    }

    private static void initProperties(Properties properties) {
        //...
    }
}




