package com.invsc.miaosha.thread;


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

        com.invsc.miaosha.thread.User                  z3              = new com.invsc.miaosha.thread.User("z3", 22);
        com.invsc.miaosha.thread.User                  li4             = new com.invsc.miaosha.thread.User("li4", 25);
        AtomicReference<com.invsc.miaosha.thread.User> atomicReference = new AtomicReference<>();
        atomicReference.set(z3);
        System.out.println(atomicReference.compareAndSet(z3, li4) + "\t" + atomicReference.get().toString());
    }
}
