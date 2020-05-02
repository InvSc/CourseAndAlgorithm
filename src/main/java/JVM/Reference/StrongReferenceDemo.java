<<<<<<< HEAD:src/main/java/JVM/Reference/StrongReferenceDemo.java
package main.java.JVM.Reference;

public class StrongReferenceDemo {
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = o1;
        o1 = null;
        System.gc();
        System.out.println(o1);
        System.out.println(o2);
    }
}
=======
package main.java.JVM.Reference;

public class StrongReferenceDemo {
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = o1;
        o1 = null;
        System.gc();
        System.out.println(o1);
        System.out.println(o2);
    }
}
>>>>>>> 60c04ceb61109a267521c8ff38071a8061e1ad8a:src/main/java/JVM/Reference/StrongReferenceDemo.java
