package _03_Threaded_Greeting;

public class ThreadedGreeter implements Runnable {
int num;
Thread message;
public ThreadedGreeter(int num) {
	this.num = num;
}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Hello from thread #: "+num);
		if(num<=50) {
			 message = new Thread(()-> new ThreadedGreeter(num=num+1));	
		}
		message.start();
		try {
			message.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
