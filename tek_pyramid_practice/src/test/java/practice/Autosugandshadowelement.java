package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Autosugandshadowelement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver=new ChromeDriver();

driver.get("https://demowebshop.tricentis.com/");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.findElement(By.xpath("//input[@id='small-searchterms']")).sendKeys("compu");
driver.findElement(By.xpath("//a[contains(text(),'Build your own cheap computer')]"));

	}

}
