package JVM.OOM;

import java.util.*;

public class JavaHeapSpaceDemo {
    static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true) {
            list.add(new OOMObject());
        }
    }
    static void func() {
        String       str  = "windows";
        while (true) {

            /**
             * Math.random() 方法生成[0, 1)范围内的double类型随机数；
             * Random类中的nextXxxx系列方法生成0－n的随机数；
             * Math.random() 线程安全
             */
            /**
             * The following is probably equals to
             * str = new StringBuilder().append(str).append("x").toString();
             * so it is generated in heap instead of stack.
             */

            str += str + new Random().nextInt(1111111) + new Random().nextInt(2222222);
            /**
             * 存在于.class文件中的常量池，在运行期被JVM装载，并且可以扩充。
             * String的intern()方法就是扩充常量池的一个方法；当一个String实例str调用
             * intern()方法时，Java查找常量池中是否有相同Unicode的字符串常量，如果有，
             * 则返回其的引用，如果没有，则在常量池中增加一个Unicode等于str的字符串并返回它的引用
             */
            str.intern();
        }
        // Exception in main.java.thread "main" java.lang.OutOfMemoryError: Java heap space
    }
}
