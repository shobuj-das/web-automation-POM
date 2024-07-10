package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage{
    public String homepageurl = "https://automationexercise.com";

    public By login_signup_button = By.xpath("//a[normalize-space()='Signup / Login']");
    public By products = By.xpath("//ul[@class='nav navbar-nav']//li//a[@href='/products']");
    public By testCases = By.xpath("//a[contains(text(),'Test Cases')]");
    public By apiTesting = By.xpath("//a[normalize-space()='API Testing']");
    public By videoTutorial = By.xpath("//a[normalize-space()='Video Tutorials']");
    public By contract = By.xpath("//a[normalize-space()='Contact us']");
    public By leftSlideBarButton = By.xpath("//a[@class='left control-carousel hidden-xs']//i[@class='fa fa-angle-left']");
    public By rightSlidebarButton = By.xpath("//a[@class='right control-carousel hidden-xs']//i[@class='fa fa-angle-right']");

//categories
    public By women = By.xpath("//a[normalize-space()='Women']");
    public By men = By.xpath("//a[normalize-space()='Men']");
    public By kids = By.xpath("//a[normalize-space()='Kids']");
//brands
    public By polo= By.xpath("//a[@href='/brand_products/Polo']");
    public By h_and_m= By.xpath("//a[@href='/brand_products/H&M']");
    public By madame= By.xpath("//a[@href='/brand_products/Madame']");
    public By mast_and_harbour= By.xpath("//a[@href='/brand_products/Mast & Harbour']");
    public By babyHug= By.xpath("//a[@href='/brand_products/Babyhug']");
    public By allenSollyJunior= By.xpath("//a[@href='/brand_products/Allen Solly Junior']");
    public By kookieKids= By.xpath("//a[@href='/brand_products/Kookie Kids']");
    public By biba= By.xpath("//a[@href='/brand_products/Biba']");

//subscription
    public By emailField = By.xpath("//input[@id='susbscribe_email']");
    public By subscriptionButton = By.xpath("//i[@class='fa fa-arrow-circle-o-right']");

    public void loadHomePage(){
        loadAWebPage(homepageurl);
    }

}
