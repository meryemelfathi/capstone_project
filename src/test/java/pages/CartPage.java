package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    //Only this field need a constructor
    WebDriver driver;

    //Constructor for web driver
    //Constructor that will be automatically called as soon as the object of the class is created
    public CartPage(WebDriver driver) {this.driver = driver;
        PageFactory.initElements(driver, this);}

    //Identify elements which we want to use tests
    @FindBy(id = "updates_30999621206069")
    WebElement quantityCart;
    @FindBy(xpath = "//*[@id=\"shopify-section-cart\"]/section/form/div/div/div[2]/button/span")
    WebElement checkOutButton;
    @FindBy(name = "update")
    WebElement updateCartButton;



    //Actions which we want to do over elements
    public void clearQuantityCart() { quantityCart.clear();}
    public void selectQuantityCart(String arg1) {quantityCart.sendKeys(arg1);}
    public void clickUpdateCartButton() {updateCartButton.click();}
    public void clickCheckOutButton() {checkOutButton.click();}

}
