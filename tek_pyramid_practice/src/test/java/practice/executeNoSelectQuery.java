package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class executeNoSelectQuery {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Driver drivereref=new Driver();
		
		
		
		DriverManager.registerDriver(drivereref);
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/EMPLOYEE","root","root");
		Statement statement=con.createStatement();
		int result=statement.executeUpdate(" INSERT INTO EMPDETAILS (id,first_name,last_name,email)VALUES('5','dramya','panigrahi','rdamya@gmail.com');");
		System.out.println(result);
		con.close();
		System.out.println("execution done sucessfully");
		
	}

}
