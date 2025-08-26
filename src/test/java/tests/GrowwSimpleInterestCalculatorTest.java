package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver; 
import org.openqa.selenium.By;
import java.time.Duration;
import java.util.List;
import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;
import main.java.utils.*;
import org.junit.jupiter.api.Test;



public class GrowwSimpleInterestCalculatorTest {
    // Test methods for GrowwSimpleInterestCalculator would go here

    private static final By TOTAL_INTEREST =
        By.xpath("//table//td[normalize-space()='Total interest']/following-sibling::td//span");

    @Test
    public void testSimpleInterestCalculation() throws IOException {
        
        System.out.println("This is a placeholder for GrowwSimpleInterestCalculatorTest class.");
        WebDriver driver = new ChromeDriver();
        driver.get("https://groww.in/calculators/simple-interest-calculator");
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Path of test data file
         String xlFilePath = System.getProperty("user.dir") + "\\test-data\\TestData.xlsx";
         int rowCount = ExcelUtils.getRowCount(xlFilePath, "Sheet1");

        for(int i=1; i<=rowCount; i++) {

            String principal = ExcelUtils.getCellData(xlFilePath, "Sheet1", i, 0);
            String rate = ExcelUtils.getCellData(xlFilePath, "Sheet1", i, 1);
            String time = ExcelUtils.getCellData(xlFilePath, "Sheet1", i, 2);
            String expectedInterest = ExcelUtils.getCellData(xlFilePath, "Sheet1", i, 3);


            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='PRINCIPAL_AMOUNT']")));
            driver.findElement(By.xpath("//input[@id='PRINCIPAL_AMOUNT']")).clear();
            driver.findElement(By.xpath("//input[@id='PRINCIPAL_AMOUNT']")).sendKeys(principal);

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='RATE_OF_INTEREST']")));
            driver.findElement(By.xpath("//input[@id='RATE_OF_INTEREST']")).clear();
            driver.findElement(By.xpath("//input[@id='RATE_OF_INTEREST']")).sendKeys(rate);

             wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='TIME_PERIOD']")));
             driver.findElement(By.xpath("//input[@id='TIME_PERIOD']")).clear();
             driver.findElement(By.xpath("//input[@id='TIME_PERIOD']")).sendKeys(time);
           
            //read the values ONLY after they stabilize (no changes for 700 ms)
            String interest = ElementsUtils.waitForStableText(driver, TOTAL_INTEREST, Duration.ofSeconds(15), Duration.ofMillis(700));
            System.out.println("Calculated Interest: " + interest + ", Expected Interest: " + expectedInterest);
            
        }

        driver.quit();

    }  
}
