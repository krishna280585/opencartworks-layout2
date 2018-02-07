import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

public class LoadBrowser extends AutomationConstraints {
        public static WebDriver driver;

        @BeforeClass
        public static void openBrowser()

        {
            if (AutomationConstraints.BROWSER.equalsIgnoreCase("chrome"))
            {
                System.out.println("opening the Browser");
                System.setProperty("webdriver.chrome.driver", "chromedriver");
                driver = new ChromeDriver();

            }
            else if(AutomationConstraints.BROWSER.equalsIgnoreCase("firefox"))
            {
                System.setProperty("webdriver.gecko.driver", "geckodriver");
                driver = new FirefoxDriver();

            }
            else
                System.out.println("There is no browser to invoke");

        }
        @Test
        public void loadUrl()
        {
            driver.get("http://opencart.opencartworks.com/themes/so_emarket/layout2/");
        }

        @AfterClass
        public static void closeBrowser()
        {
            System.out.println("closing the browser");
             driver.quit();
        }

    }

