import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.sk.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InvokeBrowser {
    private static WebDriver driver;
    public EventFiringWebDriver eventdriver;
    private static final Logger LOGGER = LoggerFactory.getLogger(InvokeBrowser.class);

    @Before
    public void open() {
        if (driver == null) {
            startBrowser();
        }
    }

    public void startBrowser() {

        if (AutomationConstraints.BROWSER.equalsIgnoreCase("chrome")) {
            LOGGER.info("opening the chrome browser");

            if (AutomationConstraints.OS.equalsIgnoreCase("Mac OS")) {
                LOGGER.info("opening Browser in mac");
                System.setProperty("webdriver.chrome.driver", "src/test/binaries/drivers/chromedriver");
                eventdriver = new EventFiringWebDriver(new ChromeDriver());

            } else if (AutomationConstraints.OS.equalsIgnoreCase("Windows")) {
                LOGGER.info("opening the  browser in windows");
                System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
                eventdriver = new EventFiringWebDriver(new ChromeDriver());
            }
        } else if (AutomationConstraints.BROWSER.equalsIgnoreCase("firefox")) {
            LOGGER.info("opening firefox browser");

            if (AutomationConstraints.OS.equalsIgnoreCase("Mac OS")) {
                LOGGER.info("opening Browser in mac");
                System.setProperty("webdriver.gecko.driver", "src/test/binaries/drivers/geckodriver");
                eventdriver = new EventFiringWebDriver(new FirefoxDriver());

            } else if (AutomationConstraints.OS.equalsIgnoreCase("Windows")) {
                LOGGER.info("opening the  browser in windows");
                System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
                eventdriver = new EventFiringWebDriver(new FirefoxDriver());
            }

        } else if (AutomationConstraints.BROWSER.equalsIgnoreCase("opera")) {
            LOGGER.info("opening firefox browser");

            if (AutomationConstraints.OS.equalsIgnoreCase("Mac OS")) {
                LOGGER.info("opening Browser in mac");
                System.setProperty("webdriver.opera.driver", "src/test/binaries/drivers/operaChromiumDriver");
                eventdriver = new EventFiringWebDriver(new FirefoxDriver());

            } else if (AutomationConstraints.OS.equalsIgnoreCase("Windows")) {
                LOGGER.info("opening the  browser in windows");
                System.setProperty("webdriver.opera.driver", "operadriver.exe");
                eventdriver = new EventFiringWebDriver(new FirefoxDriver());
            }
        }
        eventdriver.get(AutomationConstraints.URL);


    }

    @After
    public void close() {
        eventdriver.quit();
    }
}
