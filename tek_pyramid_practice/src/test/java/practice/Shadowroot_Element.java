package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Shadowroot_Element {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		
         WebDriver driver=new ChromeDriver();
         
         driver.get("https://demoapps.qspiders.com/ui/shadow");
         SearchContext sct=driver.findElement(By.xpath("//form//div[1]")).getShadowRoot();
         sct.findElement(By.cssSelector("input[type='text']")).sendKeys("username");
	}

}
