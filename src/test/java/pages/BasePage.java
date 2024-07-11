package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utilities.DriverSetup;

import java.time.Duration;

public class BasePage extends DriverSetup {

    public void loadAWebPage(String url){
        getDriver().get(url);
    }
    public WebElement getElement(By locator) throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
//        return getDriver().findElement(locator);
    }

    public void clickOnElement(By locator){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public boolean isSelected(By locator){
        boolean status = getDriver().findElement(locator).isSelected();
        return  status;
    }

    public  boolean isEnabled(By locator){
        boolean status = getDriver().findElement(locator).isEnabled();
        return status;
    }

    public boolean isDisplayed(By locator){
        boolean status = getDriver().findElement(locator).isDisplayed();
        return status;
    }

    public String getText(By locator){
        return getDriver().findElement(locator).getText();
    }

    public String getAttributeValue(By locator){
        return getDriver().findElement(locator).getAttribute();
    }

}
