import java.lang.Thread;

class ThreadDemo implements Runnable{
	public void run(){
		for(int i=0; i<5; i++){
			System.out.println(Thread.currentThread().getName()+": "+i);
			try{
				Thread.sleep(500);
			}
			catch(Exception e){
			}
		}	
	}
}

class ThreadRunnable{
	public static void main(String args[]){
		System.out.println("Starting Threads...... ");
		ThreadDemo t1 = new ThreadDemo();
		ThreadDemo t2 = new ThreadDemo();
		ThreadDemo t3 = new ThreadDemo();
		Thread tobj1 = new Thread(t1);
		Thread tobj2 = new Thread(t2);
		Thread tobj3 = new Thread(t3);
		tobj1.start();
		tobj2.start();
		tobj3.start();
		try{
			tobj1.join();
		}
		catch(Exception e){
		}
		try{
			tobj2.join();
		}
		catch(Exception e){
		}
		try{
			tobj3.join();
		}
		catch(Exception e){
		}
		System.out.println("Starting Finished!!");
	}
}