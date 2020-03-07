package com.hanslaser.blog.leetCode;

/**
 * @author luoju
 */
public class VolatileTest {

    volatile static long vl = 0;

    public static void main(String[] args) throws InterruptedException {

        Thread threadOne = createThread();
        Thread threadTwo = createThread();
        Thread threadThree = createThread();

        threadOne.join();
        threadTwo.join();
        threadThree.join();



        Thread.currentThread().sleep(1000);
        System.out.println(vl);

    }

    private static Thread createThread() {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                vl++;
            }
        });

        thread.start();
        return thread;
    }


}
