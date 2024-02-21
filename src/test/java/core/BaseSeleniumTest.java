package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.itfriendly.core.BaseSeleniumPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.itfriendly.common.Config.*;
import static org.itfriendly.constants.Constatnt.TimeoutVariables.IMPLISITY_WAIT;
import static org.itfriendly.constants.Constatnt.TimeoutVariables.PAGELOAD_WAIT;

/**
 * это базовый класс, который настраивает и запускает всё.
 */

abstract public class BaseSeleniumTest {
    protected WebDriver driver;



    //    @BeforeClass
//    public void setUp() {

//
//        if (OS_NAME_FOR_GIT.equals("Linux")) {
//            driver = gitRunConfig(driver, BROWSER_NAME);
//        } else {
//            driver = chooseDriver(driver, BROWSER_NAME);
//        }
//
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGELOAD_WAIT));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLISITY_WAIT));
//        BaseSeleniumPage.setDriver(driver);
//
//    }


//    @AfterClass
//    public void tearDown() {
//        switch (BROWSER_NAME) {
//            case "CHROME" -> {
//                driver.close();
//                driver.quit();
//            }
//            case "FIREFOX" -> driver.quit();
//        }
//    }

}
