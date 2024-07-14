package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.DriverSetup;

public class test_HomePage extends DriverSetup {
    HomePage homePage = new HomePage();
    @Test
    public void testHomePageTitle(){
        homePage.loadHomePage();
        homePage.addScreenShoot("HomePage Title");
        Assert.assertEquals(getDriver().getTitle(), "Automation Exercise");
    }
}
