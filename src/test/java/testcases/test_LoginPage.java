package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.BasePage;
import pages.LoginPage;
import utilities.DataSet;
import utilities.DriverSetup;

import java.time.Duration;

import static org.testng.Assert.assertFalse;

public class test_LoginPage extends DriverSetup {

    LoginPage loginPage = new LoginPage();
    BasePage basePage = new BasePage();
    @BeforeMethod
    public void loadPage(){
        loginPage.nevigateToLoginPage();
    }
    @Test
    public void test_login_with_valid_credentials() throws InterruptedException {
        basePage.writeOnElement(loginPage.loginEmail, "shobuj@yopmail.com");
        basePage.writeOnElement(loginPage.loginPassword, "shobuj123");
        basePage.addScreenShoot("Email and Password added");
        loginPage.clickOnElement(loginPage.login_button);
        basePage.addScreenShoot("Successfully logged in");
//        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));

        Assert.assertFalse(basePage.getDisplayStatus(loginPage.login_button));
//        Assert.assertEquals(getDriver().findElement(loginPage.errorMsg).getText(), "Your email or password is incorrect!");
    }

    @Test
    public void test_login_with_invalidEmail() throws InterruptedException {
        basePage.writeOnElement(loginPage.loginEmail, "shobujyopmail.com");
        basePage.writeOnElement(loginPage.loginPassword, "shobuj123");
        loginPage.clickOnElement(loginPage.login_button);

        Assert.assertEquals(basePage.getAttributeValue(loginPage.loginEmail, "validationMessage"), "Please include an '@' in the email address. 'shobujyopmail.com' is missing an '@'.");
        Assert.assertTrue(basePage.getDisplayStatus(loginPage.login_button));
    }

    @Test(dataProvider = "invalidCredentials", dataProviderClass = DataSet.class)
    public void testWithInvalidCredentials(String email, String password, String errorMsg, String emailValidationMsg, String passValidationMsg) throws InterruptedException {
        basePage.writeOnElement(loginPage.loginEmail, email);
        basePage.writeOnElement(loginPage.loginPassword, password);
        basePage.clickOnElement(loginPage.login_button);
        Assert.assertTrue(loginPage.checkErrorMessages(errorMsg, emailValidationMsg,passValidationMsg));
        Assert.assertTrue(basePage.getDisplayStatus(loginPage.login_button));
        Assert.assertTrue(basePage.getDisplayStatus(loginPage.loginPassword));
        Assert.assertTrue(basePage.getDisplayStatus(loginPage.loginEmail));
    }

}
