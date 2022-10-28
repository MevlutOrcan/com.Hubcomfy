package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US_20_21_22_Page {

    public US_20_21_22_Page(){

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//*[@class='login inline-type']")
    public WebElement signInButtonum;

    @FindBy (xpath = "//*[@id='username']")
    public WebElement userNameEmail;

    @FindBy (xpath = "//*[@id='password']")
    public WebElement passwordHub;


    @FindBy (xpath = "//*[@name='login']")
    public WebElement signIn;

    @FindBy (xpath = "//*[@href='https://hubcomfy.com/my-account-2/']")
    public WebElement myAccount;

    @FindBy (xpath = "//*[@href='https://hubcomfy.com/store-manager/']")
    public WebElement storeManager;

    @FindBy (xpath = "(//*[@class='text'])[16]")
    public WebElement reviews;

    @FindBy (xpath = "//*[text()='Product Reviews']")
    public WebElement productReviews;

    @FindBy (xpath = "//tr//td[2]")
    public List<WebElement> authors;

    @FindBy (xpath = "//tr//td[3]")
    public List<WebElement> comments;

    @FindBy (xpath = "//tr//td[4]")
    public List<WebElement> raiting;

    @FindBy (xpath = "//tr//td[6]")
    public List<WebElement> commentDate;

    @FindBy (xpath = "(//*[@class='text'])[14]")
    public WebElement reports;

    @FindBy (xpath = "//*[text()='Year']")
    public WebElement yearReport;

    @FindBy (xpath = "//*[@id='wcfm_reports_sales_by_date_expander']")
    public WebElement numbersOfYear;

    @FindBy (xpath = "//*[text()='Last Month']")
    public WebElement lastMonth;

    @FindBy (xpath = "//*[@id='wcfm_reports_sales_by_date_expander']")
    public WebElement numbersOfLastMonth;

    @FindBy (xpath = "//*[text()='This Month']")
    public WebElement thisMonth;

    @FindBy (xpath = "//*[@id='wcfm_reports_sales_by_date_expander']")
    public WebElement numbersOfThisMonth;

    @FindBy (xpath = "//*[text()='Last 7 Days']")
    public WebElement last7Days;

    @FindBy (xpath = "//*[@id='wcfm_reports_sales_by_date_expander']")
    public WebElement numbersOfLast7Days;

    @FindBy (xpath = "//*[@name='wcfm-date-range']")
    public WebElement chooseDateRange;

    @FindBy (xpath = "//*[@value='Close']")
    public WebElement customDateClose;

    @FindBy (xpath = "//*[@id='wcfm_reports_sales_by_date_expander']")
    public WebElement customDateAllTable;

    @FindBy (xpath = "(//*[@href='https://hubcomfy.com'])[1]")
    public WebElement homeMyAccount;

    @FindBy (xpath = "(//*[@href='/shop/'])[2]")
    public WebElement shopNowLink;

    @FindBy (xpath = "//*[@name='orderby']")
    public WebElement sortByLink;

    @FindBy (xpath = "//form//select//option")
    public List<WebElement> sortByUrunlerList;

    @FindBy (xpath = "(//form//select//option)[1]")
    public WebElement sortBy_DefaultSorting;

    @FindBy (xpath = "(//form//select//option)[2]")
    public WebElement sortBy_SortByPopularity;

    @FindBy (xpath = "(//form//select//option)[3]")
    public WebElement sortBy_SortByAverageRating;

    @FindBy (xpath = "(//form//select//option)[4]")
    public WebElement sortBy_SortByLatest;

    @FindBy (xpath = "(//form//select//option)[5]")
    public WebElement sortBy_PriceLowToHigh;

    @FindBy (xpath = "(//form//select//option)[6]")
    public WebElement sortBy_PriceHighToLow;

    @FindBy (xpath = "//li//div[@class='product-details']")
    public List<WebElement> productDetailsHomePageList;

    @FindBy (xpath = "//span[@class='price']")
    public List<WebElement> productPricesHomePageList;



}
