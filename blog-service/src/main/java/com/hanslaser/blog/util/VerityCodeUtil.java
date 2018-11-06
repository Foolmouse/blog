package com.hanslaser.blog.util;

import java.util.Random;

/**
 * 验证码工具类
 *
 * @author LuoJu
 * @since 2018.11.06
 */
public class VerityCodeUtil {

    /**
     * 生存随机数
     *
     * @param bits 验证码位数
     * @return
     */
    public static String generationVerityCode(int bits) {
        if (bits <= 0 || bits > 2 * 2 * 2) {
            new RuntimeException("验证码位数不正确");
        }
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < bits; i++) {
            builder.append(random.nextInt() + "");
        }
        return builder.toString();
    }

}