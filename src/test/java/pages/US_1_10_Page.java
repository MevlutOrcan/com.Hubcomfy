package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US_1_10_Page {
    public US_1_10_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//*[.='Register'])[1]")
    public WebElement register;
    @FindBy(xpath = "//*[@href='https://hubcomfy.com/vendor-register/']")
    public WebElement becomeAVendor;
    @FindBy(xpath = "(//h2)[1]")
    public WebElement vendorRegistration;
    @FindBy(xpath = "//*[@id='user_email']")
    public WebElement userEmail;
    @FindBy(xpath = "//*[@id='passoword']")
    public WebElement password;
    @FindBy(xpath = "(//*[@type='text'])[2]")
    public WebElement verificationCode;
    @FindBy(xpath = "(//*[@type='text'])[2]")
    public WebElement reSendCode;
    @FindBy(xpath = "//*[@id='wcfm_membership_register_button']")
    public WebElement emailBosHatasi;
    @FindBy(xpath = "(//*[@class='hidden-xs hidden-sm klikaciRadek newMail'])[1]")
    public WebElement eMailCode;
    @FindBy(xpath = "//*[@name='confirm_pwd']")
    public WebElement confirmPassword;
    @FindBy(xpath = "//*[@id='wcfm_membership_register_button']")
    public WebElement registerButton;
    @FindBy(xpath = "//*[@id='email']")
    public WebElement minutesMail;
    @FindBy(xpath = "//*[@id='wcfm_membership_registration_submit']")
    public WebElement inValidEMailText;
    @FindBy(xpath = "//*[.='Registration Successfully Completed.']")
    public WebElement validEMailText;
    @FindBy(xpath = "//*[.='Strong']")
    public WebElement strong;
    @FindBy(xpath = "//*[text()='This Email already exists. Please login to the site and apply as vendor.']")
    public WebElement alreadyExists;
    @FindBy(xpath = "//*[.='Welcome to Hubcomfy!']")
    public WebElement welcomeToHubcomfy;
    @FindBy(xpath = "//*[.='Password and Confirm-password are not same.']")
    public WebElement confirmPasswordErrorText;
    @FindBy(xpath = "(//*[.='Sign In'])[2]")
    public WebElement signIn;
    @FindBy(xpath = "//*[@id='username']")
    public WebElement userNameEmail;
    @FindBy(xpath = "//*[@id='password']")
    public WebElement passwordSignIn;
    @FindBy(xpath = "//*[@name='login']")
    public WebElement signInButton;
    @FindBy(xpath = "(//*[text()='My Account'])[2]")
    public WebElement myAccount;
    @FindBy(xpath = "//*[text()='Store Manager']")
    public WebElement storeManager;
    @FindBy(xpath = "(//*[@class='text'])[4]")
    public WebElement products;
    @FindBy(xpath = "(//*[.='Add New'])[1]")
    public WebElement addNew;
    @FindBy(xpath = "(//*[.='Attributes'])[1]")
    public WebElement attributes;
    @FindBy(xpath = "//*[@id='attributes_is_active_1']")
    public WebElement color;
    @FindBy(xpath = "//*[@id='attributes_is_active_2']")
    public WebElement size;
    @FindBy(xpath = "(//*[.='Select all'])[1]")
    public WebElement selectAllColor;
    @FindBy(xpath = "(//*[.='Select all'])[2]")
    public WebElement selectAllSize;
    @FindBy(xpath = "(//*[@class='select2-selection__rendered'])[2]")
    public WebElement colorBox;
    @FindBy(xpath = "//*[@class='select2-selection__choice']")
    public List<WebElement> allColorAndSize;
    @FindBy(xpath = "//*[@class='select2-results__option']")
    public List<WebElement> allColorList;

}