package practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNg_assignment1 {
	public WebDriver driver=null;
	@BeforeClass
	public void launchbrowse()
	{
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	@BeforeMethod
	public void nav_to_app()
	{
		driver.get("https://demoapps.qspiders.com/");
	}
	@Test(enabled=false)
	public void javaScript_popops()
	{
		driver.findElement(By.xpath("//div[text()='Explore more'][1]")).click();
		driver.findElement(By.xpath("//section[text()='Popups']")).click();
		driver.findElement(By.xpath("//section[text()='Javascript']")).click();

		driver.findElement(By.id("buttonAlert2")).click();
		driver.switchTo().alert().accept();	
	}
	@Test
	public void browser_Window()
	{
		driver.findElement(By.xpath("//div[text()='Explore more'][1]")).click();
		driver.findElement(By.xpath("//section[text()='Popups']")).click();
		driver.findElement(By.xpath("//section[text()='Browser Windows']")).click();

		driver.findElement(By.id("browserLink1")).click();
		//String mainid=driver.getWindowHandle();
		Set<String> allid=driver.getWindowHandles();
		for(String id:allid)
		{
			driver.switchTo().window(id);
		}

	}
	@Test
	public void authenrtication_Popop()
	{
		driver.findElement(By.xpath("//div[text()='Explore more'][1]")).click();
		driver.findElement(By.xpath("//section[text()='Popups']")).click();
		driver.findElement(By.xpath("//section[text()='Authentication']")).click();
		driver.findElement(By.xpath("//a[text()='Login']")).click();

		driver.get("https://rcdebasnata24:242424@basic-auth-git-main-shashis-projects-4fa03ca5.vercel.app/");

	}
	@Test
	public void scroll_infinite()
	{
		driver.findElement(By.xpath("//div[text()='Explore more'][1]")).click();
		driver.findElement(By.xpath("//section[text()='Scroll']")).click();
		driver.findElement(By.xpath("//a[contains(@class,'pe-1 py-1')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Open In New Tab')]")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//assignment incompleted have doubts

	}
	@Test
	public void dropdown()
	{
		driver.findElement(By.xpath("//div[text()='Explore more'][1]")).click();
		driver.findElement(By.xpath("//section[text()='Dropdown']")).click();
		//driver.findElement(By.xpath("//a[contains(@class,'pe-1 py-1')]")).click();
		//driver.findElement(By.xpath("//a[contains(text(),'Open In New Tab')]")).click();

		WebElement wb2=driver.findElement(By.id("select1"));
		Select s=new Select(wb2);
		s.selectByVisibleText("+91");
		driver.findElement(By.xpath("//input[@placeholder='enter your number']")).sendKeys("5252631401");
		WebElement wb3=driver.findElement(By.id("select2"));
		Select s2=new Select(wb3);
		s2.selectByValue("female");
		WebElement wb4=driver.findElement(By.id("select3"));
		Select s3=new Select(wb4);
		s3.selectByValue("India");


		WebElement wb5=driver.findElement(By.id("select5"));
		Select s4=new Select(wb5);
		s4.selectByValue("Odisha");
		
		//WebElement wb6=driver.findElement(By.xpath("//option[text()='Select City']"));
		//Select s5=new Select(wb6);
		//s5.selectByVisibleText("Bhadrak");
		WebElement wb7=driver.findElement(By.id("select7"));
		Select s6=new Select(wb7);
		s6.selectByIndex(2);
		driver.findElement(By.id("continuebtn")).click();
		driver.findElement(By.xpath("//input[@id='attended']")).click();
		driver.findElement(By.xpath("//input[@id='willing1']")).click();
		driver.findElement(By.xpath("//button[text()='Continue']")).click();
		driver.findElement(By.id("domain1")).click();
		driver.findElement(By.id("mode2")).click();
		driver.findElement(By.id("mode5")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();

	}
	@Test
	public void Frame()
	{
		driver.findElement(By.xpath("//div[text()='Explore more'][1]")).click();
		driver.findElement(By.xpath("//section[text()='Frames']")).click();
		driver.findElement(By.xpath("//section[text()='iframes']")).click();
		WebElement wb=driver.findElement(By.xpath("//iframe"));
		driver.switchTo().frame(wb);


		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("rcdebasnata24@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("rcdebasnata24@gmail.com");
		driver.findElement(By.xpath("//button[@id='submitButton']")).click();

	}
	
	
	@AfterMethod
	public void close_browser()
	{
		driver.quit();
	}

}
