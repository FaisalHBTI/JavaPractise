package callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class TestExecutorService {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		 List<Future<Integer>> list=new ArrayList<Future<Integer>>(3);
		 ExecutorService ec =Executors.newFixedThreadPool(2);
		 list.add(ec.submit(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				Thread.sleep(300);
				return 1;
			}
		}));
		 list.add(ec.submit(new Callable<Integer>() {

				@Override
				public Integer call() throws Exception {
					
					return 2;
				}
			}));
		 list.add(ec.submit(new Callable<Integer>() {

				@Override
				public Integer call() throws Exception {
					
					return 3;
				}
			}));
		 ec.shutdown();
		 for(Future<Integer> future:list)
			 System.out.println(future.get());
	}

}
