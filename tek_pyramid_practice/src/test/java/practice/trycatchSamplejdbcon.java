package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class trycatchSamplejdbcon {
	
	@Test
	public void jdbcconnectionprogrm() throws SQLException
	{
		String expempname="debasnata";
		boolean flag=false;
		Connection con=null;
		try {

		//Step1: load/register the database driver
		Driver drivers=new Driver();
		DriverManager.registerDriver(drivers);
		//Step2: connect to database
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/EMPLOYEE","root","root");
		
		
		//step3:create sql statement
		
		Statement stateobj=con.createStatement();
		
		//Step4:execute select quary and get result
		ResultSet resultset=stateobj.executeQuery("SELECT * FROM EMPDETAILS;");
		resultset.next();
		
		//System.out.println(empdetailsof1st);
		
		//get multiple data
		
		while(resultset.next())
		{
			String empdetailsof1st=resultset.getString(1);
			if(expempname.equals(empdetailsof1st))
			{
				flag=true;
		System.out.println(resultset.getString(1)+"is avialable==pass");	
		
		}
			
		}
		if(flag==false) {
				
			System.out.println(expempname+"the empdetails is not avialabele");
		}
		}
		catch(Exception e)
		{
			System.out.println("handle exception");
		}
			
		finally {
		//step4:close the connection
		
		con.close();
		System.out.println("execution sucessfull");
	}
	}

}
