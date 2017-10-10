package atomic;

import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class Test {
static int count=0;
	public static void main(String[] args) throws InterruptedException, IOException {
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
				count++;
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
				count++;
			}
			
		}
		
	});
	t1.start();
	t2.start();
	t1.join();
	t2.join();
	System.out.println(" count is a bit random without atomic "+count);
	}
}
