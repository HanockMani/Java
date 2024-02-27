import java.lang.*;
import java.util.*;

class ThreadBank extends Thread {
	static int balance = 5000;
	int type;
	int amount;
	public ThreadBank(int type, int amount){
		this.type = type;
		this.amount = amount;
	}
	public void depositWithdraw(){
		synchronized(ThreadBank.class){
			if(type == 1){
				balance = balance + amount;
				try{
					Thread.sleep(1000);
				}
				catch(Exception e){
					System.out.println("Error: "+e);
				}
			}
			else if(type == 2){
				if(balance-amount >= 0){
					balance = balance - amount;
				}
				else{
					System.out.println("Cannot Proceed with Transaction! Insufficient Balance");
				}
				try{
					Thread.sleep(500);
				}
				catch(Exception e){
					System.out.println("Error: "+e);
				}
			}
		}
		System.out.println("Balance: "+balance);
	}
	public void run(){
		depositWithdraw();
	}
}

class ThreadSync{
	public static void main(String args[]){
		int i;
		int type[] = new int[3];
		int amount[] = new int[3];
		ThreadBank tb[] = new ThreadBank[3];
		Scanner s = new Scanner(System.in);
		for(i=0;i<3;i++){
			System.out.print("Bank\n----\n1. Deposit\n2. Withdraw\nEnter choice:");
			type[i] = s.nextInt();
			System.out.print("Enter amount: ");
			amount[i] = s.nextInt();
		}
		for(i=0;i<3;i++){
			tb[i] = new ThreadBank(type[i], amount[i]);
			tb[i].start();
		}	
	}
}	