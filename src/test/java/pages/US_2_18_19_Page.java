package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US_2_18_19_Page {
    public US_2_18_19_Page(){
        PageFactory.initElements(Driver.getDriver(), this);

    }
    @FindBy(xpath = "(//*[.='Sign In'])[1]")
    public WebElement SignInButton;
    @FindBy(xpath = "//*[@id='username']")
    public WebElement emailBox;
    @FindBy(xpath = "//*[@id='password']")
    public WebElement passwordBox;
    @FindBy(xpath = "//*[@name='login']")
    public WebElement loginButton;
    @FindBy(xpath = "(//a[@href=\"https://hubcomfy.com/my-account-2/\"])[1]")
    public WebElement myAccountButton;
    @FindBy(xpath = "//h2[.='My Account']")
    public WebElement myAccountText;


    @FindBy(xpath = "//*[@class='icon-boxes-wrapper']/div/div")
    public List<WebElement> MyAccountAltindakiOrdersList;

    @FindBy(xpath = "//*[@class='woocommerce-MyAccount-navigation col-md-3 mb-8']/ul/li")
    public List<WebElement> DoshboardAltindakiList;

    @FindBy(xpath = "//*[.='Store Manager']")
    public WebElement storeManagerLink;

    @FindBy(xpath = "(//*[@class='text'])[8]")
    public WebElement RefundLink;

    @FindBy(xpath = "//*[@class='wcfm_dashboard_item_title']")
    public WebElement RequestID;

    @FindBy(xpath = "//*[@class='wcfm_dashboard_item_title transaction_order_id']")
    public WebElement OrderID;
    @FindBy(xpath = "//*[.='Wrong username or password.']")
    public WebElement invalidWrongText;


    @FindBy(xpath = "//tbody/tr/td[3]")
    public WebElement AmountFiyat;

    @FindBy(xpath = "//tbody/tr/td[4]")
    public WebElement UrunTipi;

    @FindBy(xpath = "//tbody/tr/td[5]")
    public WebElement ReasonSebebi;

}
