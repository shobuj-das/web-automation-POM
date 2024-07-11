package pages;

import org.openqa.selenium.By;
import utilities.DriverSetup;

public class SingupPage extends DriverSetup {

// locators
    public By name = By.xpath("//input[@placeholder='Name']");
    public By email = By.xpath("//input[@data-qa='signup-email']");
    public By signUpButton = By.xpath("//button[normalize-space()='Signup']");
    public By mrTitle = By.xpath("//input[@id='id_gender1']");
    public By mrsTitle = By.xpath("//input[@id='id_gender2']");
    public By password = By.xpath("//input[@id='password']");
    
}
