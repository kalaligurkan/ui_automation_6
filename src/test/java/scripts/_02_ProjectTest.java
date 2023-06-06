package scripts;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Waiter;

public class _02_ProjectTest extends Base{





    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.netlify.app/frontend/project-2");
    }


    //-------------------------Test Case 01-----------------------

    @Test
    public void validateTheLoginForm(){
        WebElement usernameInputBox = driver.findElement(By.cssSelector("#username"));
        Assert.assertTrue(usernameInputBox.isDisplayed());
        Assert.assertEquals(usernameInputBox.getAttribute("required"), null);

        WebElement usernameLabel = driver.findElement(By.xpath("//label[@for='username']"));
        Assert.assertEquals(usernameLabel.getText(), "Please enter your username");

        WebElement usernamePasswordBox = driver.findElement(By.cssSelector("#password"));
        Assert.assertTrue(usernamePasswordBox.isDisplayed());
        Assert.assertEquals(usernamePasswordBox.getAttribute("required"), null);

        WebElement usernamePasswordLabel = driver.findElement(By.xpath("//label[@for='password']"));
        Assert.assertEquals(usernamePasswordLabel.getText(), "Please enter your password");

        WebElement loginButton = driver.findElement(By.cssSelector("#login_btn"));
        Assert.assertTrue(loginButton.isDisplayed());
        Assert.assertTrue(loginButton.isEnabled());
        Assert.assertEquals(loginButton.getText(), "LOGIN");

        WebElement forgotPassworgLink = driver.findElement(By.xpath("//a[@href='/frontend/project-2']"));
        Assert.assertTrue(forgotPassworgLink.isDisplayed());
        Assert.assertTrue(forgotPassworgLink.isEnabled());
        Assert.assertEquals(forgotPassworgLink.getText(), "Forgot Password?");

    }

    //-------------------------Test Case 02-----------------------

    @Test
    public void validateTheValidLogin(){
    WebElement usernameInputBox = driver.findElement(By.cssSelector("#username"));
    usernameInputBox.sendKeys("TechGlobal");

    WebElement usernamePasswordBox = driver.findElement(By.cssSelector("#password"));
    usernamePasswordBox.sendKeys("Test1234");

    WebElement loginButton = driver.findElement(By.cssSelector("#login_btn"));
    loginButton.click();

    WebElement successLoginText = driver.findElement(By.cssSelector("#success_lgn"));
    Assert.assertEquals(successLoginText.getText(), "You are logged in");

    WebElement logoutButton = driver.findElement(By.cssSelector("#logout"));
    Assert.assertEquals(logoutButton.getText(), "LOGOUT");
    }

    //-------------------------Test Case 03-----------------------

    @Test
    public void validateLogout(){
        WebElement usernameInputBox = driver.findElement(By.cssSelector("#username"));
        usernameInputBox.sendKeys("TechGlobal");

        WebElement usernamePasswordBox = driver.findElement(By.cssSelector("#password"));
        usernamePasswordBox.sendKeys("Test1234");

        WebElement loginButton = driver.findElement(By.cssSelector("#login_btn"));
        loginButton.click();

        WebElement logoutButton = driver.findElement(By.cssSelector("#logout"));
        logoutButton.click();

        WebElement loginForm = driver.findElement(By.cssSelector(".m-auto"));
        Assert.assertTrue(loginForm.isDisplayed());

    }

    //-------------------------Test Case 04-----------------------

    @Test
    public void validateTheForgotPassword(){
        WebElement forgotPasswordLink = driver.findElement(By.xpath("//a[@href='/frontend/project-2']"));
        forgotPasswordLink.click();

        WebElement resetPasswordTitle = driver.findElement(By.cssSelector("#modal_title"));
        Assert.assertTrue(resetPasswordTitle.isDisplayed());

        WebElement closeButton = driver.findElement(By.cssSelector(".delete"));
        Assert.assertTrue(closeButton.isDisplayed());

        WebElement emailInputBox = driver.findElement(By.cssSelector("#email"));
        Assert.assertTrue(emailInputBox.isDisplayed());

        WebElement emailInputBoxLabel = driver.findElement(By.xpath("//label[@for='email']"));
        Assert.assertEquals(emailInputBoxLabel.getText(), "Enter your email address and we'll send you a link to reset your password.");

        WebElement submitButton = driver.findElement(By.cssSelector("#submit"));
        Assert.assertTrue(submitButton.isDisplayed());
        Assert.assertTrue(submitButton.isEnabled());
        Assert.assertEquals(submitButton.getText(), "SUBMIT");
    }

    //-------------------------Test Case 05-----------------------

    @Test
    public void validateTheResetPassword(){
        WebElement forgotPasswordLink = driver.findElement(By.xpath("//a[@href='/frontend/project-2']"));
        forgotPasswordLink.click();

        WebElement resetPasswordModal = driver.findElement(By.cssSelector("div[class*='modal-card' ]"));
        Assert.assertTrue(resetPasswordModal.isDisplayed());

        WebElement closeButton = driver.findElement(By.cssSelector(".delete"));
        closeButton.click();

        // 5. Validate that the “Reset Password” modal is closed
    }

    //-------------------------Test Case 06-----------------------

    @Test
    public void validateResetPasswordFormSubmission(){
        WebElement forgotPasswordLink = driver.findElement(By.xpath("//a[@href='/frontend/project-2']"));
        forgotPasswordLink.click();

        WebElement emailInputBox = driver.findElement(By.cssSelector("#email"));
        emailInputBox.sendKeys("abc2345235sdfg@gmail.com");

        WebElement submitButton = driver.findElement(By.cssSelector("#submit"));
        submitButton.click();

        WebElement formMessage = driver.findElement(By.cssSelector("#confirmation_message"));
        Assert.assertTrue(formMessage.isDisplayed());

    }

    //-------------------------Test Case 07-----------------------

    @Test
    public void validateInvalidLoginEmptyCredentials(){
        WebElement usernameInputBox = driver.findElement(By.cssSelector("#username"));
        usernameInputBox.sendKeys("");

        WebElement usernamePasswordBox = driver.findElement(By.cssSelector("#password"));
        usernamePasswordBox.sendKeys("");

        WebElement loginButton = driver.findElement(By.cssSelector("#login_btn"));
        loginButton.click();

        WebElement failureMessage = driver.findElement(By.cssSelector("#error_message"));
        Assert.assertTrue(failureMessage.isDisplayed());
        Assert.assertEquals(failureMessage.getText(), "Invalid Username entered!");

    }

    //-------------------------Test Case 08-----------------------

    @Test
    public void validateInvalidLoginWrongUsername(){
        WebElement usernameInputBox = driver.findElement(By.cssSelector("#username"));
        usernameInputBox.sendKeys("John");

        WebElement usernamePasswordBox = driver.findElement(By.cssSelector("#password"));
        usernamePasswordBox.sendKeys("Test1234");

        WebElement loginButton = driver.findElement(By.cssSelector("#login_btn"));
        loginButton.click();

        WebElement failureMessage = driver.findElement(By.cssSelector("#error_message"));
        Assert.assertTrue(failureMessage.isDisplayed());
        Assert.assertEquals(failureMessage.getText(), "Invalid Username entered!");
    }

    //-------------------------Test Case 09-----------------------

    @Test
    public void validateInvalidLoginWrongPassword(){
        WebElement usernameInputBox = driver.findElement(By.cssSelector("#username"));
        usernameInputBox.sendKeys("TechGlobal");

        WebElement usernamePasswordBox = driver.findElement(By.cssSelector("#password"));
        usernamePasswordBox.sendKeys("1234");

        WebElement loginButton = driver.findElement(By.cssSelector("#login_btn"));
        loginButton.click();

        WebElement failureMessage = driver.findElement(By.cssSelector("#error_message"));
        Assert.assertTrue(failureMessage.isDisplayed());
        Assert.assertEquals(failureMessage.getText(), "Invalid Password entered!");
        Waiter.pause(3);
    }

    //-------------------------Test Case 10-----------------------

    @Test
    public void validateInvalidLoginWithWrongUsernameAndPassword(){
        WebElement usernameInputBox = driver.findElement(By.cssSelector("#username"));
        usernameInputBox.sendKeys("John");

        WebElement usernamePasswordBox = driver.findElement(By.cssSelector("#password"));
        usernamePasswordBox.sendKeys("1234");

        WebElement loginButton = driver.findElement(By.cssSelector("#login_btn"));
        loginButton.click();

        WebElement failureMessage = driver.findElement(By.cssSelector("#error_message"));
        Assert.assertTrue(failureMessage.isDisplayed());
        Assert.assertEquals(failureMessage.getText(), "Invalid Username entered!");
        Waiter.pause(3);
    }

}
