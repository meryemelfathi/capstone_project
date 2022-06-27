package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {

    //Only this field need a constructor
    WebDriver driver;

    //Constructor for web driver
    //Constructor that will be automatically called as soon as the object of the class is created
    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    // here we identify elements which we want to use tests

    //Locator for first name field
    By firstName = By.id("ispbxii_1");

    //Locator for last name field
    By lastName = By.id("ispbxii_2");

    //Locator for Email field
    By eMail = By.id("ispbxii_3");

    //Locator for password field
    By password = By.xpath("//*[@id=\"create_customer\"]/div[4]/input");

    //
    By register = By.xpath("//*[@id=\"create_customer\"]/div[5]/input");


    //Here we create actions which we want to do over elements

    public void enterFirstName(String fName) { driver.findElement(firstName).sendKeys(fName);}
    public void enterLastName(String lName) { driver.findElement(lastName).sendKeys(lName);}
    public void enterEmail(String email) { driver.findElement(eMail).sendKeys(email);}
    public void enterPassword(String pasw) { driver.findElement(password).sendKeys(pasw);}
    public void clickRegister() { driver.findElement(register).click();}

}
