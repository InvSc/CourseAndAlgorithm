package com.invsc.miaosha.thread;

public class SingletonDemo {
    private volatile static com.invsc.miaosha.thread.SingletonDemo instance = null;

    private SingletonDemo() {
        System.out.println(Thread.currentThread().getName() + "\t 我是构造方法");

    }

    // DCL(Double Check Lock 双端锁机制）
    public static com.invsc.miaosha.thread.SingletonDemo getInstance() {
        if (instance == null) { // 一旦成功初始化以后就不需要每次上锁了
            synchronized (com.invsc.miaosha.thread.SingletonDemo.class) {
//                if (instance == null) {
                    instance = new com.invsc.miaosha.thread.SingletonDemo();
//                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {

//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());

        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                com.invsc.miaosha.thread.SingletonDemo.getInstance();
            }, String.valueOf(i)).start();
        }
    }
}
