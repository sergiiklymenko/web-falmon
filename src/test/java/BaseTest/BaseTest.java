package BaseTest;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.ChromeDriverManager;

public class BaseTest {

    private static DesiredCapabilities capabilities = new DesiredCapabilities();
    private static String browser;
    public static WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    @Parameters({"browser"})

    public void beforeSuite(String browser){
        BaseTest.browser=browser;

        if (browser.toLowerCase().equals("chrome")){
            capabilities.setCapability("browserName", "Chrome");
            capabilities.setCapability("browserVersion", "67");
        } else if (browser.toLowerCase().equals("firefox")){
            capabilities.setCapability("browserName", "Firefox");
            capabilities.setCapability("browserVersion", "55");
        } else if (browser.toLowerCase().equals("safari")){
            capabilities.setCapability("browserName", "Safari");
            capabilities.setCapability("browserVersion", "12");
        } else {
            System.out.println("~~~~~~~~~  Please choose a browser from the maven profile  ~~~~~~~~");
            System.exit(0);
        }
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        if (browser.toLowerCase().equals("chrome")) {
            ChromeDriverManager.getInstance().setup();
            driver = new ChromeDriver();
        } else if (browser.toLowerCase().equals("firefox")) {
            FirefoxDriverManager.getInstance().setup();
            driver = new FirefoxDriver();

        } else if (browser.toLowerCase().equals("safari")) {
            driver = new SafariDriver();
        }
        else {
            driver=null;
            System.out.println("~~~~~~~~~  Please choose a browser from the maven profile  ~~~~~~~~");
            System.exit(0);
        }
         driver.manage().window().fullscreen();
    }
    @AfterMethod(alwaysRun = true)
    public void afterMethod () {
        driver.quit();
    }


}
