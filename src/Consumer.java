import java.util.concurrent.BlockingQueue;

public class Consumer extends Thread
{
    BlockingQueue<Integer> c1;
    int sum = 0;

    public Consumer(BlockingQueue<Integer>s1){this.c1 = s1;}

    @Override
    public void run()
    {
        for(int i = 0; i < c1.size(); i++)
        {
            try
            {
                Thread.sleep(1000);
                int msg = c1.take();
                sum = sum + msg;
                System.out.println("Consumed: " + msg);
            }
            catch (InterruptedException e)
            {
                break;
            }
        }
    }
}
