package PageObjects;

import AbstractClasses.PageBase;
import Helpers.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends PageBase {
    WebDriver driver
   public Login(WebDriver driver) {
        dh = new DriverHelper(driver);
        url = url + "auth/login";
    }

    public Login get() {
       getUrl();
       return isLoaded();
    }

    public Login isLoaded(){
        dh.waitForElementToExist(By.xpath(""));

    }

}
