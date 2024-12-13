package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Sample_jdbc_con {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		
		
		//Step1: load/register the database driver
		Driver drivers=new Driver();
		DriverManager.registerDriver(drivers);
		//Step2: connect to database
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/EMPLOYEE","root","root");
		
		
		//step3:create sql statement
		
		Statement stateobj=con.createStatement();
		
		//Step4:execute select quary and get result
		ResultSet resultset=stateobj.executeQuery("SELECT * FROM EMPDETAILS;");
		resultset.next();
		String data=resultset.getString(1);
		System.out.println(data);
		//get multiple data
		
		while(resultset.next())
		{
		System.out.println(resultset.getString(1)+"\t"+resultset.getString(2)+"\t"+resultset.getString(3)+"\t"+resultset.getString(4));	
		
		}
		
		//step4:close the connection
		
		con.close();
		System.out.println("execution sucessfull");

	}

}
