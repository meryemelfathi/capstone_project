package testcases;

import library.Reports;
import library.SelectBrowser;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.HomePage;
import pages.SignInPage;

import java.io.IOException;
import java.time.Duration;

import static library.Reports.setUpReport;

public class RegistrationTests {

    WebDriver driver;

    // create the instance of Pages
    HomePage homePage;
    AccountPage accountPage;
    SignInPage signInPage;
    @BeforeSuite
    public void launchReport() {
        setUpReport("RegistrationTests.html");
    }





    // create the before test to select the browser
    @BeforeTest
    public void launchBrowser()
    {
        //Select & Open browser
        driver = SelectBrowser.StartBrowser("Chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //Open URL
        driver.get("https://www.alexandnova.com");
    }

    //test1 : new user registration page
    @Test (priority = 1)
    public void registrationPage()
    {
        homePage = new HomePage(driver);
        homePage.clickAccountLink();
        accountPage = new AccountPage(driver);
        accountPage.register();

        String expected = homePage.assertSignIn();
        String actual = "Sign up";
        Assert.assertEquals(actual, expected);
    }


    //test2 : verify register new user
    @Test (enabled = false)
    public void registration() {

        //test = reports.createTest("registration", "Test Passed");
        signInPage = new SignInPage(driver);

        signInPage.enterFirstName("meryem");
        signInPage.enterLastName("el fathi");
        signInPage.enterEmail("meryemElFathi@gmail.com");
        signInPage.enterPassword("abc123");

        signInPage.clickRegister();

    }

    //test3 : email validation
    @Test (enabled = false)
    public void emailValidation() {


        signInPage = new SignInPage(driver);

        signInPage.enterFirstName("meryem");
        signInPage.enterLastName("fathi");
        signInPage.enterEmail("meryemElFathi.gmail");
        signInPage.enterPassword("123abc");

        signInPage.clickRegister();
    }

    //test4 : Required / mandatory fields
    @Test (enabled = false)
    public void mandatoryFields() {


        signInPage = new SignInPage(driver);
        signInPage.clickRegister();
    }

    //test5 : Verify if the password required rules are not satisfied in the password

    @Test (priority = 2)
    public void passwordValidation() {


        signInPage = new SignInPage(driver);

        signInPage.enterFirstName("meryem");
        signInPage.enterLastName("fathi");
        signInPage.enterEmail("meryem@gmail.com");
        signInPage.enterPassword("passw");

        signInPage.clickRegister();
    }

    @AfterTest
    public void closeBrowser() throws IOException {

        Reports.tearDown();
        driver.quit();

    }










}


