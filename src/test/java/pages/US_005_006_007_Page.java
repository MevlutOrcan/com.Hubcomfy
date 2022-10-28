package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;


import java.util.List;

public class US_005_006_007_Page {
    public US_005_006_007_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//*[.='Sign In'])[1]")
    public WebElement HomesignInButton;

    @FindBy(xpath = "//*[@id='username']")
    public WebElement userNameTextBox;

    @FindBy(xpath = "//*[@id='password']")
    public WebElement passwordTextBox;

    @FindBy(xpath = "//*[@name='login']")
    public WebElement kullaniciGirisSignIn;

    @FindBy(xpath = "(//*[.='My Account'])[2]")
    public WebElement myAccountLink;

    @FindBy(xpath = "//*[.='Store Manager']")
    public WebElement storeManagerLink;

    @FindBy(xpath = "//div/a[@href='https://hubcomfy.com/store-manager/products/']")
    public WebElement productsLink;

    @FindBy(xpath = "//thead/tr/th")
    public List<WebElement> urunListesiBasliklari;

    @FindBy(xpath = "//*[@id='add_new_product_dashboard']")
    public WebElement productsAddNewButton;

    @FindBy(xpath = "//*[@name='is_virtual']")
    public WebElement virtualSecenegi;

    @FindBy(xpath = "//*[@name='is_downloadable']")
    public WebElement downloadableSecenegi;

    @FindBy(xpath = "//*[@id='pro_title']")
    public WebElement productTitle;

    @FindBy(xpath = "//*[@id='regular_price']")
    public WebElement priceTextBox;

    @FindBy(xpath = "//*[@id='sale_price']")
    public WebElement salePriceTextBox;

    @FindBy(xpath = "//*[@id='featured_img_display']")
    public WebElement imageLogosu;

    @FindBy(xpath = "(//*[@id='menu-item-browse'])[2]")
    public WebElement mediaLibraryButton;



    @FindBy(xpath = "(//*[@class='thumbnail'])[1]")
    public WebElement eklenenFoto;

    @FindBy(xpath = "//*[@aria-checked='true']")
    public WebElement fotoUzerindekiTikIsareti;

    @FindBy(xpath = "(//div/div/div/div/div/div/button[@type='button'])[77]")
    public WebElement chooseImageSelectButton;
    @FindBy(xpath = "//*[@src='https://hubcomfy.com/wp-content/uploads/2022/10/silah.jpg']")
    public WebElement urunFotosuEklemeyiDogrulama;

    @FindBy(xpath = "//*[@data-id='description']")
    public WebElement descriptionTextBox;

    @FindBy(xpath = "//*[@data-id='excerpt']")
    public WebElement shortDescriptionTextBox;

    @FindBy(xpath = "//*[@id='product_cats_checklist']/li")
    public List<WebElement> categoriesList;

    @FindBy(xpath = "//*[@id='product_brand']/li")
    public List<WebElement> productBrandsList;

    @FindBy(xpath = "//*[@data-super_parent='413']")
    public WebElement categoriesBesinTakviyeleri;

    @FindBy(xpath = "//*[@data-super_parent='225']")
    public WebElement categoriesCokSatanlar;

    @FindBy(xpath = "(//*[@class='wcfmfa fa-arrow-circle-right sub_checklist_toggler'])[9]")
    public WebElement categoriesElectronicsDropDown;

    @FindBy(xpath = "(//*[@class='wcfmfa fa-arrow-circle-right sub_checklist_toggler'])[17]")
    public WebElement categoriesHomeAndGardenDropDown;

    @FindBy(xpath = "(//*[@class='wcfmfa fa-arrow-circle-right sub_checklist_toggler'])[6]")
    public WebElement categoriesBooksMusicFilmDropDown;

    @FindBy(xpath = "(//*[@class='wcfmfa fa-arrow-circle-right sub_checklist_toggler'])[16]")
    public WebElement categoriesHealthBeauty;

    @FindBy(xpath = "//*[@data-super_parent='344']")
    public WebElement categoriesFashion;

    @FindBy(xpath = "//*[@data-super_parent='399']")
    public WebElement categoriesClothing;

    @FindBy(xpath = "//*[@data-super_parent='233']")
    public WebElement categoriesToysAndGames;

    @FindBy(xpath = "(//*[@class='wcfmfa fa-arrow-circle-right sub_checklist_toggler'])[1]")
    public WebElement categoriesAccessories;

    @FindBy(xpath = "//*[@data-super_parent='226']")
    public WebElement categoriesNewArrivals;

    @FindBy(xpath = "//*[@data-super_parent='35']")
    public WebElement brandsElegantAutoGroup;

    @FindBy(xpath = "(//*[@class='wcfmfa fa-arrow-circle-right sub_checklist_toggler'])[48]")
    public WebElement brandsGreenGrass;

    @FindBy(xpath = "(//*[@class='wcfmfa fa-arrow-circle-right sub_checklist_toggler'])[56]")
    public WebElement brandsNodeJS;

    @FindBy(xpath = "//*[@data-super_parent='47']")
    public WebElement brandsNS8;

    @FindBy(xpath = "(//*[@class='wcfmfa fa-arrow-circle-right sub_checklist_toggler'])[62]")
    public WebElement brandsRed;

    @FindBy(xpath = "//*[@data-super_parent='52']")
    public WebElement brandsSkysuiteTech;

    @FindBy(xpath = "//*[@data-super_parent='55']")
    public WebElement brandsSterling;





















}
