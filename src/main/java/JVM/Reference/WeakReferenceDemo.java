<<<<<<< HEAD:src/main/java/JVM/Reference/WeakReferenceDemo.java
package main.java.JVM.Reference;

import java.lang.ref.WeakReference;

public class WeakReferenceDemo {
    public static void main(String[] args) {
        Object o1 = new Object();
        WeakReference<Object> ref = new WeakReference<>(o1);

        System.out.println(o1);
        System.out.println(ref.get());

        o1 = null;
        System.out.println("====================");

        System.gc(); // 一旦gc 就被回收

        System.out.println(o1);
        System.out.println(ref.get());
    }
}
=======
package main.java.JVM.Reference;

import java.lang.ref.WeakReference;

public class WeakReferenceDemo {
    public static void main(String[] args) {
        Object o1 = new Object();
        WeakReference<Object> ref = new WeakReference<>(o1);

        System.out.println(o1);
        System.out.println(ref.get());

        o1 = null;
        System.out.println("====================");

        System.gc(); // 一旦gc 就被回收

        System.out.println(o1);
        System.out.println(ref.get());
    }
}
>>>>>>> 60c04ceb61109a267521c8ff38071a8061e1ad8a:src/main/java/JVM/Reference/WeakReferenceDemo.java
