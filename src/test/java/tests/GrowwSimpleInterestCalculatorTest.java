package tests;

import main.java.utils.ExcelUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver; 
import org.openqa.selenium.By;
import java.time.Duration;
import java.util.List;
import java.io.IOException;


public class GrowwSimpleInterestCalculatorTest {
    // Test methods for GrowwSimpleInterestCalculator would go here
    public static void main(String[] args) throws IOException {
        System.out.println("This is a placeholder for GrowwSimpleInterestCalculatorTest class.");
        WebDriver driver = new ChromeDriver();
        driver.get("https://groww.in/calculators/simple-interest-calculator");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Path of test data file
         //String xlFilePath = System.getProperty("user.dir") + "\\test-data\\TestData.xlsx";
         //int rowCount = ExcelUtils.getRowCount(xlFilePath, "Sheet1");
        // int colCount = ExcelUtils.getCellCount(xlFilePath, "Sheet1", 1);

        driver.findElement(By.xpath("//input[@id='PRINCIPAL_AMOUNT']")).clear();
        driver.findElement(By.xpath("//input[@id='PRINCIPAL_AMOUNT']")).sendKeys("11000");
        driver.findElement(By.xpath("//input[@id='RATE_OF_INTEREST']")).clear();
        driver.findElement(By.xpath("//input[@id='RATE_OF_INTEREST']")).sendKeys("10");
        driver.findElement(By.xpath("//input[@id='TIME_PERIOD']")).clear();
        driver.findElement(By.xpath("//input[@id='TIME_PERIOD']")).sendKeys("3");
        
    

        //System.out.println("Total Interest : "+TotalInterest);
        driver.quit();
    }
}