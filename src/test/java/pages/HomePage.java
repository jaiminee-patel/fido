package pages;

import driverManager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    WebDriver driverInstance = DriverManager.getDriverInstance();
    WebDriverWait wait = new WebDriverWait(driverInstance,30);

    @FindBy(css = "nav [class='o-navLinkList']>li:nth-child(1)")
    WebElement shop;

    @FindBy(css = "[class='o-headerNavDropdown -opened']>li:nth-child(1)")
    WebElement phones;

    @FindBy(xpath = "//label[contains(@for,'samsung')]/div[1]")
    WebElement Samsung;

    @FindBy(xpath = "//label[contains(@for,'apple')]/div[1]")
    WebElement Apple;

    @FindBy(xpath = "//label[contains(@for,'lg')]/div[1]")
    WebElement LG;

    @FindBy(xpath = "//label[contains(@for,'motorola')]/div[1]")
    WebElement Motorola;

    @FindBy(xpath = "//label[contains(@for,'huawei')]/div[1]")
    WebElement Huawei;

    @FindBy(xpath = "//label[contains(@for,'alcatel')]/div[1]")
    WebElement Alcatel;

    @FindBy(xpath = "//label[contains(@for,'limitedtimeoffer')]/div[1]")
    WebElement Limited_Time_Offers;

    @FindBy(xpath = "//label[contains(@for,'onsale')]/div[1]")
    WebElement onSale;

    @FindBy(xpath = "//label[contains(@for,'fidofaves')]/div[1]")
    WebElement Fido_Faves;

    @FindBy(xpath = "//label[contains(@for,'clearance')]/div[1]")
    WebElement Clearance;

    @FindBy(xpath = "//label[contains(@for,'smartphone')]/div[1]")
    WebElement Smart_Phones;

    @FindBy(xpath = "//label[contains(@for,'preowned')]/div[1]")
    WebElement Certified_Pre_Owned;

    @FindBy(xpath = "//span[contains(text(),'Reset all filters')]")
    WebElement reset_all_filter;

    @FindBy(xpath = "//a[contains(@title,'moto g7')]/span")
    WebElement Moto_g7_play_viewDetailBtn;

    @FindBy(xpath = "//a[contains(@title,'Huawei P30 lite')]/span")
    WebElement Huawei_P30_lite_viewDetailBtn;

    @FindBy(xpath = "//button[contains(@title,'Get started')]/span")
    WebElement getStartedBtn;


    public HomePage(WebDriver driverInstance) {
        this.driverInstance = driverInstance;
        PageFactory.initElements(driverInstance, this);
    }

    public HomePage clickOnShop(){
        wait.until(ExpectedConditions.elementToBeClickable(shop));
        shop.click();
        return this;
    }

    public void clickOnPhones(){
        wait.until(ExpectedConditions.elementToBeClickable(phones));
        phones.click();
    }

    public HomePage clickOnSamsungCB(){
        wait.until(ExpectedConditions.elementToBeClickable(Samsung));

        Samsung.click();
        return this;
    }

    public void clickOnAppleCB(){
        Apple.click();
    }

    public HomePage clickOnLGCB(){
        wait.until(ExpectedConditions.elementToBeClickable(LG));
        LG.click();
        return this;
    }

    public void clickOnMotorolaCB(){
        Motorola.click();
    }

    public void clickOnHuaweiCB(){
        Huawei.click();
    }
    public void clickOnAlcatelCB(){
        Alcatel.click();
    }

    public void clickOnLimited_Time_OffersCB(){
        Limited_Time_Offers.click();
    }

    public void clickOnFido_FavesCB(){
        Fido_Faves.click();
    }

    public void clickOnClearanceCB(){
        Clearance.click();
    }

    public void clickOnSmart_PhonesCB(){
        Smart_Phones.click();
    }

    public void clickOnCertified_Pre_OwnedCB(){
        Certified_Pre_Owned.click();
    }

    public void clickOnResetAllFilterCB(){
        reset_all_filter.click();
    }



    public void clickOnMoto_g7_playViewDetails(){
        wait.until(ExpectedConditions.elementToBeClickable(Moto_g7_play_viewDetailBtn));
        Moto_g7_play_viewDetailBtn.click();
    }

    public void clickOnHuawei_P30_liteViewDetails(){
        wait.until(ExpectedConditions.elementToBeClickable(Huawei_P30_lite_viewDetailBtn));
        Huawei_P30_lite_viewDetailBtn.click();
    }

    public void clickOnGetStarted(){
        getStartedBtn.click();
    }


    public void sleep(long second) throws InterruptedException {
        Thread.sleep(second);
    }



}
