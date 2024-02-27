import java.io.*;
class Shift{
	public static void main(String args[]){
		int a = 10;
		int b = a>>4;
		int c = b<<4;
		int d = a>>>4;
		System.out.println("Initial value(a) = "+a+"\nRight Shift(4 bits) ="+b+"\nLeft Shift(4 bits) ="+c+"\nUnsigned Right Shift(4 bits) ="+d);
	}
}
		