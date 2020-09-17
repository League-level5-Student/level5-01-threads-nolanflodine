package _04_Thread_Pool;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ThreadPool{
Thread[] threads;
ConcurrentLinkedQueue<Task> taskQue;
public ThreadPool(int totalThreads) {
	threads = new Thread[totalThreads];
	taskQue = new ConcurrentLinkedQueue<Task>();
	for (int i = 0; i < threads.length; i++) {
		threads[i] = new Thread(new Worker(taskQue));
	}
}
public void addTask(Task task) {
	taskQue.add(task);
}
public void Start() {
	for (int i = 0; i < threads.length; i++) {
		threads[i].start();
	}
	for (int i = 0; i < threads.length; i++) {
		try {
			threads[i].join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
}
