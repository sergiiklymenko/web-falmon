package TestSuite;

import BaseTest.BaseTest;
import PageObjects.LoginPage;
import org.testng.annotations.Test;

public class FalmonHome extends BaseTest {

    @Test(enabled = true)
    public void HomepageTest(){

        new LoginPage(driver);
        driver.get("https://falmon.com/home");




    }

}
