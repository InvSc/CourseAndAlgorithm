<<<<<<< HEAD:src/main/java/JVM/OOM/GCOverheadDemo.java
package main.java.JVM.OOM;

import java.util.ArrayList;
import java.util.List;

/**
 * JVM参数配置
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
 * GC回收时间过长的会抛出 outOfMemoryError.过长的定义是，超过98%的时间用来做GC并且回收了不到2%的堆内存
 * 连续多次GC都只回收了不到2%的端情况下才会抛出。假如不抛出 GC overhead Limit错误会发生什么情况呢？
 * 那就是GC清理的这么点内存很快会厚次填满，迫使GC再次执行，这样形成恶性循环
 * CPU化用率一直是100%，而GC没有任何成果
 */
public class GCOverheadDemo {
    public static void main(String[] args) {
        int i = 0;
        List<String> list = new ArrayList<>();
        try {
            while (true) {
                list.add(String.valueOf(++i).intern());
            }
        } catch (Throwable e) {
            System.out.println(i); // java.lang.OutOfMemoryError: GC overhead limit exceeded
            e.printStackTrace();
        }
        return;
    }
}
=======
package main.java.JVM.OOM;

import java.util.ArrayList;
import java.util.List;

/**
 * JVM参数配置
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
 * GC回收时间过长的会抛出 outOfMemoryError.过长的定义是，超过98%的时间用来做GC并且回收了不到2%的堆内存
 * 连续多次GC都只回收了不到2%的端情况下才会抛出。假如不抛出 GC overhead Limit错误会发生什么情况呢？
 * 那就是GC清理的这么点内存很快会厚次填满，迫使GC再次执行，这样形成恶性循环
 * CPU化用率一直是100%，而GC没有任何成果
 */
public class GCOverheadDemo {
    public static void main(String[] args) {
        int i = 0;
        List<String> list = new ArrayList<>();
        try {
            while (true) {
                list.add(String.valueOf(++i).intern());
            }
        } catch (Throwable e) {
            System.out.println(i); // java.lang.OutOfMemoryError: GC overhead limit exceeded
            e.printStackTrace();
        }
        return;
    }
}
>>>>>>> 60c04ceb61109a267521c8ff38071a8061e1ad8a:src/main/java/JVM/OOM/GCOverheadDemo.java
