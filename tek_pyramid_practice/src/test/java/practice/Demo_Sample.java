package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo_Sample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		
WebDriver driver =null;
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/ui");
		driver.findElement(By.xpath("//input[@title='Enter your Name']")).sendKeys("username");
	}

}
