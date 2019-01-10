package TestSuite;

import BaseTest.BaseTest;
import PageObjects.Login;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(enabled = true)
    public void HomepageTest(){

//        new Login(driver);
//        driver.get("https://falmon.com/home");
        Login login = new Login(driver);

    }

}
