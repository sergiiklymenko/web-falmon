package BaseTest;

import Helpers.LocalDriverManager;
import Helpers.Session;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.ChromeDriverManager;

public class BaseTest {

    private static DesiredCapabilities capabilities = new DesiredCapabilities();
    private static String browser;
    private static Session session = null;

    @BeforeSuite(alwaysRun = true)
    @Parameters({"env", "domain", "browser", })

    public void beforeSuite(@Optional("") String env, @Optional("") String domain, String browser){

        if (env.equals("")){
            System.out.println("~~~~~~~ Please select Environment from Maven Profile ~~~~~~~");
            System.exit(0);
        }

        session = new Session(domain);
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
        WebDriver driver = null;
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
        LocalDriverManager.setWebDriver(driver);
    }
    @AfterMethod(alwaysRun = true)
    public void afterMethod () {
        LocalDriverManager.getDriver().quit();
    }


}
