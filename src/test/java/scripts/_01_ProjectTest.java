package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Waiter;

import java.util.List;

public class _01_ProjectTest extends Base{


        @BeforeMethod
        public void setPage(){
            driver.get("https://techglobal-training.netlify.app/frontend/project-1");

        }

        //-------------------------Test Case 01-----------------------

        @Test(priority = 1)
    public void validateTheContactUs() throws InterruptedException {
            WebElement header = driver.findElement(By.className("is-size-2"));
            Assert.assertTrue(header.isDisplayed());
            Assert.assertEquals(header.getText(), "Contact Us");
            Thread.sleep(2000);

            List<WebElement> contactInformation = driver.findElements(By.cssSelector("div[class='mb-5']>p"));

            String[] expectedInfo = {"2860 S River Rd Suite 350, Des Plaines IL 60018", "info@techglobalschool.com", "(773) 257-3010"};
            for (int i = 0; i < contactInformation.size(); i++) {
                Assert.assertTrue(contactInformation.get(i).isDisplayed());
                Assert.assertEquals(contactInformation.get(i).getText(), expectedInfo[i]);

            }
        }

        //-------------------------Test Case 02-----------------------

        @Test
    public void validateFullNameInputBoxDisplay(){
            WebElement fullNameInputBoxDisplay = driver.findElement(By.xpath("(//div[@class='control'])[1]/input"));
            Assert.assertTrue(fullNameInputBoxDisplay.isDisplayed());

            WebElement fullNameInputBoxRequire = driver.findElement(By.xpath("(//div[@class='control'])[1]/input"));
            Assert.assertEquals(fullNameInputBoxRequire.getAttribute("required"), "true"); // check this one

            WebElement fullNameLabel = driver.findElement(By.xpath("(//label[@class='label'])[1]"));
            Assert.assertEquals(fullNameLabel.getText(), "Full name *");
            Assert.assertEquals(fullNameInputBoxDisplay.getAttribute("placeholder"), "Enter your full name"); // check this one
        }

        //-------------------------Test Case 03-----------------------

        @Test
    public void validateGender(){
            WebElement genderLabel = driver.findElement(By.xpath("(//label[@class='label'])[2]"));
            Assert.assertEquals(genderLabel.getText(), "Gender *");
            Assert.assertTrue(genderLabel.isEnabled()); // check this one

            String[] expectedText = {"Male", "Female", "Prefer not to disclose"};
            List<WebElement> genderButtonsExist = driver.findElements(By.cssSelector("label[class*='radio']"));
            List<WebElement> genderButtonsSelected = driver.findElements(By.cssSelector("input[class*='mr-1']"));

            for (int i = 0; i < expectedText.length; i++) {
                Assert.assertEquals(genderButtonsExist.get(i).getText(), expectedText[i]);
                Assert.assertTrue(genderButtonsExist.get(i).isEnabled());
                Assert.assertFalse(genderButtonsSelected.get(i).isSelected());

            }

            genderButtonsSelected.get(0).click();
            Assert.assertTrue(genderButtonsSelected.get(0).isSelected());

            for (int i = 1; i < genderButtonsExist.size(); i++) {
                Assert.assertFalse(genderButtonsSelected.get(i).isSelected());
            }

            genderButtonsSelected.get(1).click();
            Assert.assertTrue(genderButtonsSelected.get(1).isSelected());

            for (int i = 0; i < genderButtonsExist.size(); i++) {
                Assert.assertFalse(genderButtonsSelected.get(i).isSelected());
                i += 1;
            }
            WebElement genderRequire = driver.findElement(By.cssSelector(".mr-1"));

            Assert.assertEquals(genderRequire.getAttribute("required"), "true");  //check this one

            List<WebElement> genderOptions = driver.findElements(By.className("radio"));

            String[] expectedOptions = {"Male", "Female", "Prefer not to disclose"};

            for (int i = 0; i <= 2; i++) {
                Assert.assertTrue(genderOptions.get(i).isDisplayed());
                Assert.assertEquals(genderOptions.get(i).getText(), expectedOptions[i]);

            }

        }


    //-------------------------Test Case 04-----------------------
    @Test
    public void validateAddressInputBox(){
            WebElement addressInputBox = driver.findElement(By.cssSelector(" div:nth-child(3) > div > input"));
            Assert.assertTrue(addressInputBox.isDisplayed());
            Assert.assertEquals(addressInputBox.getAttribute("required"), null);

            WebElement addressLabel = driver.findElement(By.xpath("(//label[@class='label'])[3]"));
            Assert.assertTrue(addressLabel.isDisplayed());
            Assert.assertEquals(addressLabel.getText(), "Address");

            Assert.assertEquals(addressInputBox.getAttribute("placeholder"), "Enter your address");

    }

    //-------------------------Test Case 05-----------------------
    @Test
    public void validateTheEmail(){
            WebElement emailInputbox = driver.findElement(By.xpath("(//input[@class='input'])[3]"));
            Assert.assertTrue(emailInputbox.isDisplayed());
            Assert.assertEquals(emailInputbox.getAttribute("required"), "true");

            WebElement emailLabel = driver.findElement(By.xpath("(//label[@class='label'])[4]"));
            Assert.assertEquals(emailLabel.getText(), "Email *");

            Assert.assertEquals(emailInputbox.getAttribute("placeholder"), "Enter your email");
    }

    //-------------------------Test Case 06-----------------------
    @Test
    public void validatePhone(){
            WebElement phoneInputBox = driver.findElement(By.xpath("(//input[@class='input'])[4]"));
            Assert.assertTrue(phoneInputBox.isDisplayed());
            Assert.assertEquals(phoneInputBox.getAttribute("required"), null);

            WebElement phoneLabel = driver.findElement(By.xpath("(//label[@class='label'])[5]"));
            Assert.assertTrue(phoneLabel.isDisplayed());
            Assert.assertEquals(phoneLabel.getText(), "Phone");

            Assert.assertEquals(phoneInputBox.getAttribute("placeholder"), "Enter your phone number");
    }

    //-------------------------Test Case 07-----------------------
    @Test
    public void validateMessageTextArea(){
            WebElement messageText = driver.findElement(By.cssSelector(".textarea"));
            Assert.assertTrue(messageText.isDisplayed());
            Assert.assertEquals(messageText.getAttribute("required"), null);

            WebElement messageTextLabel = driver.findElement(By.xpath("(//label[@class='label'])[6]"));
            Assert.assertTrue(messageTextLabel.isDisplayed());
            Assert.assertEquals(messageTextLabel.getText(), "Message");

            Assert.assertEquals(messageText.getAttribute("placeholder"), "Type your message here...");
    }

    //-------------------------Test Case 08-----------------------
    @Test
    public void validateConsent(){
            WebElement consentLabel = driver.findElement(By.cssSelector(".checkbox"));
            Assert.assertTrue(consentLabel.isDisplayed());
            Assert.assertEquals(consentLabel.getText(), "I give my consent to be contacted.");

            WebElement consentInput = driver.findElement(By.cssSelector("input[type='checkbox']"));
            Assert.assertEquals(consentInput.getAttribute("required"), "true");

            Assert.assertTrue(consentInput.isEnabled());  // label or input?
            consentInput.click();
            Assert.assertTrue(consentInput.isSelected());
            Waiter.pause(3);

            consentInput.click();
            Assert.assertFalse(consentInput.isSelected());
            Waiter.pause(3);
    }

    //-------------------------Test Case 09-----------------------
    @Test
    public void validateSubmitButton(){
            WebElement submitButton = driver.findElement(By.cssSelector(".is-link"));
            Assert.assertTrue(submitButton.isDisplayed());
            Assert.assertTrue(submitButton.isEnabled());
            Assert.assertEquals(submitButton.getText(), "SUBMIT");
    }

    //-------------------------Test Case 10-----------------------
    @Test
    public void validateFormSubmission(){
        WebElement fullNameInputBoxDisplay = driver.findElement(By.xpath("(//div[@class='control'])[1]/input"));
        fullNameInputBoxDisplay.sendKeys("John Doe");
        List<WebElement> genderOptions = driver.findElements(By.className("radio"));
        genderOptions.get(0).click();
        WebElement addressInputBox = driver.findElement(By.cssSelector(" div:nth-child(3) > div > input"));
        addressInputBox.sendKeys("123 Chicago");
        WebElement emailInputbox = driver.findElement(By.xpath("(//input[@class='input'])[3]"));
        emailInputbox.sendKeys("abc@gmail.com");
        WebElement phoneInputBox = driver.findElement(By.xpath("(//input[@class='input'])[4]"));
        phoneInputBox.sendKeys("123 4567");
        WebElement messageText = driver.findElement(By.cssSelector(".textarea"));
        messageText.sendKeys("Hello World");
        WebElement consentInput = driver.findElement(By.cssSelector("input[type='checkbox']"));
        consentInput.click();
        WebElement submitButton = driver.findElement(By.cssSelector(".is-link"));
        submitButton.click();
        WebElement formMessage = driver.findElement(By.cssSelector(".mt-5"));
        Assert.assertEquals(formMessage.getText(), "Thanks for submitting!");
    }

}
