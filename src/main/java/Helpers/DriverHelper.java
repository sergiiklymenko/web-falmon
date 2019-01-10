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

    public void getUrl(String url) {
        driver.get(url);
    }
}
