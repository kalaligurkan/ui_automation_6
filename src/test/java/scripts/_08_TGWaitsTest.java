package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Driver;

public class _08_TGWaitsTest extends Base{

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend");
        driver.findElement(By.id("card-4")).click();
    }

    @Test
    public void waitForRedBox(){
        WebElement redBox = driver.findElement(By.id("red"));
        redBox.click();

        WebElement redBoxShown = driver.findElement(By.cssSelector("button[class*='Box']"));
        Assert.assertTrue(redBoxShown.isDisplayed());
    }

    @Test
    public void waitForBlueBox(){
        WebElement blueBoxButton = driver.findElement(By.id("blue"));
        blueBoxButton.click();



        WebElement blueBox = driver.findElement(By.cssSelector("button[class*='blue_box']"));

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
        wait.until(ExpectedConditions.visibilityOf(blueBox));

        Assert.assertTrue(blueBox.isDisplayed());

    }
}
