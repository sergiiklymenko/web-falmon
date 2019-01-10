package AbstractClasses;

import Helpers.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class PageBase {

    public DriverHelper dh;

    public void test()
    {
        dh.waitForElementToBeClickable(By.xpath(""));
    }


}
