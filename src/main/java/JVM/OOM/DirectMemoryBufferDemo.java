package JVM.OOM;

import java.nio.ByteBuffer;

/**
 * 配置参数：
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
 * 故障现象
 * Exception in main.java.thread "main"java.lang.OutOfMemory Error：Direct buffer memory
 * 导致原因
 * 写NIO程序经常使用 Byte Buffer来读或者写入数据，这是一种基于通道(Channel)与缓冲区(Buffer)的IO方式,
 * 它可以使用 Native函数库直接分配堆外内存，然后过一个存在Java里面的 DirectByte Buffer对象作为这内存的引用进行操作
 * 这样能在一些场景中显提高性能，因为避免了在Java堆和 Native堆中来回复制数据。
 * ByteBuffer.allocate(capability)第一种方式是分配JVM堆内存，属于GC管辖范围，由于需要拷贝所以速度相对较慢
 * ByteBuffer.allocateDirect(capability)第一种方式是分配S本地内存，不属于6C曾接范国，由于不需要内存烤贝所纵速度相对较快
 * 但如不断分配本地内存，堆内存很少使用，那么JVM就不需要执行GC， DirectByteBuffer对象们就不会被回收，
 * 这时候内存充足，但本地内存可能已经使用光了，再次尝试分配本地内存就会出现 OutOfMemoryError，那程序就直接崩溃了
 */
public class DirectMemoryBufferDemo {
    public static void main(String[] args) {
        System.out.println("配置的maxDirectMemory：" + sun.misc.VM.maxDirectMemory());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace(); // java.lang.OutOfMemoryError: Direct buffer memory
        }
        ByteBuffer buffer = ByteBuffer.allocateDirect(6 * 1024 * 2014);
    }
}
