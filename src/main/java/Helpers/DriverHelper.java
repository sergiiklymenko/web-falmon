package Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverHelper {

    int defaultWaitTime = 20;
     WebDriver driver = LocalDriverManager.getDriver();

    public void click (By locator, String message ) {
    waitForElementToBeClickable(locator, message, defaultWaitTime);
    new WebDriverWait(driver, 5).until(new ExpectedCondition<Boolean>() {
       @Override
       public Boolean apply (WebDriver webDriver) {
           try {
               driver.findElement(locator).click();
           }
           catch (WebDriverException e) {
               System.out.println("Failed to  click locator");
               return false;
           }
           return true;
       }
       @Override
        public String toString () {

           return message;
            }

        });
    }

    public void click(String xpath){
        click(By.xpath(xpath), "Unable to click on locator");
    }

    public void waitForElementToBeClickable (By locator, String message, int defaultWaitTime) {

        new WebDriverWait(driver, defaultWaitTime).until(new ExpectedCondition<WebElement>() {
            @Override
           public WebElement apply (WebDriver webDriver) {
               return ExpectedConditions.elementToBeClickable(locator).apply(webDriver);
           }
           @Override
           public String toString () {
               return message;

           }
        });
    }

    public void waitForElementToBeClickable(By locator)
    {
        waitForElementToBeClickable(locator,"Unable to click on Element",5);
    }

    public void waitForElementToExist(By locator, String message) {
        new WebDriverWait(driver,10).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply (WebDriver webDriver){
                return elementExist(locator);
            }
            @Override
            public String toString() {
                return message;
            }
        });
    }

    public void waitForElementToExist(By locator){
        waitForElementToExist(locator, "Element Does Not Exist");
    }

    public Boolean elementExist(By locator) {
        return driver.findElements(locator).size()>0;
    }

    public void setText(By locator, String text, String message, int defaultWaitTime) {
        waitForElementToExist(locator);
        new WebDriverWait(driver, defaultWaitTime).until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return ExpectedConditions.visibilityOfElementLocated(locator).apply(webDriver);
            }
            @Override
            public String toString()
            {
                return message;
            }
        });
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);

    }
    public void setText(By locator, String text, String message)
    {
        setText(locator,text,message,5);
    }

    public void setText(String xpath, String text){
        setText(By.xpath(xpath), text, "Unable to Set Text");
    }

    public void setText(By locator, String text){
        setText(locator, text, "Unable to Set Text", 5);
    }

    public void getText(By locator, String message, int defaultWaitTime) {
        waitForElementToExist(locator);
        new WebDriverWait(driver, defaultWaitTime).until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return ExpectedConditions.visibilityOfElementLocated(locator).apply(webDriver);
            }
            @Override
            public String toString()
            {
                return message;
            }
        });
        driver.findElement(locator).getText();
    }

    public void getValue(By locator, String attribute, String message, int defaultWaitTime) {
        waitForElementToExist(locator);
        new WebDriverWait(driver, defaultWaitTime).until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return ExpectedConditions.visibilityOfElementLocated(locator).apply(webDriver);
            }
            @Override
            public String toString()
            {
                return message;
            }
        });
        driver.findElement(locator).getAttribute(attribute);
    }

    public void getURL(String url) {
        driver.get(url);
    }
}
