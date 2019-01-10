package PageObjects;

import AbstractClasses.PageBase;
import Helpers.DriverHelper;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase {

   public LoginPage (WebDriver driver) {

        dh = new DriverHelper(driver);
    }


}
