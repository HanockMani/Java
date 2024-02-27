import java.lang.Thread;
import java.util.Random;

class Thread_Random extends Thread{
	int rand_num;
	Thread_Odd to;
	Thread_Even te;
	public void run(){
		Random r = new Random();
		for(int i=0; i<5; i++){
			rand_num = r.nextInt(20);
			System.out.println("Number: "+rand_num);
			if(rand_num%2==0){
				te = new Thread_Even(rand_num);
				te.start();
			}
			else{
				to = new Thread_Odd(rand_num);
				to.start();
			}
			try{
				Thread.sleep(1000);
			}
			catch(Exception e){
			}
		}
	}
}

class Thread_Even extends Thread{
	int num;
	public Thread_Even(int num){
		this.num = num;
	}
	public void run(){
		System.out.println("The Square of the number is "+num*num);
	}
}

class Thread_Odd extends Thread{
	int num;
	public Thread_Odd(int num){
		this.num = num;
	}
	public void run(){
		System.out.println("The Cube of the number is "+num*num*num);
	}
}

class Thread_Square_Cube{
	public static void main(String args[]){
		Thread_Random t = new Thread_Random();
		t.start();
	}
}