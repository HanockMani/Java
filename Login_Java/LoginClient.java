import java.io.*;
import java.net.*;

class LoginClient{
	public static void main(String args[]){
		try{
			Socket cs = new Socket("localhost",1234);
			DataInputStream sin = new DataInputStream(cs.getInputStream());
			DataInputStream din = new DataInputStream(System.in);
			DataOutputStream sout = new DataOutputStream(cs.getOutputStream());
			System.out.println(sin.readUTF());
			sout.writeUTF(din.readLine());
			System.out.println(sin.readUTF());
			sout.writeUTF(din.readLine());
			System.out.println(sin.readUTF());
			System.out.println("Press any key to exit!");
			System.in.read();
		}
		catch(Exception e){
			System.out.println("Error: "+e);
		}
	}
}		
