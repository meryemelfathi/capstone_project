package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {

    //Only this field need a constructor
    WebDriver driver;

    //Constructor for web driver
    //Constructor that will be automatically called as soon as the object of the class is created
    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }



    // here we identify elements which we want to use tests
    By registerBtn = By.linkText("REGISTER");
    By logInBtn = By.xpath("//input[@value='login']");



    //Here we create actions which we want to do over elements
    public void register() { driver.findElement(registerBtn).click();}
    public void logInButton () { driver.findElement(logInBtn).click();}


}
