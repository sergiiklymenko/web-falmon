package TestSuite;

import BaseTest.BaseTest;
import org.testng.annotations.Test;

public class FalmonHome extends BaseTest {

    @Test(enabled = true)
    public void HomepageTest(){

        driver.get("https://falmon.com/home");
    }

}
