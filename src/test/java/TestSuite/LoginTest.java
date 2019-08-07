package TestSuite;

import BaseTest.BaseTest;
import PageObjects.Login;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(enabled = true)
    public void LoginTrial(){
        Login login = new Login().get();
        login
                .setLogin("sergiiklemenko@gmail.com")
                .setPassword("Falmon123")
                .clickLogin();
    }

}
