package blockingQueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
	BlockingQueue<Message> queue;

	public Consumer(BlockingQueue<Message> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		Message msg;
		try {
			while (!(msg = queue.take()).getMessage().equalsIgnoreCase("Done")) {
				Thread.sleep(10);
				System.out.println("Consumed " + msg.getMessage());
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
