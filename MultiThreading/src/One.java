import java.util.Scanner;
public class One {
    public static void main(String[] args)
            throws InterruptedException
{
final PC pc = new PC();

// Create a thread object that calls pc.produce()
Thread t1 = new Thread(new Runnable()
{
@Override
public void run()
{
 try
 {
     pc.produce();
 }
 catch(Exception e)
 {
     e.printStackTrace();
 }
}
});

// Create another thread object that calls
// pc.consume()
Thread t2 = new Thread(new Runnable()
{
@Override
public void run()
{
 try
 {
     pc.consume();
 }
 catch(InterruptedException e)
 {
     e.printStackTrace();
 }
}
});
Thread t3 = new Thread(new Runnable()
{
@Override
public void run()
{
 try
 {
     pc.intermediate();
 }
 catch(InterruptedException e)
 {
     e.printStackTrace();
 }
}
});

// Start both threads
t1.start();
t2.start();
t3.start();

// t1 finishes before t2
t1.join();
t2.join();


}
    
    
    public static class PC
    {
    	void produce() throws InterruptedException
    	{
    		synchronized(this){
    		System.out.println("Thread A");
    		wait();
    		System.out.println(" Again Thread A ");
    		notify();
    		}
    	}
    	void consume() throws InterruptedException
    	{
    		synchronized(this){
    		System.out.println("Thread B");
    		notify();
    		wait();
    		System.out.println(" Again Thread B");
    		}
    	}
    	void intermediate() throws InterruptedException
    	{
    	synchronized(this)
    	{
    		System.out.println(" Intermediate thread ");
    		wait();
    	}
    	}
    }
    	
    }

