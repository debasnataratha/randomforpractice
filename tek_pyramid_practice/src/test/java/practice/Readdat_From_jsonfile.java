package practice;

import java.io.FileInputStream;
import java.io.FileReader;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Readdat_From_jsonfile {

	public static void main(String[] args) throws Throwable {
		JSONParser parser=new JSONParser();
		FileReader inputStream=new FileReader("F:\\external_practice_tekp\\appCommonData.json");
		//step1:parse json physical file into java object using JSONParser class
		
		
		Object obj=parser.parse(inputStream);
		
		//step2:
		JSONObject map=(JSONObject)obj;
		System.out.println(map.get("url"));
		//integration with project
		
		String URL=map.get("url").toString();
		String USERNAME=map.get("username").toString();
		String PASSWORD=map.get("password").toString();
WebDriver driver =null;
		
		driver=new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	
		
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
		Thread.sleep(5000);
		//step:5-logout
		WebElement wb=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(wb);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		//Thread.sleep(3000);
		
          driver.close();
		
		
		

	}

}
