package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.itfriendly.core.BaseSeleniumPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

import static org.itfriendly.common.Config.*;

import static org.itfriendly.constants.Constatnt.TimeoutVariables.IMPLISITY_WAIT;
import static org.itfriendly.constants.Constatnt.TimeoutVariables.PAGELOAD_WAIT;

/**
 * это базовый класс, который настраивает и запускает всё.
 */

abstract public class BaseSeleniumTest {
    protected static WebDriver driver;


    @BeforeClass
    public void setUp() {

        //   WebDriverManager.chromedriver().driverVersion("121").setup();
        if (!OS_NAME_FOR_GIT.equals("Linux")){
          //  System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
           WebDriverManager.chromedriver().driverVersion("121").setup();
            File file = new File("src/main/resources/file.txt");
            System.out.println(file.getPath());
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
            System.out.println(OS_NAME_FOR_GIT);
        }else {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGELOAD_WAIT));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLISITY_WAIT));
            driver.manage().window().maximize();
        }
        BaseSeleniumPage.setDriver(driver);
    }

    @AfterClass
    public void tearDown() {
        switch (BROWSER_NAME) {
            case "CHROME" -> {
                driver.close();
                driver.quit();
            }
            case "FIREFOX" -> driver.quit();
        }
    }

}
