package scripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class StudyClass {

    public static WebDriver driver;

    @BeforeMethod
            public void setStudy(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://demoqa.com/text-box");

    }

    @Test
    public void validateTask1(){
        WebElement fullNameElement = driver.findElement(By.id("userName"));
        fullNameElement.click();
        fullNameElement.sendKeys("John Doe");

        WebElement emailElement = driver.findElement(By.cssSelector(".mr-sm-2[placeholder='name@example.com']"));
        Assert.assertTrue(emailElement.isDisplayed());
        Assert.assertTrue(emailElement.isEnabled());
    }

}
