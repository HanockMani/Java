import java.sql.*;
import java.util.*;

class LoginData{
	public static void main(String args[]){
		int flag = 0;
		Connection con;
		Statement st;
		ResultSet rs;
		Scanner s = new Scanner(System.in); 
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_login?characterEncoding=utf8","root","");
			st = con.createStatement();
			String str = "select * from tbl_login";
			rs = st.executeQuery(str);

			System.out.print("Login\n-----\nUsername :");
			String username = s.nextLine();
			System.out.print("Password :");
			String password = s.nextLine();

			while(rs.next()){
				if(rs.getString("uname").equals(username) && rs.getString("upass").equals(password)){
					System.out.println("Logged In!");
					flag = 1;
					break;
				}
			}
			if(flag == 0){	
				System.out.println("Invalid Username or Password!");
			}

		}
		catch(Exception e){
			System.out.println("Error : "+e);
		}
	}
}