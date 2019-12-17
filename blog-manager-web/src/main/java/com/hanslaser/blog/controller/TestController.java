package com.hanslaser.blog.controller;

public class TestController {

    private Object obj = new Object();

    synchronized public  void syncOne() {
        System.out.println("现在进来syncOne...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public  void syncTwo() {
        System.out.println("现在进来syncTwo...");
    }

    /**
     * 当sync修饰在普通方法上时,锁是当前对象
     * 当sync修饰在静态方法时,锁是当前字节码文件
     *
     * @param args
     */
    public static void main(String[] args) {
        TestController t1 = new TestController();
        TestController t2 = new TestController();

        new Thread(() -> {
            t1.syncOne();
//            TestController.syncOne();

        }).start();
        new Thread(() -> {
            t2.syncTwo();
//            TestController.syncTwo();
        }).start();


    }

}
