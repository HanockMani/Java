import java.io.*;
import java.net.*;
import java.sql.*;

class DataBaseCon{
	public static String loginCheck(String username, String password){
		Connection con;
		Statement st;
		ResultSet rs;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_login?characterEncoding=utf8","root","");
			st = con.createStatement();
			rs = st.executeQuery("select * from tbl_login");

			while(rs.next()){
				if(rs.getString("uname").equals(username) && rs.getString("upass").equals(password)){
					System.out.println("Client login Successful!");	
					return "Logged In!";
				}
			}		
		}
		catch(Exception e){
			System.out.println("Error: "+e);
		}
		System.out.println("Client login Failed!");	
		return "Invalid Username or Password!";
	}
}

class LoginServer{
	public static void main(String args[]){
		try{
			ServerSocket ss = new ServerSocket(1234);
			System.out.println("Waiting for Client.....");
			Socket cs = ss.accept();
			System.out.println("Connected to Client!");
			DataInputStream sin = new DataInputStream(cs.getInputStream());
			DataOutputStream sout = new DataOutputStream(cs.getOutputStream());
			System.out.println("Waiting for Username and Password.....");
			sout.writeUTF("Login\n-----\nUsername :");
			String username = sin.readUTF();
			sout.writeUTF("Password :");
			String password = sin.readUTF();
			System.out.println("Received Username and Password!");
			String checkString = DataBaseCon.loginCheck(username,password);
			sout.writeUTF(checkString);
			System.out.println("Press any key to exit!");
			System.in.read();
		}
		catch(Exception e){
			System.out.println("Error: "+e);
		}
	}
}		
