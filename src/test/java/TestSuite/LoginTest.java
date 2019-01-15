package TestSuite;

import BaseTest.BaseTest;
import PageObjects.Login;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(enabled = true)
    public void LoginTest(){

        Login login = new Login();
        login.get();

    }

}
