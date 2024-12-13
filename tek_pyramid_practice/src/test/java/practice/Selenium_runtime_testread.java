package practice;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Selenium_runtime_testread {
	@Test
	public void get_ruuntime_params() throws IOException
	{

		WebDriver driver =null;
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		//String URL=
		//String USERNAME=
		//String PASSWORD=
		
		//String org_name=
		
		//driver.get(URL);
		
		
		//driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		//driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
		//driver.findElement(By.id("submitButton")).click();
	}
	

}
