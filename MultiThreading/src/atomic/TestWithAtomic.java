package atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class TestWithAtomic {
static  AtomicInteger count=new AtomicInteger();
	public static void main(String[] args) throws InterruptedException {
		count.set(0);
	Thread t1=new Thread(new Runnable(){

		@Override
		public void run() {
			for(int i=1;i<=10;i++){
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				count.incrementAndGet();
			}
			
		}
		
	});
	Thread t2=new Thread(new Runnable(){

		@Override
		public void run() {
			for(int i=1;i<=10;i++){
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				count.incrementAndGet();
			}
			
		}
		
	});
	t1.start();
	t2.start();
	t1.join();
	t2.join();
	System.out.println(" count is exact with atomic "+count);

	}

}
