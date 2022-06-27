package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailPage {

    //Only this field need a constructor
    WebDriver driver;

    //Constructor for web driver
    //Constructor that will be automatically called as soon as the object of the class is created
    public ProductDetailPage(WebDriver driver) {this.driver = driver;PageFactory.initElements(driver, this);}



    @FindBy(xpath = "//*[@id=\"bcpo-select-option-0\"]/div[2]/label")
    WebElement productSize;
    @FindBy(xpath = " //*[@id=\"bcpo-select-option-0\"]/div[3]/label")
    WebElement productSize2;

    @FindBy(css= "#alexnova-btn-cont-id > div")
    WebElement buyNow;
    @FindBy(xpath = "//*[@id=\"shopify-section-product\"]/section/div/div[3]/div/p/span[1]")
    WebElement productPrice;
    @FindBy(xpath = "//*[@id=\"product_form_4313722716213\"]/div[4]/input")
    WebElement addToCartButton;

    @FindBy(xpath ="//*[@id=\"product_form_2496766902329\"]/div[4]/input")
    WebElement addToCartMessage;

    @FindBy(xpath= "//*[@id=\"bcpo-select-option-1\"]/div[1]/label")
    WebElement productColor;
    @FindBy(className= "cart-count-number")
    WebElement cartCount;
    @FindBy(css= "#ispbxii_1")
    WebElement productQuantity;






    public void clickProductSize() {productSize.click();}
    public void clickBuyNow() {buyNow.click();}
    public boolean productPriceIsDisplayed() {return productPrice.isDisplayed();}
    public boolean buyNowIsEnabled() {return buyNow.isEnabled();}
    public void clickAddToCartButton() {addToCartButton.click();}
    public String getAddToCartMessage() {return addToCartMessage.getText();}
    public String getCartCount() {return cartCount.getText();}
    public void clickCartCount() {cartCount.click();}
    public String getProductQuantity() {return productQuantity.getAttribute("value");}
    public  void selectProductQuantity(String arg1) {productQuantity.sendKeys(arg1);}
    public void selectProductColor() {productColor.click();}
}
