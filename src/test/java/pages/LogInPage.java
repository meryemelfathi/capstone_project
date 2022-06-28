package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {

    //Only this field need a constructor
    WebDriver driver;


    //Constructor for web driver
    //Constructor that will be automatically called as soon as the object of the class is created
    public LogInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    // here we identify elements which we want to use tests

    //Locator for Email field
    @FindBy(linkText = "My account")
    WebElement myAccountLink;
    By yourEmail = By.id("ispbxii_1");

    //Locator for password field
    By yourPassword = By.xpath("//*[@id=\"customer_login\"]/div[2]/input");

    //
    By login = By.xpath("//*[@id=\"customer_login\"]/div[3]/input");
    @FindBy(xpath="//div[@class='customer-links-inner']/ul/li[3]/a")

    WebElement logOutLink;


    //Here we create actions which we want to do over elements

    public void enterYourEmail(String yEmail) { driver.findElement(yourEmail).sendKeys(yEmail);}
    public void enterYourPassword(String yPasw) { driver.findElement(yourPassword).sendKeys(yPasw);}
    public void clickLogin() { driver.findElement(login).click();}
    public void hooverMyAccountLink() {
        Actions actions = new Actions(driver);
        actions.moveToElement(myAccountLink).perform();

    }
    public void MyAccountLink() {

        myAccountLink.click();

    }
    public void clickLogOutLink() {logOutLink.click();}

}
