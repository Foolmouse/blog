package com.hanslaser.blog.leetCode;

/**
 * @author luoju
 * 从jit汇编代码层面观察volatile对于指令重排的影响
 */
public class SingleInstance {

    private static SingleInstance instance;

    SingleInstance getInstance() {

        if (null == instance) {
            synchronized (SingleInstance.class) {
                if (null == instance) {
                    instance = new SingleInstance();
                }
            }
        }
        return instance;
    }

}
