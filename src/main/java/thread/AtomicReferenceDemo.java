<<<<<<< HEAD:src/main/java/thread/AtomicReferenceDemo.java
package thread;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicReference;

@Getter
@ToString
@AllArgsConstructor
class User {
    String userName;
    int    age;
}

public class AtomicReferenceDemo {
    public static void main(String[] args) {

        User                  z3              = new User("z3", 22);
        User                  li4             = new User("li4", 25);
        AtomicReference<User> atomicReference = new AtomicReference<>();
        atomicReference.set(z3);
        System.out.println(atomicReference.compareAndSet(z3, li4) + "\t" + atomicReference.get().toString());
    }
}
=======
package thread;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicReference;

@Getter
@ToString
@AllArgsConstructor
class User {
    String userName;
    int    age;
}

public class AtomicReferenceDemo {
    public static void main(String[] args) {

        User                  z3              = new User("z3", 22);
        User                  li4             = new User("li4", 25);
        AtomicReference<User> atomicReference = new AtomicReference<>();
        atomicReference.set(z3);
        System.out.println(atomicReference.compareAndSet(z3, li4) + "\t" + atomicReference.get().toString());
    }
}
>>>>>>> 60c04ceb61109a267521c8ff38071a8061e1ad8a:src/main/java/thread/AtomicReferenceDemo.java
