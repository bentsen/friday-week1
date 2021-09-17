import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Producer extends Thread
{

    BlockingQueue<Integer> s1;
    BlockingQueue<Integer> c1;

    public Producer(BlockingQueue<Integer> s1,BlockingQueue<Integer> c1) {this.s1 = s1; this.c1 = c1;}


    @Override
    public synchronized void run()
    {
        System.out.println("---" + Thread.currentThread().getName() + "---");
        Fibonacci fibonacci = new Fibonacci();

        for(int i = 0; i < s1.size(); i++)
        {
            try
            {
               int produced = fibonacci.fib(s1.take());
               System.out.println(produced);
               c1.add(produced);
               Thread.sleep(500);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
