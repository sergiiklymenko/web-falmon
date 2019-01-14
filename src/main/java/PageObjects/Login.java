package PageObjects;

import AbstractClasses.PageBase;
import org.openqa.selenium.By;

public class Login extends PageBase {


   public Login() {
        url = url + "auth/login";
    }

    public Login get() {
       getUrl();
       return isLoaded();
    }

    public Login isLoaded(){
       dh.waitForElementToExist(By.xpath("//div[@class='text-center']"));
       return this;
    }

}
