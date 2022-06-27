package testcases;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import library.Reports;
import library.SelectBrowser;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.*;

import java.io.IOException;
import java.time.Duration;

import static library.Reports.setUpReport;

public class CheckoutProductFromShoppingCartPageTest {

    WebDriver driver;

    // create the instance of Pages
    HomePage homePage;
    LogInPage loginPage;
    ProductDetailPage productDetailPage;
    PaymentPage paymentPage ;
    CartPage cartPage;

    // create the before suite to lunch the report
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

        //homePage = new HomePage(driver);
        //homePage.clickAccountLink();
    }

    //Test16 : verify that user can apply for a discount code at checkout page
    @Test(priority = 1)
    public void verifyApplyGiftCard() throws IOException, InterruptedException {
        Reports.test = Reports.extent.createTest("verifyApplyGiftCard", "Test Pass");
        homePage = new HomePage(driver);
        Reports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC16_img1.jpg");
        Reports.test.addScreenCaptureFromPath("TC00016-image1.jpg");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        homePage.clickProduct();
        Reports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC16_img2.jpg");
        Reports.test.addScreenCaptureFromPath("TC16_img2.jpg");
        productDetailPage=new ProductDetailPage(driver);
        productDetailPage.clickProductSize();
        productDetailPage.selectProductColor();

        //jse.executeScript("scroll(0,600)");
        Thread.sleep(3000);
        productDetailPage.clickAddToCartButton();
        Thread.sleep(3000);
        productDetailPage.clickCartCount();
        cartPage=new CartPage(driver);
        cartPage.clickCheckOutButton();
        Reports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC16-img3.jpg");
        Reports.test.addScreenCaptureFromPath("TC16-img3.jpg");
        paymentPage= new PaymentPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        paymentPage.selectGiftCardText("WELCOME");
        paymentPage.clickGiftCardButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Reports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC16-img4.jpg");
        Reports.test.addScreenCaptureFromPath("TC16-img4.jpg");
        Assert.assertTrue(paymentPage.giftCardLabelIsDisplayed());


        driver.get("https://www.alexandnova.com/");


    }
    @Test(priority = 3) //Test Case TC00017 --Payment Mode Check
    public void verifyPaymentOptions() throws IOException, InterruptedException {
        Reports.test = Reports.extent.createTest("verifyPaymentOptions", "Test Pass");
        homePage = new HomePage(driver);
        Reports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC17-img1.jpg");
        Reports.test.addScreenCaptureFromPath("TC17-img1.jpg");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        homePage.clickProduct();
        Reports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC17-img2.jpg");
        Reports.test.addScreenCaptureFromPath("TC17-img2.jpg");
        productDetailPage=new ProductDetailPage(driver);
        productDetailPage.clickProductSize();
        productDetailPage.selectProductColor();
        jse.executeScript("scroll(0,600)");
        productDetailPage.clickAddToCartButton();
        Thread.sleep(3000);
        productDetailPage.clickCartCount();
        Thread.sleep(3000);
        cartPage=new CartPage(driver);
        cartPage.clickCheckOutButton();
        Reports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC17-img3.jpg");
        Reports.test.addScreenCaptureFromPath("TC17-img3.jpg");
        paymentPage= new PaymentPage(driver);
        paymentPage.clearCheckOutEmail();
        paymentPage.clearCheckOutFName();
        paymentPage.clearCheckOutLName();
        paymentPage.clearShippingAddressText();
        paymentPage.clearShippingAddressCityText();
        paymentPage.clearShippingAddressZipText();
        paymentPage.selectCheckOutEmail("meryem@gmail.com");
        Thread.sleep(2000);
        paymentPage.selectCheckOutFName("meryemtest");
        paymentPage.selectCheckOutLName("ElFathi");
        paymentPage.selectShippingAddressText("757 Quincy");
        paymentPage.selectShippingAddressCityText("Denver");
        paymentPage.selectShippingAddressZipText("80237");
        Reports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC17-img4.jpg");
        Reports.test.addScreenCaptureFromPath("TC17-img4.jpg");
        paymentPage.clickContButton();
        Thread.sleep(2000);
        paymentPage.clickContButton();
        Reports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC17-img4.jpg");
        Reports.test.addScreenCaptureFromPath("TC17-img4.jpg");
        Assert.assertTrue(paymentPage.payPalOptionIsDisplayed());
        Assert.assertTrue(paymentPage.shopByOptionIsDisplayed());
        Assert.assertTrue(paymentPage.creditCardOptionIsDisplayed());

        driver.get("https://www.alexandnova.com/");



    }
    //Test Case TC00018 --Check Out Mandatory Field Validation:Try completing the check-out process
    // by leaving any mandatory field blank in the credit card payment information and shipping or billing address.
    @Test(priority = 2)
    public void verifyPaymentWithMissingReqData() throws IOException, InterruptedException {
        Reports.test = Reports.extent.createTest("verifyPaymentWithMissingReqData", "Test Pass");
        homePage = new HomePage(driver);
        Reports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC18-img1.jpg");
        Reports.test.addScreenCaptureFromPath("TC18-img1.jpg");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0,600)");
        homePage.clickProduct();
        Reports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC18-img2.jpg");
        Reports.test.addScreenCaptureFromPath("TC00018-img2.jpg");
        productDetailPage=new ProductDetailPage(driver);
        productDetailPage.clickProductSize();
        productDetailPage.selectProductColor();
        jse.executeScript("scroll(0,600)");
        productDetailPage.clickAddToCartButton();
        productDetailPage.clickCartCount();
        cartPage=new CartPage(driver);
        Thread.sleep(3000);
        cartPage.clickCheckOutButton();
        Reports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC18-img3.jpg");
        Reports.test.addScreenCaptureFromPath("TC18-img3.jpg");
        paymentPage= new PaymentPage(driver);
        paymentPage.clearCheckOutEmail();
        paymentPage.clearCheckOutFName();
        paymentPage.clearCheckOutLName();
        paymentPage.clearShippingAddressText();
        paymentPage.clearShippingAddressCityText();
        paymentPage.clearShippingAddressZipText();
        paymentPage.selectCheckOutEmail("meryem@gmail.com");
        Thread.sleep(3000);
        paymentPage.selectCheckOutFName("meryem");
        paymentPage.selectCheckOutLName("judya");


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        paymentPage.selectShippingAddressText("");
        paymentPage.selectShippingAddressCityText("");
        paymentPage.selectShippingAddressZipText("");
        paymentPage.clickContButton();
        Reports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC18-img4.jpg");
        Reports.test.addScreenCaptureFromPath("TC18-img4.jpg");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        Assert.assertTrue(paymentPage.errorAddressMessageIsDisplayed());
        Assert.assertTrue(paymentPage.errorCityMessageIsDisplayed());
        Assert.assertTrue(paymentPage.errorZipMessageIsDisplayed());
        paymentPage.clearCheckOutEmail();
        paymentPage.clearCheckOutFName();
        paymentPage.clearCheckOutLName();
        paymentPage.clearShippingAddressText();
        paymentPage.clearShippingAddressCityText();
        paymentPage.clearShippingAddressZipText();
        driver.get("https://www.alexandnova.com/");

    }
    @Test(priority = 4) //Test Case TC00019 --Verify that the user should successfully checkout the product
    public void verifyCheckOutProductSuccessfully() throws IOException, InterruptedException {
        Reports.test = Reports.extent.createTest("verifyCheckOutProductSuccessfully", "Test Pass");
        homePage = new HomePage(driver);
        Reports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC00019-image1.jpg");
        Reports.test.addScreenCaptureFromPath("TC19-img1.jpg");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        homePage.clickProduct();
        Reports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC19-img2.jpg");
        Reports.test.addScreenCaptureFromPath("TC19-img2.jpg");
        productDetailPage=new ProductDetailPage(driver);
        productDetailPage.clickProductSize();
        productDetailPage.selectProductColor();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0,600)");

        driver.navigate().refresh();
        productDetailPage.clickBuyNow();

        Reports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC19-img3.jpg");
        Reports.test.addScreenCaptureFromPath("TC19-img3.jpg");
        paymentPage= new PaymentPage(driver);
        paymentPage.selectCheckOutEmail("meryem@gmail.com");
        Thread.sleep(2000);
        paymentPage.selectCheckOutFName("meryem");
        paymentPage.selectCheckOutLName("judya");

        paymentPage.selectShippingAddressText("757 Quincy");
        paymentPage.selectShippingAddressCityText("Denver");
        paymentPage.selectShippingAddressZipText("80237");
        Reports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC19-img4.jpg");
        Reports.test.addScreenCaptureFromPath("TC19-img4.jpg");
        paymentPage.clickContButton();
        Thread.sleep(3000);
        paymentPage.clickContButton();
        Reports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC00019-image5.jpg");
        Reports.test.addScreenCaptureFromPath("TC19-img5.jpg");
        Assert.assertTrue(paymentPage.payNowButtonIsDisplayed());
        Assert.assertTrue(paymentPage.paymentLabel2IsDisplayed());
        driver.get("https://www.alexandnova.com/");


    }

    @AfterMethod
    public void getResult(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {
            Reports.test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Test case FAILED due to below issues:", ExtentColor.RED));

            Reports.test.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            Reports.test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
        } else {
            Reports.test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " Test Case SKIPPED", ExtentColor.ORANGE));
            Reports.test.skip(result.getThrowable());
        }
    }

    @AfterTest
    public void closeBrowser() throws IOException {

        Reports.tearDown();
        driver.quit();

    }
}
