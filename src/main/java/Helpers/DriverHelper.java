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
    WebDriver driver;

    public DriverHelper (WebDriver driver){
       this.driver = driver;
    }

    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

    public WebDriver getDriver() {
        return webDriver.get();
    }

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

    public void waitForElementToBeClickable (final By locator, final String message, int defaultWaitTime) {

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

    public void waitForElementToExist(By locator) {
        new WebDriverWait(driver,10).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply (WebDriver webDriver){
                return elementExist(locator);
            }
            @Override
            public String toString() {
                return "Element does not exist";
            }
        });
    }

    public Boolean elementExist(By locator) {
        return driver.findElements(locator).size()>0;
    }

    public void getURL(String url) {
        driver.get(url);
    }
}
