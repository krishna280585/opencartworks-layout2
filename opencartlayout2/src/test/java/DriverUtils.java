
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DriverUtils {

   // private static WebDriver driver;
    public EventFiringWebDriver eventwebdriver;
    private static String OS=System.getProperty("os.name").toLowerCase();
    private static String userPath=System.getProperty("user.dir");
    private static final Logger LOGGER = LoggerFactory.getLogger(DriverUtils.class);
    String browserName=AutomationConstraints.BROWSER;
    String url=AutomationConstraints.URL;

    @Before
    public void setDriver() {
        if (eventwebdriver == null) {
            if (AutomationConstraints.Chrome.equals("yes")) {
                setBrowserPath(browserName);
                if (isLinux()) {
                    ChromeOptions options = new ChromeOptions();
                    options.setBinary(userPath + "/src/test/resources/drivers/Ubuntu/google-chrome-stable_current_amd64.deb");
                    eventwebdriver = new EventFiringWebDriver(new ChromeDriver(options));
                } else {
                    eventwebdriver = new EventFiringWebDriver(new ChromeDriver());
                }

            }
            else  if (AutomationConstraints.Firefox.equals("yes")) {
                setBrowserPath(browserName);
                eventwebdriver = new EventFiringWebDriver(new FirefoxDriver());
                eventwebdriver.manage().window().maximize();
            }
            eventwebdriver.get(url);
        }
    }
    public void setBrowserPath(String browserName) {

        if (browserName.equalsIgnoreCase("chrome")) {
            LOGGER.info("opening the chrome browser");

            if (isMac()) {
                LOGGER.info("opening browser in Mac");
                System.setProperty("webdriver.chrome.driver", userPath + "/src/test/resources/drivers/Mac/chromedriver");
            } else if (isLinux()) {
                LOGGER.info("opening browser in Linux");
                System.setProperty("webdriver.chrome.driver", userPath + "/src/test/resources/drivers/Ubuntu/chromedriver");
            } else {
                LOGGER.info("opening browser in Windows");
                System.setProperty("webdriver.chrome.driver", userPath + "/src/test/resources/drivers/Windows/chromedriver.exe");
            }
        }
        else if (browserName.equalsIgnoreCase("firefox")) {

            LOGGER.info("opening firefox browser");
            {

                if (isMac()) {
                    LOGGER.info("opening browser in Mac");
                    System.setProperty("webdriver.gecko.driver", userPath + "/src/test/resources/drivers/Mac/geckodriver");
                } else if (isLinux()) {
                    LOGGER.info("opening browser in Linux");
                    System.setProperty("webdriver.gecko.driver", userPath + "/src/test/resources/drivers/Ubuntu/geckodriver");
                } else {
                    LOGGER.info("opening browser in Windows");
                    System.setProperty("webdriver.gecko.driver", userPath + "/src/test/resources/drivers/Windows/geckodriver.exe");
                }
            }

        }
    }

    private static boolean isMac()
    {
        return (OS.indexOf("mac") >= 0);
    }
    private static boolean isLinux()
    {
        return (OS.indexOf("linux") >= 0);
    }
    private static boolean isWindows()
    {
        return (OS.indexOf("windows") >= 0);
    }
    @After
    public void close()
    {
        eventwebdriver.quit();
    }

}


