package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Data_Integration {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		WebDriver driver =null;
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		FileInputStream fis1=new FileInputStream("./src/test/resources/testdata/testdata_tekp.properties");
		Properties pobj=new Properties();
		pobj.load(fis1);
		String URL=pobj.getProperty("url");
		String USERNAME=pobj.getProperty("username");
		String PASSWORD=pobj.getProperty("password");
		FileInputStream fis2=new FileInputStream("C:\\Users\\Debasnata Rath\\Documents\\Book1.xlsx");
		Workbook book=WorkbookFactory.create(fis2);
		Random r=new Random();
		int r_int=r.nextInt();
		String org_name=book.getSheet("Sheet2").getRow(1).getCell(2).getStringCellValue()+r_int;
		
		driver.get(URL);
		
		
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(org_name);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//step:5-logout
		WebElement wb=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(wb);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		//Thread.sleep(3000);
		
          driver.close();
	}
	
}
