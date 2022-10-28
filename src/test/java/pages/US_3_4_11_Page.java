package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US_3_4_11_Page {
    public US_3_4_11_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[.='Sign In']")
    public WebElement SignInButton;

 @FindBy(xpath = "//td[@class=\"product-name\"]")
    public List<WebElement> productListInTheCartPage;



    @FindBy(css = "#password")
    public WebElement passwordBox;

    @FindBy(css = "button[name=\"login\"]")
    public WebElement loginButton;

    @FindBy(css = "#menu-item-1066")
    public WebElement myOrderButton;

    @FindBy(xpath = "(//a[@href=\"https://hubcomfy.com/shop/\"])[1]")
    public WebElement goShopButton;
    //ikisinin de locate i ayni
    @FindBy(xpath = "(//a[@href=\"https://hubcomfy.com/shop/\"])[1]")
    public WebElement browseOrders;

    @FindBy(xpath = "//a[@class=\"btn btn-dark btn-rounded btn-icon-left continue-shopping mb-4 mr-auto\"]")
    public WebElement continueShoppingButton;

 @FindBy(xpath = "(//div[@class=\"quantity-wrapper\"])[1]")
    public WebElement quantitiyOfFirstProductInCartPage;


    @FindBy(xpath = "//a[class='btn-product-icon product_type_simple add_to_cart_button ajax_add_to_cart']")
    public List<WebElement> addProductsInTheShopPage;

    @FindBy(xpath = "//figure[@class='product-media']")
    public List<WebElement> productsInTheShopPage;

     @FindBy(xpath = "//h3[@class=\"woocommerce-loop-product__title\"]")
    public List<WebElement> productsNamesInTheShopPage;

@FindBy(xpath = "//button[@class=\"quantity-plus w-icon-plus\"]")
    public WebElement plusButton;

@FindBy(xpath = "//button[@class=\"quantity-minus w-icon-minus\"]")
    public WebElement minusButton;



    @FindBy(xpath = "(//span[@class=\"cart-count\"])[1]")
    public WebElement productSizeInTheCart;

    @FindBy(xpath = "//*[.='View cart']")
    public WebElement viewCartButtonInAProductPage;

@FindBy(xpath = "//p[@class=\"stock in-stock\"]")
    public WebElement stockAmount;


    @FindBy(css = "button[class=\"single_add_to_cart_button button alt\"]")
    public WebElement addToCartButton;

    @FindBy(xpath = "//*[@class=\"input-text qty text\"]")
    public WebElement tableOnCartPage;

@FindBy(xpath = "(//bdi)[4]")
    public WebElement subtotal;

@FindBy(xpath = "//div[@class=\"woocommerce-message alert alert-simple alert-icon alert-close-top alert-success\"]")
    public WebElement cartUpdatedText;

@FindBy(xpath = "(//input[@class=\"form-control\"])[1]")
    public WebElement searchBox;


    @FindBy(css = "button[class=\"single_add_to_cart_button button alt\"]")
    public List<WebElement> addToCartButtonList;


    @FindBy(css = "div[class=\"woocommerce-message alert alert-simple alert-btn alert-success\"]")
    public List<WebElement> addToCartSuccessText;

    @FindBy(xpath = "(//i[@class=\"w-icon-cart\"])[1]")
    public List<WebElement> cartButton;

    @FindBy(xpath = "(//a[@href=\"https://hubcomfy.com/cart/\"])[2]")
    public List<WebElement> viewCartButtonOnRightSide;

    @FindBy(xpath = "(//*[@class=\"cart-title\"])[2]")
    public List<WebElement> cartTotalsText;

    @FindBy(css = "button[name=\"clear_cart\"]")
    public WebElement clearCartButton;


    @FindBy(css = "button[name=\"update_cart\"]")
    public WebElement updateCartButton;

    @FindBy(css = "button[name=\"calc_shipping\"]")
    public WebElement updateTotalsButton;
 @FindBy(xpath = "li[id=\"select2-billing_state-result-gzxw-TR05\"]")
    public WebElement amasya;

 @FindBy(xpath = "//input[@id=\"billing_phone\"]")
    public WebElement phonePhone;

 @FindBy(xpath = "(//span[@class=\"selection\"])[2]")
    public WebElement province;

@FindBy(xpath = "//i[@class=\"fas fa-check\"]")
    public WebElement doneOrder;



    @FindBy(css = "a[class=\"checkout-button button alt wc-forward\"]")
    public WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//*[.='Coupon Discount']")
    public WebElement couponDiscountText;

    @FindBy(xpath = "//*[.='Billing details']")
    public WebElement billingDetailText;

    @FindBy(xpath = "//div[@class=\"woocommerce-message alert alert-simple alert-icon alert-close-top alert-success\"]")
    public WebElement cartClearedtext;



    @FindBy(xpath = "//input[@id=\"billing_first_name\"]")
    public WebElement billingFirstName;

    @FindBy(css = "#place_order")
    public WebElement placeOrderButton;

    @FindBy(css = "#menu-item-1079")
    public WebElement myAccountButton;

    @FindBy(xpath = "(//select)[1]")
    public WebElement countrySelect;


@FindBy(xpath = "//select[@name=\"billing_state\"]")
    public WebElement citySelect;

@FindBy(xpath = "(//select)[2]")
    public WebElement provinceSelec;



@FindBy(xpath = "(//select[*])[2]")
    public WebElement provinceSelect;


    @FindBy(xpath = "(//a[@href=\"https://hubcomfy.com/my-account-2/orders/\"])[1]")
    public WebElement ordersButton;


    @FindBy(css = "p[class=\"woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received order-success\"]")
    public List<WebElement> orderRecievedText;

 @FindBy(css = "#billing_company")
    public WebElement companyBox;
@FindBy(css = "#billing_last_name")
    public WebElement lastNameBox;

@FindBy(xpath = "//*[@id=\"billing_address_1\"]")
    public WebElement adress1Box;

@FindBy(xpath = "//*[@id=\"billing_postcode\"]")
    public WebElement zipBox;

@FindBy(xpath = "//*[@id=\"billing_city\"]")
    public WebElement cityBox;

@FindBy(xpath = "//*[@id=\"billing_phone\"]")
    public WebElement phoneBox;

@FindBy(xpath = "//*[@id=\"billing_email\"]")
    public WebElement emailBox;

@FindBy(xpath = "(//input[@class=\"woocommerce-Input woocommerce-Input--text input-text\"])[1]")
    public WebElement signInEmailBox;

@FindBy(xpath = "//*[.='Store Manager']")
    public WebElement storeManagerButton;

@FindBy(xpath = "(//span[@class=\"text\"])[4]")
    public WebElement productsButton;

@FindBy(xpath = "(//*[.='Name'])[1]")
    public WebElement onTheProductPage;

@FindBy(xpath = "(//*[.='Add New'])[1]")
    public WebElement addNewButton;

@FindBy(xpath = "(//*[.='Toptan Ürün Gösterme Ayarları'])[2]")
    public WebElement toptanUrunGosterme;

@FindBy(xpath = "//select[@id=\"piecetype\"]")
    public WebElement pieceTypeDD;

@FindBy(xpath = "//input[@id=\"unitpercart\"]")
    public WebElement unitPerPieceBox;

@FindBy(xpath = "//input[@id=\"minorderqtytr\"]")
    public WebElement minOrderQuantityBox;

@FindBy(xpath = "//div[@id=\"wcfm_products_manage_form_toptan-urun-gosterme-ayarlari_expander\"]")
    public WebElement toptanUrunGostermeAyarlariTable;











}
