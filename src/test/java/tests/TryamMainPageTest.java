package tests;

import core.BaseSeleniumTest;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.itfriendly.projectPages.MainPage;

import static org.itfriendly.constants.Constatnt.LinkSectionsElement.*;
import static org.itfriendly.constants.Constatnt.LinksSectionNames.*;
import static org.itfriendly.constants.Constatnt.NamesOfManePage.LOGONAME;
import static org.itfriendly.constants.Constatnt.Urls.SHOP_DEMO_URL;

@Ignore

public class TryamMainPageTest extends BaseSeleniumTest {

    @Test
    public void openPageTest(){
        MainPage mainPage = new MainPage(SHOP_DEMO_URL);
        Assert.assertEquals(mainPage.logoName(),LOGONAME);
    }

    @Test
    public void linkSectionNumberOfElementsTest(){
        MainPage mainPage = new MainPage(SHOP_DEMO_URL);
        Assert.assertEquals(mainPage.listElementsSize(),COUNT_ELEMENTS);
        Assert.assertEquals(mainPage.listElements(0),CONTACT_ELEMENT_NAME);
        Assert.assertEquals(mainPage.listElements(1),SELLWITHUS_ELEMENT_NAME);
        Assert.assertEquals(mainPage.listElements(2),SHIPPING_ELEMENT_NAME);
    }

    @Test
    public void contackUsLinkTest(){
      MainPage mainPage = new MainPage(SHOP_DEMO_URL);
      Assert.assertTrue(mainPage.checkLinkIsLinkAndClicable(mainPage.getContuctUsLink()));
      Assert.assertTrue(mainPage.checkOpenedLinkBodyAtribute(mainPage.getContuctUsLink())
              .toLowerCase()
              .contains(CONTACT));
    }

    @Test
    public void sellWithUsLinkTest() {
        Assert.assertTrue(new MainPage(SHOP_DEMO_URL)
                .checkLinkIsLinkAndClicableV2(SELLWITHUS));
    }

    @Test
    public void sellWithUsLinkTestV2() {
       Assert.assertTrue(new MainPage(SHOP_DEMO_URL)
               .checkPageBody()
               .bodyName()
               .toLowerCase()
               .contains("sell") );
    }

    @Test
    public void shippingUrlTest(){
        MainPage mainPage = new MainPage(SHOP_DEMO_URL);
        Assert.assertTrue(mainPage.checkLinkIsLinkAndClicableV2(SHIPPING));
        Assert.assertFalse(mainPage.checkOpenedLinkBodyAtribute(mainPage.getSellWithUsLink())
                .toLowerCase()
                .contains(SHIPPING));
    }
}
