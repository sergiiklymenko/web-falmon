package PageObjects;

import AbstractClasses.PageBase;
import Helpers.DriverHelper;
import org.openqa.selenium.WebDriver;

public class Login extends PageBase {

   public Login(WebDriver driver) {

        dh = new DriverHelper(driver);
        dh.getUrl(url = url + "auth/login");
    }


}
