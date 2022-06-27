package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    //Only this field need a constructor
    WebDriver driver;

    // constructor for web driver
    ////Constructor that will be automatically called as soon as the object of the class is created
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    // here we identify elements which we want to use tests
    //By homePage = By.id("navigation-home");
    //POM
    //Locator by id
    By accountLink = By.id("customer_login_link");
    By searchInput = By.id("ispbxii_0");
    //Locator by class name
    By cartLink = By.className("cart-count-text");
    By signIn = By.xpath("//*[@id=\"keyboard-nav-3\"]/h1");
    //By checkOutLink = By.className("checkout-link navigable");
    By searchBtn = By.xpath("//*[@id=\"shopify-section-header\"]/section/header/div[2]/div[4]/form/input[2]");
    By searchTxt = By.id("ispbxii_0");
    By searchIcon = By.xpath("//*[@id=\"shopify-section-header\"]/section/header/div[2]/div[4]/form/input[2]");
    By firstSearchResultTxt = By.xpath("//*[@id=\"keyboard-nav-3\"]/h1/span[2]");
    By secondSearchResultTxt = By.xpath("//*[@id=\"isp_search_results_container\"]/li[1]");
    By productLink = By.xpath ("//*[@id=\"shopify-section-section-2\"]/section/div/article[1]/div/p/a");



    //Here we create actions which we want to do over elements
    //public void openHomePage(){driver.findElement(homePage).click();}

    public void clickAccountLink()
    {
        driver.findElement(accountLink).click();
    }
    public void clickCartLink() { driver.findElement(cartLink).click();}
    //public void clickCheckOutLink() { driver.findElement(checkOutLink).click();}
    public void fillSearchInput(String product){ driver.findElement(searchInput).sendKeys(product);}
    public String assertSignIn(){return driver.findElement(signIn).getText();}


    public void searchTextBtn(String fArg) { driver.findElement(searchTxt).sendKeys(fArg);}
    public void submitS() {driver.findElement(searchIcon).click();}
    public void getFirstSearchResultTxt(){driver.findElement(firstSearchResultTxt).getText();}
    public void getSecondSearchResultTxt(){driver.findElement(secondSearchResultTxt).getText();}
    public void clearSearchTxt() {driver.findElement(searchTxt).clear();}
    public void submitSearch() {driver.findElement(searchIcon).click();}
    public void clickProduct() {driver.findElement(productLink).click();}


}
