import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo{
    static class ReentrantLockDemo {
        private static final Container     container  = new Container();
        private static final AtomicInteger proFailure = new AtomicInteger(0);
        private static final AtomicInteger conFailure = new AtomicInteger(0);
        private static final Lock          lock       = new ReentrantLock();
        private static final Condition     empty      = lock.newCondition();
        private static final Condition     full       = lock.newCondition();


        public static void main(String[] args) throws InterruptedException {
            for (int i = 1; i < 9; i++) {
                if (i % 4 == 0) {
                    new Thread(() -> {
                        try {
                            for (int j = 0; j < 300; j++) {
                                consume();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }, "consumer" + i).start();
                } else {
                    new Thread(() -> {
                        try {
                            for (int j = 0; j < 100; j++) {
                                produce();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }, "producer" + i).start();
                }
            }

            Thread.sleep(1000);
            System.out.println("生产失败：" + proFailure.get());
            System.out.println("消费失败：" + conFailure.get());
        }

        public static void produce() throws InterruptedException {
            lock.lock();
            if (container.isFull()) {
                proFailure.incrementAndGet();
                empty.signal();
                full.await();
            }
            System.out.println(Thread.currentThread().getName() + " " + container.push());
            lock.unlock();
        }

        public static void consume() throws InterruptedException {
            lock.lock();
            if (container.isEmpty()) {
                conFailure.incrementAndGet();
                full.signal();
                empty.await();
            }
            System.out.println(Thread.currentThread().getName() + " " + container.pop());
            lock.unlock();
        }

    }

    static class Container {
        static int cap = 8;
        static volatile AtomicInteger cur = new AtomicInteger(0);


        public boolean isFull() {
            return cur.get() == cap;
        }

        public boolean isEmpty() {
            return cur.get() == 0;
        }

        public int pop() {
            if (isEmpty()) throw new ArrayIndexOutOfBoundsException();
            return cur.getAndDecrement();
        }

        public int push() {
            if (isFull()) throw new ArrayIndexOutOfBoundsException();
            return cur.incrementAndGet();
        }
    }
}
