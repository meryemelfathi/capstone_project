package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {

    WebDriver driver;

    //Constructor for web driver
    //Constructor that will be automatically called as soon as the object of the class is created
    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath ="/html/body/div[1]/div/div/header/nav/ol/li[3]")
    WebElement paymentLabel;
    @FindBy(id ="checkout_reduction_code")
    WebElement giftCardTxt;
    @FindBy(id ="checkout_submit")
    WebElement giftCardBtn;
    @FindBy(xpath="//*[@id=\"order-summary\"]/div/div[2]/div/div/form/div/span/span/span")
    WebElement giftCardLabel;
    @FindBy(id="checkout_payment_gateway_66130411573")
    WebElement shopByOptions;
    @FindBy(id="checkout_payment_gateway_14059175993")
    WebElement payPalOption;
    @FindBy(id="checkout_payment_gateway_14059208761")
    WebElement creditCardOption;

    @FindBy(linkText ="Log in")
    WebElement logIn;
    @FindBy(id ="checkout_shipping_address_address1")
    WebElement shippingAddressTxt;
    @FindBy(id ="checkout_shipping_address_city")
    WebElement shippingAddressCity;
    @FindBy(id ="checkout_shipping_address_zip")
    WebElement shippingAddressZipTxt;

    @FindBy(id ="continue_button")
    WebElement contBtn;
    @FindBy(id ="error-for-address1")
    WebElement errorAddressMsg;

    @FindBy(id ="error-for-city")
    WebElement errorCityMessage;
    @FindBy(id ="error-for-zip")
    WebElement errorZipMessage;

    @FindBy(id ="main-header")
    WebElement paymentLabel2;
    @FindBy(css="#continue_button > span")
    WebElement payNowButton;
    @FindBy(id="checkout_email")
    WebElement checkOutEmail;
    @FindBy(id="checkout_shipping_address_first_name")
    WebElement checkOutFName;
    @FindBy(id="checkout_shipping_address_last_name")
    WebElement checkOutLName;


    //rename
    public String getPaymentLabel() {return paymentLabel.getText();}
    public void selectGiftCardText(String fArg) {giftCardTxt.sendKeys(fArg);}
    public void selectCheckOutEmail(String fArg) {checkOutEmail.sendKeys(fArg);}
    public void clearCheckOutEmail() {checkOutEmail.clear();}
    public void selectCheckOutFName(String fArg) {checkOutFName.sendKeys(fArg);}
    public void clearCheckOutFName() {checkOutFName.clear();}
    public void selectCheckOutLName(String fArg) {checkOutLName.sendKeys(fArg);}
    public void clearCheckOutLName() {checkOutLName.clear();}
    public void selectShippingAddressText(String fArg) {shippingAddressTxt.sendKeys(fArg);}
    public void clearShippingAddressText() {shippingAddressTxt.clear();}
    public boolean errorAddressMessageIsDisplayed() {return errorAddressMsg.isDisplayed();}
    public void selectShippingAddressCityText(String fArg) {shippingAddressCity.sendKeys(fArg);}
    public void clearShippingAddressCityText() {shippingAddressCity.clear();}
    public boolean errorCityMessageIsDisplayed() {return errorCityMessage.isDisplayed();}
    public void selectShippingAddressZipText(String fArg) {shippingAddressZipTxt.sendKeys(fArg);}
    public void clearShippingAddressZipText() {shippingAddressZipTxt.clear();}
    public boolean errorZipMessageIsDisplayed() {return errorZipMessage.isDisplayed();}
    public void clickGiftCardButton() {giftCardBtn.click();}
    public void clickContButton() {contBtn.click();}
    public boolean giftCardLabelIsDisplayed() {return giftCardLabel.isDisplayed();}
    public boolean shopByOptionIsDisplayed() {return shopByOptions.isDisplayed();}
    public boolean payPalOptionIsDisplayed() {return payPalOption.isDisplayed();}
    public boolean creditCardOptionIsDisplayed() {return creditCardOption.isDisplayed();}
    public boolean payNowButtonIsDisplayed() {return payNowButton.isDisplayed();}
    public void clickLogIn() {logIn.click();}
    public boolean paymentLabel2IsDisplayed() {return paymentLabel2.isDisplayed();}
}
