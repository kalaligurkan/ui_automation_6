package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Waiter;

public class _19_TGActionsTest extends Base{

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend");
        driver.findElement(By.id("card-15")).click();
        actions = new Actions(driver);
    }

    /**
     * Go to https://techglobal-training.com/frontend/
     * Click on the "Actions" card
     * Verify that the user is redirected to the Actions page
     * Verify that the first three web elements are present and labeled as "Click on me", "Right-Click on me", and "Double-Click on me"
     * Perform a click action on the first web element labeled "Click on me"
     * Verify that a message appears next to the element stating, "You clicked on a button!"
     * Perform a right-click action on the second web element labeled "Right-Click on me"
     * Verify that the message appears next to the element stating, "You right-clicked on a button!"
     * Perform a double-click action on the third web element labeled "Double-Click on me"
     * Verify that the message appears next to the element stating, "You double-clicked on a button!"
     */
    @Test
    public void mouseActions(){
       //  actions.dragAndDrop(driver.findElement(By.id("")), driver.findElement(By.id(""))).perform();

        WebElement clickOnMeButton = driver.findElement(By.id("click"));
        actions.moveToElement(clickOnMeButton).click().perform();

        WebElement clickResult = driver.findElement(By.id("click_result"));
        Assert.assertEquals(clickResult.getText(), "You clicked on a button!");

        WebElement rightClickButton = driver.findElement(By.id("right-click"));
        actions.moveToElement(rightClickButton).contextClick().perform();

        WebElement rightClickResult = driver.findElement(By.id("right_click_result"));
        Assert.assertEquals(rightClickResult.getText(), "You right-clicked on a button!");


        WebElement doubleClickButton = driver.findElement(By.id("double-click"));
        actions.moveToElement(doubleClickButton).doubleClick().perform();

        WebElement doubleClickResult = driver.findElement(By.id("double_click_result"));
        Assert.assertEquals(doubleClickResult.getText(), "You double-clicked on a button!");


        WebElement dragElementButton = driver.findElement(By.id("drag_element"));
        WebElement dropElementButton = driver.findElement(By.id("drop_element"));
        actions.dragAndDrop(dragElementButton, dropElementButton).perform();


        WebElement dragAndDropClickResult = driver.findElement(By.id("drag_and_drop_result"));
        Assert.assertEquals(dragAndDropClickResult.getText(), "An element dropped here!");
        Waiter.pause(4);
    }
    /**
     * TEST CASE 2
     * Go to https://techglobal-training.com/frontend/
     * Click on the "Actions" card
     * Verify that the last two web elements are present and labeled as "Drag Me", and "Drop Here",
     * Perform a Drag and Drop action on the "Drag Me" web element, and drop it to "Drop Here"
     * Verify that the first web element "Drag me" is successfully dropped into the second web element "Drop Here"
     * Verify that a message appears next to the web element stating, "An element dropped here!"
     */

    @Test
    public void dragAndDropActions(){
        WebElement dragElementButton = driver.findElement(By.id("drag_element"));
        WebElement dropElementButton = driver.findElement(By.id("drop_element"));
        actions.moveToElement(dragElementButton).clickAndHold().moveToElement(dropElementButton).release().perform();

        WebElement dragAndDropClickResult = driver.findElement(By.id("drag_and_drop_result"));
        Assert.assertEquals(dragAndDropClickResult.getText(), "An element dropped here!");
        //Waiter.pause(4);
    }

    /**
     * TEST CASE 3
     * Go to https://techglobal-training.com/frontend/
     * Click on the "Actions" card
     * Go to the input box, and remove if there is an existing text inside
     * First, enter “h” to the input box in upper case using keyboard actions
     * Then complete the word by sending “ello” as a key
     * Validate value attribute of the input box is “Hello”
     * techglobal-training.comtechglobal-training.com
     * Techglobal Training | Home
     * Practice your automation skills
     */

    @Test
    public void keyboardActions(){
        WebElement inputBox = driver.findElement(By.id("input_box"));
        actions.keyDown(Keys.SHIFT).sendKeys(inputBox, "h").keyUp(Keys.SHIFT).sendKeys("ello").perform();
        Assert.assertEquals(inputBox.getAttribute("value"), "Hello");
        Waiter.pause(4);
    }

    /**
     *TEST CASE 4
     * Go to https://techglobal-training.com/frontend/
     * Click on the "Actions" card
     * Go to the input box, and remove if there is an existing text inside
     * Enter “techglobal” to input the box with uppercases
     * Validate the value attribute for the search input box is “TECHGLOBAL”
     * Then, copy the text and paste it again
     * Validate the value attribute for the search input box is “TECHGLOBALTECHGLOBAL”
     */

    @Test
    public void moreKeyboardActions(){
        WebElement inputBox = driver.findElement(By.id("input_box"));
        actions.keyDown(Keys.SHIFT).sendKeys(inputBox, "techglobal").keyUp(Keys.SHIFT)
                .keyDown(Keys.CONTROL).sendKeys("acvv").perform();
                Waiter.pause(4);

        Assert.assertEquals(inputBox.getAttribute("value"), "TECHGLOBALTECHGLOBAL");
    }


}
