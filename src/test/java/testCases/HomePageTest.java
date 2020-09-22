package testCases;

import configuration.FramworkConfig;
import driverManager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTest {
    WebDriver driverInstance = DriverManager.getDriverInstance();

    HomePage homePage = new HomePage(driverInstance);


    @BeforeSuite
    public void setUp() {
        driverInstance = DriverManager.getDriverInstance();
        driverInstance.get(FramworkConfig.getProperties("app.url"));
    }

    @Test(priority = 0)
    public void shopPhoneFilterTest() throws InterruptedException {
        driverInstance.manage().window().maximize();
        homePage.clickOnShop();
        homePage.clickOnPhones();
//        homePage.clickOnSamsungCB();
        homePage.clickOnLGCB();
        homePage.clickOnHuaweiCB();
        homePage.clickOnMotorolaCB();
        homePage.clickOnLimited_Time_OffersCB();
        homePage.clickOnClearanceCB();

        homePage.clickOnSmart_PhonesCB();

        homePage.clickOnCertified_Pre_OwnedCB();
//        homePage.clickOnResetAllFilterCB();
    }


    @Test(priority = 1)
    public void motoViewDetailsTest() throws InterruptedException {
        homePage.clickOnMoto_g7_playViewDetails();
        homePage.clickOnGetStarted();

        sleep(5000);
        driverInstance.navigate().back();
    }

    @Test(priority = 2)
    public void huaweiViewDetailsTest(){
        homePage.clickOnHuawei_P30_liteViewDetails();
    }



    @AfterSuite
    public void tearDown() throws InterruptedException {
        Thread.sleep(8000);

//        driverInstance.quit();

    }

    public void sleep(long second) throws InterruptedException {
        Thread.sleep(second);
    }


}
