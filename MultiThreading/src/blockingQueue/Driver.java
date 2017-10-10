package blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Driver {

	public static void main(String[] args) {
	BlockingQueue<Message> queue=new  ArrayBlockingQueue<Message>(4);
	Producer producer =new Producer(queue);
	Consumer consumer=new Consumer(queue);
	new Thread(producer).start();
	new Thread(consumer).start();
	System.out.flush();
	}

}
