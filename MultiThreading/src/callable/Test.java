package callable;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Test implements Callable<Integer>{
int i=0;
	@Override
	public Integer call() throws Exception {
		System.out.println(" thread name "+Thread.currentThread().getName()+" iteration "+i);
		i++;
		return i;
	}
	public static void main(String abc[]){
		try{
			Test obj=new Test();
			FutureTask task=new FutureTask<Integer>(obj);
			FutureTask task1=new FutureTask<Integer>(obj);
			FutureTask task2=new FutureTask<Integer>(obj);
			Thread t=new Thread(task,"first");
			Thread t1=new Thread(task1,"second");
			Thread t2=new Thread(task2,"Third");
			t.start();
			t1.start();
			t1.join();
			t2.start();
			System.out.println(task.get());
		}catch(Exception e){
			
		}
	}

}
