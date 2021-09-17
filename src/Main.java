import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {



    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> s1 = new ArrayBlockingQueue<>(11);
        BlockingQueue<Integer> c1 = new ArrayBlockingQueue<>(11);
        s1.add(4);
        s1.add(5);
        s1.add(8);
        s1.add(12);
        s1.add(21);
        s1.add(22);
        s1.add(34);
        s1.add(35);
        s1.add(36);
        s1.add(37);
        s1.add(42);

        Producer p = new Producer(s1,c1);
        Consumer c = new Consumer(c1);

        Thread p1 = new Thread(p);
        Thread p2 = new Thread(p);
        Thread p3 = new Thread(p);
        Thread p4 = new Thread(p);

        Thread c2 = new Thread(c);

            p1.start();
            p1.join();

            p2.start();
            p2.join();

            p3.start();
            p3.join();

            p4.start();
            p4.join();

            c2.start();
            c2.join();

        System.out.println("Sum = " + c.sum);
        System.out.println("Done");
    }

}
