package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Waiter;

public class _15_TGFileUpload extends Base{

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.netlify.app/frontend");
        driver.findElement(By.id("card-13")).click();


    }

    /**
     * NOTE: Create .txt file called "hello.txt" in the root of your project and use it as a file path.
     * TEST CASE
     * Go to https://techglobal-training.com/frontend/
     * Click on the "File Upload" card
     * Send the path of the file as keys to the "Choose File" input box
     * Click on the "UPLOAD" button
     * Validate the result message equals "You Uploaded 'hello.txt'"
     */

    @Test
    public void basicFileUpload(){
        WebElement fileUploadInput = driver.findElement(By.id("file_upload"));
        WebElement UploadButton = driver.findElement(By.id("file_submit"));


        String filePath = "C:\\Users\\pc\\IdeaProjects\\ui_automation_6\\hello.txt";

        fileUploadInput.sendKeys(filePath);
        Waiter.pause(3);
        UploadButton.click();

        WebElement result = driver.findElement(By.id("result"));

        Assert.assertEquals(result.getText(), "You Uploaded '" + filePath.substring(filePath.lastIndexOf('\\') + 1) + "'");

    }
}
