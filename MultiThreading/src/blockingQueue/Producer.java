package blockingQueue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
	BlockingQueue<Message> queue;

	public Producer(BlockingQueue<Message> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 15; i++)
			try {
				Thread.sleep(i);
				System.out.println("Produced "+i);
				queue.put(new Message(" " + i));
				System.out.println("Stock available " + queue.size());	
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		try {
			Thread.sleep(12);	
			queue.put(new Message("Done"));
			System.out.println("last item produced");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
