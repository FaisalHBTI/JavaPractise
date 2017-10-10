import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class TPools {

	public static void main(String[] args) {
		Runnable r1=new Task("One");
		Runnable r2=new Task("Two");
		Runnable r3=new Task("Three");
		Runnable r4=new Task("Four");
		Runnable r5=new Task("Five");
		ExecutorService pool=Executors.newFixedThreadPool(3);
		pool.execute(r1);
		pool.execute(r2);
		pool.execute(r3);
		pool.execute(r4);
		pool.execute(r5);
		pool.shutdown();
	}

}
