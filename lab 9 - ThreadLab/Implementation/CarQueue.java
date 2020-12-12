import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
public class CarQueue implements Runnable{
	Queue<Integer> carQueue = new LinkedList<>();
	Random rand = new Random();
	
	CarQueue() {
		carQueue.add(0);
		carQueue.add(3);
		carQueue.add(2);
		carQueue.add(1);
		carQueue.add(0);
		carQueue.add(2);
	}

	
	public void addToQueue() {
		carQueue.add(rand.nextInt(4));
	}
	
	public int deleteQueue() {
		return carQueue.poll();
	}

	@Override
	public void run() {
		
		try {
			addToQueue();
			Thread.sleep(1000);
			
		} catch (InterruptedException e) {
			// 
		}
	}
}
