<<<<<<< HEAD:src/main/java/thread/CASDemo.java
package main.java.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * 1 CAS是什么 ===> Compare And Swap
 */
public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);

        System.out.println(atomicInteger.compareAndSet(5, 2019) + "\t current data: " + atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 1024) + "\t current data: " + atomicInteger.get());
        atomicInteger.getAndIncrement();
    }
}
=======
package main.java.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * 1 CAS是什么 ===> Compare And Swap
 */
public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);

        System.out.println(atomicInteger.compareAndSet(5, 2019) + "\t current data: " + atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 1024) + "\t current data: " + atomicInteger.get());
        atomicInteger.getAndIncrement();
    }
}
>>>>>>> 60c04ceb61109a267521c8ff38071a8061e1ad8a:src/main/java/thread/CASDemo.java
