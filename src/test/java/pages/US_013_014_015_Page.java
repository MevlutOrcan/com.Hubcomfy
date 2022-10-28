package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US_013_014_015_Page {
    public US_013_014_015_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[text()='Sign In']")
    public WebElement signInLink;

    @FindBy(xpath = "//*[@id='username']")
    public WebElement emailBox;

    @FindBy(xpath = "//*[@id='password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//*[@value='Sign In']")
    public WebElement signInButton;

    @FindBy(xpath = "(//*[text()='My Account'])[2]")
    public WebElement myAccountLink;

    @FindBy(xpath = "//*[text()='Store Manager']")
    public WebElement storeManagerTab;

    @FindBy(xpath = "(//*[text()='Store Manager'])[1]")
    public WebElement storeManagerText;

    @FindBy(xpath = "(//*[@class='text'])[6]")
    public WebElement couponsTab;

    @FindBy(xpath ="//*[text()='Coupons Listing']")
    public WebElement couponsListingText;

    @FindBy(xpath = "(//*[text()='Add New'])[1]")
    public WebElement addNewButton;

    @FindBy(xpath ="//*[text()='Add Coupon']")
    public WebElement addCouponText;

    @FindBy(xpath = "//*[@id='title']")
    public WebElement codeBox;

    @FindBy(xpath = "//tbody/tr/td[1]")
    public WebElement couponCodeData;

    @FindBy(xpath = "//*[@id='description']")
    public WebElement descriptionBox;

    @FindBy(xpath = "//*[text()='New Member']")
    public WebElement newMemberText;

    @FindBy(xpath = "//*[@id='discount_type']")
    public WebElement discountTypeBox;

    @FindBy(xpath = "//*[@name='submit-data']")
    public WebElement submitButton;

    @FindBy(xpath = "//*[@data-tip='Edit']")
    public WebElement editButton;

    @FindBy(xpath = "//*[@name='coupon_amount']")
    public WebElement couponAmountBox;

    @FindBy(xpath = "//tbody/tr/td[3]")
    public WebElement couponAmountData;

    @FindBy(xpath = "//*[@name='expiry_date']")
    public WebElement expiryDateBox;


    @FindBy(xpath = "(//*[@type='checkbox'])[1]")
    public WebElement allowFreeShippingCheckBox;

    @FindBy(xpath = "(//*[@type='checkbox'])[2]")
    public WebElement showOnStoreCheckbox;


    //*************Restriction Tab********************
    @FindBy(xpath = "//*[@id='minimum_amount']")
    public WebElement minimumSpendBox;

    @FindBy(xpath = "//*[@id='maximum_amount']")
    public WebElement maximumSpendBox;

    @FindBy(xpath = "(//*[@type='checkbox'])[3]")
    public WebElement individualUseOnlyCheckbox;

    @FindBy(xpath = "(//*[@type='checkbox'])[4]")
    public WebElement excludeSaleItemsCheckbox;

    @FindBy(xpath = "(//*[@role='textbox'])[4]")
    public WebElement excludeCategoriesBox;

    @FindBy(xpath = "//*[@class='select2-results__option']")
    public List<WebElement> excludeCategoriesList;

    @FindBy(xpath = "(//*[text()='  Ring'])[3]")
    public WebElement ring;

    @FindBy(xpath = "(//*[@value='229'])[2]")
    public WebElement accessories;

    @FindBy(xpath = "//*[@class='select2-selection__choice']")
    public List<WebElement> excludeCategoriesSelects;

    //*************Limit Tab********************
    @FindBy(xpath = "//*[@id='coupons_manage_limit']")
    public WebElement limitTab;

    @FindBy(xpath = "//*[@id='usage_limit']")
    public WebElement usageLimitPerCouponBox;

    @FindBy(xpath = "//*[@value='100']")
    public WebElement usageLimitPerCouponText;

    @FindBy(xpath = "//*[@id='limit_usage_to_x_items']")
    public WebElement limitUsageToXItemsBox;

    @FindBy(xpath = "//*[@value='3']")
    public WebElement limitUsageToXItemsText;

    @FindBy(xpath = "//*[@id='usage_limit_per_user']")
    public WebElement usageLimitPerUserBox;

    @FindBy(xpath = "//*[@value='2']")
    public WebElement usageLimitPerUserText;

    @FindBy(xpath = "(//*[@href='https://hubcomfy.com/store-manager/coupons-manage/16270'])[1]")
    public WebElement coupon;





















}
