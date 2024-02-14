package org.itfriendly.projectPages;

import org.itfriendly.core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.itfriendly.constants.Constatnt.Urls.SHOP_DEMO_URL;

public class MainPage extends BaseSeleniumPage {

    public MainPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@class=\"logo\"]")
    private WebElement logo;

    public void openPage(){
        driver.get(SHOP_DEMO_URL);
    }

    public String logoName(){
        waitForElementVisibility(logo);
        return logo.getText();
    }


}
