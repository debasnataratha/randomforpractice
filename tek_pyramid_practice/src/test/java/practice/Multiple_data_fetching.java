package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Multiple_data_fetching {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		
		 // Initialize WebDriver and open Flipkart
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.flipkart.com");

        // Close the login pop-up if it appears
        
           // WebElement closeLoginPopup = driver.findElement(By.xpath("//button[contains(text(),'✕')]"));
            //closeLoginPopup.click();
        
            System.out.println("Login popup not displayed.");
        FileInputStream fis=new FileInputStream("F:\\external_practice_tekp\\flipkart_productlist.xlsx");

        // Search for iPhones
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("iPhone");
        searchBox.submit();

        // Wait for results to load
        Thread.sleep(2000);

        // Locate iPhone names and prices on the page
        List<WebElement> productNames = driver.findElements(By.cssSelector("div._4rR01T")); // Adjust selector if necessary
        List<WebElement> productPrices = driver.findElements(By.cssSelector("div._30jeq3._1_WHN1")); // Adjust selector if necessary

        // Set up Excel file and sheet
        Workbook book=WorkbookFactory.create(fis);
        Sheet sh =book.getSheet("productdetails");

        // Create header row
        Row headerRow = sh.createRow(0);
        headerRow.createCell(0).setCellValue("iPhone Name");
        headerRow.createCell(1).setCellValue("Price");

        // Populate Excel sheet with iPhone names and prices
        for (int i = 0; i < productNames.size() && i < productPrices.size(); i++) {
            Row row = sh.createRow(i + 1);
            row.createCell(0).setCellValue(productNames.get(i).getText());
            row.createCell(1).setCellValue(productPrices.get(i).getText());
        }

        // Write the data to an Excel file
        FileOutputStream fileOut = new FileOutputStream("F:\\\\external_practice_tekp\\\\flipkart_productlist.xlsx"); 
            book.write(fileOut);
        

        // Close resources
        book.close();
        driver.quit();

        System.out.println("Data extracted and saved to iPhone_Prices.xlsx successfully!");
	}

}
