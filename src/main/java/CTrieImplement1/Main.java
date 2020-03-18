package CTrieImplement1;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public final static int THREAD_POOL_SIZE = 10;
    public static Map<String, Integer> hashTableObject = null;
    public static Map<String, Integer> synchronizedMapObject = null;
    public static Map<String, Integer> concurrentHashMapObject = null;
    public static Map<String, Integer> trieMap = null;
    public static void Test(final Map<String, Integer> Threads) throws InterruptedException {
        System.out.println("Test started for: " + Threads.getClass());
        long averageTime = 0;
//        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            ExecutorService exServer = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
            for (int j = 0; j < THREAD_POOL_SIZE; j++) {
                exServer.execute(new Runnable() {
                    @SuppressWarnings("unused")
                    @Override
                    public void run() {
                        for (int i = 0; i < 1000000; i++) {
                            Integer crunchifyRandomNumber = (int) Math.ceil(Math.random() * 100000);
                            Integer crunchifyValue = Threads.get(String.valueOf(crunchifyRandomNumber));
                            Threads.put(String.valueOf(crunchifyRandomNumber), crunchifyRandomNumber);
                        }
                    }
                });
            }
            exServer.shutdown();
            exServer.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
            long entTime = System.nanoTime();
            long totalTime = (entTime - startTime) / 1000000L;
            averageTime += totalTime;
            System.out.println("1000000 entried added/retrieved in " + totalTime + " ms");
//        }
//        System.out.println("For " + Threads.getClass() + " the average time is " + averageTime / 5 + " ms\n");
    }
    public static void main(String[] args) throws InterruptedException {
        // Test with Hashtable Object
        hashTableObject = new Hashtable<String, Integer>();
        Test(hashTableObject);

        // Test with synchronizedMap Object
        synchronizedMapObject = Collections.synchronizedMap(new HashMap<String, Integer>());
        Test(synchronizedMapObject);

        // Test with ConcurrentHashMap Object
        concurrentHashMapObject = new ConcurrentHashMap<String, Integer>();
        Test(concurrentHashMapObject);

        trieMap = new TrieMap1<String, Integer>();
        Test(trieMap);
    }
}

