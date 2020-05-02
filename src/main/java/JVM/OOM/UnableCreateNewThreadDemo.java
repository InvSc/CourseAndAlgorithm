package main.java.JVM.OOM;

/**
 *
 * 解决办法
 * 1.想办法降纸你应用程序创建线程的数量，分析应用是否真的需要创建这么多线程，如果不是，改代码将线程数降到最纸
 * 2.对于有的应用，确实需要创建很多线程,远超过linux系统的默认1024个线程的限制，可以通过修改linux服务器配置，扩大linux默认限制
 */
public class UnableCreateNewThreadDemo {
    public static void main(String[] args) {

        for (int i = 0; ; i++) {
            System.out.println("i=" + i);
            new Thread(() -> {
                try {
                    Thread.sleep(Integer.MAX_VALUE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "" + i).start();
        }
    }
    /**
     *  2  Intel(R) Xeon(R) Platinum 8269CY CPU @ 2.50GHz
     * 运行于阿里云服务器后：
     * i=10214
     * Exception in main.java.thread "main" java.lang.OutOfMemoryError: unable to create new native main.java.thread
     *         at java.lang.Thread.start0(Native Method)
     *         at java.lang.Thread.start(Thread.java:717)
     *         at UnableCreateNewThreadDemo.main(UnableCreateNewThreadDemo.java:12)
     * 并且症状如下
     * - 无法Ctrl C强退
     * - 无法在其他位置登录root或所在的非root账户
     * - VNC模式远程连接可登录root用户，但键入命令后显示：
     *      -bash: fork: retry: Resource temporarily unavailable.
     *   强行关闭之前的terminal解决
     */
}
