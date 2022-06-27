package testcases;

import library.SelectBrowser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LogInPage;
import pages.SignInPage;

import java.time.Duration;

import static library.Reports.setUpReport;

public class LogInRegisteredUserTests {

    WebDriver driver;

    // create the instance of Pages
    HomePage homePage;
    LogInPage loginPage;

    // create the before suite to lunch the report
    //to fix
    @BeforeSuite
    public void launchReport() {
        setUpReport("SearchProductsTest.html");
    }

    @BeforeTest
    public void launchBrowser() {
        //Select & Open browser
        driver = SelectBrowser.StartBrowser("Chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //Open URL
        driver.get("https://www.alexandnova.com");

        homePage = new HomePage(driver);
        homePage.clickAccountLink();
    }

    //test6 : Login Page user
    @Test (enabled = false)
    public void loginPageUser() {

        loginPage = new LogInPage(driver);

        loginPage.enterYourEmail("meryemElFathi@gmail.com");
        loginPage.enterYourPassword("abc123");
        loginPage.clickLogin();
    }

    //test7 : Verify when passing incorrect Email and correct password to Login page

    @Test
    public void loginIncorrectEmail() {;

        loginPage = new LogInPage(driver);

        loginPage.enterYourEmail("iammeryem@gmail.com");
        loginPage.enterYourPassword("abc123");
        loginPage.clickLogin();
    }



}