package pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPage extends BasePage{
    HomePage homePage = new HomePage();

// all locators of LoginPage
    public By loginEmail = By.xpath("//input[@data-qa='login-email']");
    public By loginPassword = By.xpath("//input[@placeholder='Password']");
    public By login_button = By.xpath("//button[normalize-space()='Login']");

// signup locator
    public By name = By.xpath("//input[@placeholder='Name']");
    public By signupEmail = By.xpath("//input[@data-qa='signup-email']");
    public By errorMsg = By.xpath("//p[normalize-space()='Your email or password is incorrect!']");
    public void nevigateToLoginPage(){
        homePage.loadHomePage();
        homePage.clickOnElement(homePage.login_signup_button);
    }
}
