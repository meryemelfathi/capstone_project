package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage {

    //Only this field need a constructor
    WebDriver driver;


    //Constructor for web driver
    //Constructor that will be automatically called as soon as the object of the class is created
    public LogInPage(WebDriver driver) {
        this.driver = driver;
    }


    // here we identify elements which we want to use tests

    //Locator for Email field
    By yourEmail = By.id("ispbxii_1");

    //Locator for password field
    By yourPassword = By.xpath("//*[@id=\"customer_login\"]/div[2]/input");

    //
    By login = By.xpath("//*[@id=\"customer_login\"]/div[3]/input");


    //Here we create actions which we want to do over elements

    public void enterYourEmail(String yEmail) { driver.findElement(yourEmail).sendKeys(yEmail);}
    public void enterYourPassword(String yPasw) { driver.findElement(yourPassword).sendKeys(yPasw);}
    public void clickLogin() { driver.findElement(login).click();}

}
