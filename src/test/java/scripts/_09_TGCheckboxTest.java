package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class _09_TGCheckboxTest extends Base{

/*
Go to https://techglobal-training.com/frontend/
Click on the "Checkboxes" card
Validate "Apple" and "Microsoft" checkboxes are displayed, enabled, and not selected
Select both and validate they are both selected
Deselect both and validate they are deselected
techglobal-training.comtechglobal-training.com
Techglobal Training | Home
Practice your automation skills
 */

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/");
        driver.findElement(By.id("card-7")).click();
    }

    @Test
    public void validateCheckBoxes(){
        List<WebElement> checkboxLabel = driver.findElements(By.cssSelector("#checkbox-button-group_1 label"));
        List<WebElement> checkboxInput = driver.findElements(By.cssSelector("#checkbox-button-group_1 input"));

        checkboxInput.forEach(cb -> {
            Assert.assertTrue(cb.isDisplayed());
            Assert.assertFalse(cb.isSelected());
            Assert.assertTrue(cb.isEnabled());
        });



        for (int i = 0; i < checkboxLabel.size(); i++) {
            checkboxLabel.get(i).click();
            Assert.assertTrue(checkboxInput.get(i).isSelected());

        }

        for (int i = 0; i < checkboxLabel.size(); i++) {
            checkboxLabel.get(i).click();
            Assert.assertFalse(checkboxInput.get(i).isSelected());

        }
    }

    @Test
    public void validatePracticeMore(){
        List<WebElement> practiceMoreLabel = driver.findElements(By.cssSelector("#checkbox-button-group_2 label"));
        List<WebElement> practiceMoreInput = driver.findElements(By.cssSelector("#checkbox-button-group_2 input"));


        practiceMoreInput.forEach(cb -> {
            Assert.assertTrue(cb.isDisplayed());
            Assert.assertFalse(cb.isSelected());
            Assert.assertTrue(cb.isEnabled());
        });

        for (int i = 0; i < practiceMoreLabel.size(); i++) {
            practiceMoreLabel.get(i).click();
            Assert.assertTrue(practiceMoreInput.get(i).isSelected());

        }

        for (int i = 0; i < practiceMoreLabel.size(); i++) {
            practiceMoreLabel.get(i).click();
            Assert.assertFalse(practiceMoreInput.get(i).isSelected());

        }


    }
}
