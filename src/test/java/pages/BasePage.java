package pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utilities.DriverSetup;

import java.io.ByteArrayInputStream;
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

    public boolean getSelectStatus(By locator){
        boolean status = getDriver().findElement(locator).isSelected();
        return  status;
    }

    public  boolean getEnableStatus(By locator){
        boolean status = getDriver().findElement(locator).isEnabled();
        return status;
    }

    public boolean getDisplayStatus(By locator){
        try{
            return getDriver().findElement(locator).isDisplayed();
        } catch (Exception e){
            return false;
        }
    }

    public String getElementText(By locator){
        return getDriver().findElement(locator).getText();
    }

    public String getAttributeValue(By locator, String attributeName){
        return getDriver().findElement(locator).getAttribute(attributeName);
    }
    public void writeOnElement(By locator, String text) throws InterruptedException {
        getElement(locator).clear();
        getElement(locator).sendKeys(text);
    }

    public void addScreenShoot(String name){
        Allure.addAttachment(name, new ByteArrayInputStream(((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES)));
    }
}
