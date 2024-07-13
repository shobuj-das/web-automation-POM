package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import utilities.DriverSetup;

import java.time.Duration;

import static org.testng.Assert.assertFalse;

public class test_LoginPage extends DriverSetup {

//    By email_field = By.xpath("//input[@data-qa='login-email']");
//    By password_field = By.xpath("//input[@placeholder='Password']");
//    By login_button = By.xpath("//button[normalize-space()='Login']");


    LoginPage loginPage = new LoginPage();
    BasePage basePage = new BasePage();
    @BeforeSuite
    public void loadPage(){
        loginPage.nevigateToLoginPage();
    }
    @Test
    public void test_login_with_valid_credentials() throws InterruptedException {
        basePage.writeOnElement(loginPage.loginEmail, "shobuj@yopmail.com");
        basePage.writeOnElement(loginPage.loginPassword, "shobuj123");
        loginPage.clickOnElement(loginPage.login_button);

//        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));

        Assert.assertFalse(basePage.displayStatus(loginPage.login_button));
//        Assert.assertEquals(getDriver().findElement(loginPage.errorMsg).getText(), "Your email or password is incorrect!");
    }

    @Test
    public void test_login_with_invalidEmail() throws InterruptedException {
        basePage.writeOnElement(loginPage.loginEmail, "shobujyopmail.com");
        basePage.writeOnElement(loginPage.loginPassword, "shobuj123");
        loginPage.clickOnElement(loginPage.login_button);

        Assert.assertEquals(basePage.getAttributeValue(loginPage.loginEmail, "validationMessage"), "Please include an '@' in the email address. 'adfa' is missing an '@'.");
        Assert.assertFalse(basePage.displayStatus(loginPage.login_button));
    }

}
