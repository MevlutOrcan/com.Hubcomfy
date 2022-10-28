package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US_016_017_Page {

    public US_016_017_Page(){

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[text()='Sign In']")
    public WebElement login;

    @FindBy(xpath = "//*[@id='username']")
    public WebElement userEmail;

    @FindBy(xpath = "//*[@id='password']")
    public WebElement pass;

    @FindBy(xpath = "(//*[text()='My Account'])[2]")
    public WebElement myAccount;

    @FindBy(xpath = "//*[text()='Store Manager']")
    public WebElement storeManager;

    @FindBy(xpath = "(//*[@class='text'])[7]")
    public WebElement customers;

    @FindBy(xpath = "//*[@id='wcfm-shop-customers']")
    public WebElement kisiListesi;

    @FindBy(xpath = "//*[text()='PDF']")
    public WebElement PDF;

    @FindBy(xpath = "//*[text()='Excel']")
    public WebElement Excel;

    @FindBy(xpath = "//*[text()='CSV']")
    public WebElement CSV;

    @FindBy(xpath = "//*[@class='add_new_wcfm_ele_dashboard text_tip']")
    public WebElement addNew;

    @FindBy(xpath = "//*[@id='user_name']")
    public WebElement Username;

    @FindBy(xpath = "//*[@id='user_email']")
    public WebElement email;

    @FindBy(xpath = "//*[@id='first_name']")
    public WebElement firstName;

    @FindBy(xpath = "//*[@id='last_name']")
    public WebElement lastName;

    @FindBy(xpath = "//*[@id='wcfm_customer_submit_button']")
    public WebElement submitButton;

    @FindBy(xpath = "//*[@class='sorting_1']")
    public List<WebElement> customerList;

    @FindBy(xpath = "//*[@id='same_as_billing']")
    public WebElement sameAsBilling;

    @FindBy(xpath = "//*[@id='sfirst_name']")
    public WebElement sfirstName;

}
