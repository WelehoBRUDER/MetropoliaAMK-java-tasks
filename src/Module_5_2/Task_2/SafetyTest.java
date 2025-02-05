package Module_5_2.Task_2;

import java.util.concurrent.CountDownLatch;

public class SafetyTest {
    public static void main(String[] args) throws InterruptedException {
        final int THREADS = 10;
        final int ELEMENTS = 10;
        CountDownLatch latch = new CountDownLatch(THREADS);
        // Test the ThreadSafeList class
        ThreadSafeList<Integer> list = new ThreadSafeList<>();
        // Create 10 threads that add and remove elements from the list, while also querying the list size
        for (int i = 0; i < THREADS; i++) {
            new Thread(() -> {
                for (int j = 0; j < ELEMENTS; j++) {
                    list.add(j);
                    System.out.println("Size: " + list.size());
                    list.remove(0);
                }
                latch.countDown();
            }).start();
        }

        latch.await();
        // Final result should be a size of 0, as each element that was added was also removed
        System.out.println("Final size: " + list.size());
    }
}
