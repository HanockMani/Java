import java.lang.Thread;

class OddThread extends Thread{
	public void run(){
		for(int i=1;i<100;i=i+2){
			System.out.println("Odd: "+i);
			try{
				Thread.sleep(100);
			}
			catch(Exception e){
			}
		}
	}
}

class EvenThread extends Thread{
	public void run(){
		for(int i=0;i<100;i=i+2){
			System.out.println("Even: "+i);
			try{
				Thread.sleep(100);
			}
			catch(Exception e){
			}
		}
	}
}

class Odd_Even_Thread{
	public static void main(String args[]){
		EvenThread et = new EvenThread();
		OddThread ot = new OddThread();
		System.out.println("Threads Execution Starting......");
		ot.start();
		et.start();
		try{
			ot.join();
		}
		catch(Exception e){
		}
		try{
			et.join();
		}
		catch(Exception e){
		}
		System.out.println("Threads Execution Completed!!");
	}
}