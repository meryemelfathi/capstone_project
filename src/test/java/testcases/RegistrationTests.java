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
import pages.LogInPage;
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
    LogInPage logInPage;
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
    public void registrationPage() throws IOException {
        Reports.test = Reports.extent.createTest("registrationPage", "Test Pass");

        homePage = new HomePage(driver);
        Reports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC1-img1.jpg");
        Reports.test.addScreenCaptureFromPath("TC1-img1.jpg");
        homePage.clickAccountLink();
        accountPage = new AccountPage(driver);
        accountPage.register();
        Reports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC1-img2.jpg");
        Reports.test.addScreenCaptureFromPath("TC1-img2.jpg");
        String expected = homePage.assertSignIn();
        String actual = "Sign up";
        Reports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC1-img3.jpg");
        Reports.test.addScreenCaptureFromPath("TC1-img3.jpg");
        Assert.assertEquals(actual, expected);
    }


    //test2 : verify register new user
    @Test (priority = 2)
    public void registration() throws InterruptedException, IOException {
        Reports.test = Reports.extent.createTest("registration", "Test Pass");

        homePage = new HomePage(driver);
        homePage.clickAccountLink();
        Reports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC2-img1.jpg");
        Reports.test.addScreenCaptureFromPath("TC2-img1.jpg");
        accountPage = new AccountPage(driver);
        accountPage.register();
        //test = reports.createTest("registration", "Test Passed");
        signInPage = new SignInPage(driver);

        signInPage.enterFirstName("meryem");
        signInPage.enterLastName("el fathi");
        signInPage.enterEmail("meryemElFathi023@gmail.com");
        signInPage.enterPassword("abc123");
        Reports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC2-img2.jpg");
        Reports.test.addScreenCaptureFromPath("TC2-img2.jpg");
        signInPage.clickRegister();
        logInPage=new LogInPage(driver);

        Thread.sleep(30000);
        logInPage=new LogInPage(driver);
      logInPage.MyAccountLink();
      logInPage.hooverMyAccountLink();
        Reports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC2-img3.jpg");
        Reports.test.addScreenCaptureFromPath("TC2-img3.jpg");
        logInPage.clickLogOutLink();
        driver.get("https://www.alexandnova.com");


    }

    //test3 : email validation
    @Test (priority = 3)
    public void emailValidation() throws InterruptedException, IOException {
        Reports.test = Reports.extent.createTest("emailValidation", "Test Pass");

        homePage = new HomePage(driver);
        homePage.clickAccountLink();
        Reports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC3-img1.jpg");
        Reports.test.addScreenCaptureFromPath("TC3-img1.jpg");

        accountPage = new AccountPage(driver);
        accountPage.register();
        Reports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC3-img2.jpg");
        Reports.test.addScreenCaptureFromPath("TC3-img2.jpg");

        signInPage = new SignInPage(driver);

        signInPage.enterFirstName("meryem");
        signInPage.enterLastName("fathi");
        signInPage.enterEmail("meryemElFathi.gmail");
        signInPage.enterPassword("123abc");
        Reports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC3-img3.jpg");
        Reports.test.addScreenCaptureFromPath("TC3-img3.jpg");
        signInPage.clickRegister();
        Thread.sleep(30000);
    }

    //test4 : Required / mandatory fields
    @Test (priority = 4 ,enabled = false)
    public void mandatoryFields() {


        signInPage = new SignInPage(driver);
        signInPage.clickRegister();
    }

    //test5 : Verify if the password required rules are not satisfied in the password

    @Test (priority = 5)
    public void passwordValidation() throws InterruptedException, IOException {
        Reports.test = Reports.extent.createTest("passwordValidation", "Test Pass");

        homePage = new HomePage(driver);
        homePage.clickAccountLink();
        accountPage=new AccountPage(driver);
        accountPage.register();
        Reports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC5-img1.jpg");
        Reports.test.addScreenCaptureFromPath("TC5-img1.jpg");
        signInPage = new SignInPage(driver);

        signInPage.enterFirstName("meryem");
        signInPage.enterLastName("fathi");
        signInPage.enterEmail("meryem@gmail.com");
        signInPage.enterPassword("passw");
        Reports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC5-img2.jpg");
        Reports.test.addScreenCaptureFromPath("TC5-img2.jpg");

        signInPage.clickRegister();
        Thread.sleep(30000);
    }

    @AfterTest
    public void closeBrowser() throws IOException {

        Reports.tearDown();
        driver.quit();

    }










}


