package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_8_9_12_Page {
    public US_8_9_12_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//*[text()='Sign In']")
    public WebElement signInButton;

    @FindBy (xpath = "//*[@id='username']")
    public WebElement emailBox;

    @FindBy (xpath = "//*[@id='password']")
    public WebElement passwordBox;

    @FindBy (xpath = "(//*[@type='submit'])[1]")
    public WebElement loginButton;

    @FindBy (xpath = "(//*[@href='https://hubcomfy.com/my-account-2/'])[1]")
    public WebElement myaccountButton;

    @FindBy (xpath = "//*[@href='https://hubcomfy.com/store-manager/']")
    public WebElement storeManager;

    @FindBy (xpath = "(//*[@class='text'])[4]")
    public WebElement Products;

    @FindBy (xpath = "(//*[@class='text'])[18]")
    public WebElement addNewProduct;

    @FindBy (xpath = "(//*[@class='page_collapsible_content_holder'])[1]")
    public WebElement inventoryButton;

    @FindBy (xpath = "//*[@id='sku']")
    public WebElement SKUButton;

    @FindBy (xpath = "//*[@id='stock_status']")
    public WebElement stockStatus;

    @FindBy (xpath = "//*[@id='manage_stock']")
    public WebElement manageStockButton;

    @FindBy (xpath = "//*[@id='stock_qty']")
    public WebElement stockQty;

    @FindBy (xpath = "//*[@id='backorders']")
    public WebElement allowBackorders;

    @FindBy (xpath = "class='wcfmfa fa-th-large'")
    public WebElement advanced;


    @FindBy (xpath = "(//*[@class='page_collapsible_content_holder'])[4]")
    public WebElement shipping;

    @FindBy (xpath = "//*[@id='weight']")
    public WebElement weight;

    @FindBy (xpath = "//*[@id='length']")
    public WebElement lenghtBox;

    @FindBy (xpath = "//*[@id='width']")
    public WebElement widhtBox;

    @FindBy (xpath = "//*[@id='height']")
    public WebElement heightBox;

    @FindBy (xpath = "//*[@id='_wcfmmp_processing_time']")
    public WebElement processingTime;

    @FindBy (xpath = "(//*[@href='https://hubcomfy.com/my-account-2/orders/'])[1]")
    public WebElement orders;

    @FindBy(xpath = "(//*[@class='nobr'])[1]")
    public WebElement ordersText;

    @FindBy (xpath = "//table")
    public WebElement ordersTable;

    @FindBy (xpath = "//*[@class='woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--downloads']")
    public WebElement downloads;

    @FindBy (xpath = "(//h4)[2]")
    public WebElement downloadsText;

    @FindBy (xpath = "(//p)[2]")
    public WebElement NoDownloadsAvaiblableYet;

    @FindBy (xpath = "//h4icon")
    public WebElement bulunamayan;

    @FindBy (xpath = "//*[@href='https://hubcomfy.com/my-account-2/edit-address/']")
    public WebElement addresses;

    @FindBy (xpath = "(//*[@href='https://hubcomfy.com/my-account-2/edit-address/'])[3]")
    public WebElement addressesText;

    @FindBy (xpath = "//*[text()='Billing address']")
    public WebElement billingAddress;

    @FindBy (xpath = "//*[text()='Shipping address']")
    public WebElement shippingAdress;

    @FindBy (xpath = "(//*[@href='https://hubcomfy.com/my-account-2/edit-account/'])[1]")
    public WebElement accountDetails;

    @FindBy (xpath = "//*[@class='icon-box-title text-normal']")
    public WebElement accountDetailsText;

    @FindBy (xpath = "//*[@id='account_first_name']")
    public WebElement accountFirstName;

    @FindBy (xpath = "//*[@id='account_last_name']")
    public WebElement accountLastName;

    @FindBy (xpath = "//*[@id='account_display_name']")
    public WebElement accountDisplayName;

    @FindBy (xpath = "//*[@id='account_email']")
    public WebElement accountEmail;

    @FindBy (xpath ="//*[contains(text(),'Account details changed successfully.')]")
    public WebElement kaybolanMesaj;

    @FindBy (xpath = "//*[@id='shipping_class']")
    public WebElement shippingClass;

    @FindBy (xpath = "//*[@id='password_current']")
    public WebElement passwordChange;

    @FindBy (xpath = "//*[@id='password_1']")
    public WebElement newPassword;

    @FindBy (xpath = "//*[@id='password_2']")
    public WebElement confirmPassword;

    @FindBy (xpath = "//*[@class='woocommerce-Button button btn btn-dark btn-rounded btn-sm']")
    public WebElement saveChanges;

    // kaybolan mesaji almak icin //*[contains(text(),'çıkan mesaj')]
}



     //*[contains(text(),'Account details changed successfully.')]
     //Account details changed successfully.