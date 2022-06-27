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
import pages.CartPage;
import pages.HomePage;
import pages.PaymentPage;
import pages.ProductDetailPage;

import java.io.IOException;
import java.time.Duration;

import static library.Reports.setUpReport;

public class ProductAddToCartTest {

    WebDriver driver;

    // create the instance of Pages
    HomePage homePage;
    ProductDetailPage productDetailPage;
    PaymentPage paymentPage ;
    CartPage cartPage;

    // create the before suite to lunch the report
    @BeforeSuite
    public void launchReport() {
        setUpReport("ProductAddToCartTest.html");
    }


    // create the before test to select the browser
    @BeforeTest
    public void launchBrowser()
    {
        //Select & Open
        driver = SelectBrowser.StartBrowser("Chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //Open URL
        driver.get("https://www.alexandnova.com");
    }

    //Test10 : Verify the prices must show up for products on the product page
    @Test(priority = 1)
    public void verifyProductPriceIsDisplayed() throws IOException {
        Reports.test = Reports.extent.createTest("verifyProductPriceIsDisplayed", "Test Pass");
        homePage = new HomePage(driver);
        Reports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC10-img1.jpg");
        Reports.test.addScreenCaptureFromPath("TC10-img1.jpg");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0,600)");
        homePage.clickProduct();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Reports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC10-img2.jpg");
        Reports.test.addScreenCaptureFromPath("TC10-img2.jpg");
        productDetailPage=new ProductDetailPage(driver);
        Assert.assertTrue(productDetailPage.productPriceIsDisplayed());
        driver.get("https://www.alexandnova.com/");

    }

    //Test11 : Add Product to the cart and verify if product Is added to cart page
    @Test(priority = 2) //Test Case TC0011 -- Add Product to the cart and verify if product Is added to cart page
    public void verifyProductAddedToCart() throws IOException {
        Reports.test = Reports.extent.createTest("verifyProductAddedToCart", "Test Pass");
        homePage = new HomePage(driver);
        Reports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC11-img1.jpg");
        Reports.test.addScreenCaptureFromPath("TC11-img1.jpg");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0,600)");
        homePage.clickProduct();
        Reports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC11-img2.jpg");
        Reports.test.addScreenCaptureFromPath("TC11-img2.jpg");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        productDetailPage=new ProductDetailPage(driver);
        productDetailPage.clickProductSize();
        productDetailPage.selectProductColor();
        Reports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC11-img3.jpg");
        Reports.test.addScreenCaptureFromPath("TC11-img3.jpg");
        jse.executeScript("scroll(0,600)");
        productDetailPage.clickAddToCartButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Reports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC11-img4.jpg");
        Reports.test.addScreenCaptureFromPath("TC11-img4.jpg");
        Assert.assertTrue(productDetailPage.getAddToCartMessage().toLowerCase().contains("has been successfully added to your"));
        productDetailPage.clickCartCount();
        cartPage=new CartPage(driver);
        cartPage.clearQuantityCart();
        cartPage.selectQuantityCart("0");
        cartPage.clickUpdateCartButton();
        driver.get("https://www.alexandnova.com/");

    }

    //Test12 : Refresh the page and verify if items are still present in the cart
    @Test(priority = 3)
    public void verifyCartAfterRefreshPage() throws IOException, InterruptedException {
        Reports.test = Reports.extent.createTest("verifyCartAfterRefreshPage", "Test Pass");
        homePage = new HomePage(driver);
        Reports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC12-img1.jpg");
        Reports.test.addScreenCaptureFromPath("TC12-img1.jpg");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        homePage.clickProduct();
        Reports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC12-img2.jpg");
        Reports.test.addScreenCaptureFromPath("TC12-img2.jpg");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        productDetailPage=new ProductDetailPage(driver);
        productDetailPage.clickProductSize();
        productDetailPage.selectProductColor();
        Reports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC12-img3.jpg");
        Reports.test.addScreenCaptureFromPath("TC12-img3.jpg");
        jse.executeScript("scroll(0,600)");
        productDetailPage.clickAddToCartButton();
        Thread.sleep(3000);
        Reports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC12-img4.jpg");
        Reports.test.addScreenCaptureFromPath("TC12-img4.jpg");
        driver.navigate().refresh();

        Assert.assertEquals(productDetailPage.getProductQuantity(),productDetailPage.getCartCount());
        Reports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC12-img5.jpg");
        Reports.test.addScreenCaptureFromPath("TC12-img5.jpg");
        productDetailPage.clickCartCount();
        Thread.sleep(3000);
        cartPage=new CartPage(driver);
        cartPage.clearQuantityCart();
        cartPage.selectQuantityCart("0");
        cartPage.clickUpdateCartButton();
        driver.get("https://www.alexandnova.com/");

    }

    //Test13-14 : Increase the quantity of the product and verify if it is showing up in cart
    @Test(priority = 4)
    public void verifyCartAfterIncreasingQuantity() throws IOException, InterruptedException {
        Reports.test = Reports.extent.createTest("verifyCartAfterIncreasingQuantity", "Test Pass");
        homePage = new HomePage(driver);
        Reports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC13-img1.jpg");
        Reports.test.addScreenCaptureFromPath("TC13-img1.jpg");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0,600)");
        homePage.clickProduct();
        Reports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC13-img2.jpg");
        Reports.test.addScreenCaptureFromPath("TC13-img2.jpg");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        productDetailPage=new ProductDetailPage(driver);
        productDetailPage.clickProductSize();
        productDetailPage.selectProductColor();
        productDetailPage.selectProductQuantity("2");
        Reports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC13-img3.jpg");
        Reports.test.addScreenCaptureFromPath("TC13-img3.jpg");
        jse.executeScript("scroll(0,600)");
        productDetailPage.clickAddToCartButton();
        Thread.sleep(6000);
        Reports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC13-img4.jpg");
        Reports.test.addScreenCaptureFromPath("TC13-img4.jpg");
        Assert.assertEquals(productDetailPage.getProductQuantity(),productDetailPage.getCartCount());

        driver.get("https://www.alexandnova.com/");

    }

    //Test15 : Remove Product from cart: Verify that the Product should be removed from the cart and the Cart icon should show 0 items.
    @Test(priority = 5)
    public void verifyCartAfterRemovingProducts() throws IOException, InterruptedException {
        Reports.test = Reports.extent.createTest("verifyCartAfterRemovingProducts", "Test Pass");
        homePage = new HomePage(driver);
        Reports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC15-img1.jpg");
        Reports.test.addScreenCaptureFromPath("TC15-img1.jpg");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0,600)");
        homePage.clickProduct();
        Reports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC15-img2.jpg");
        Reports.test.addScreenCaptureFromPath("TC15-img2.jpg");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        productDetailPage=new ProductDetailPage(driver);
        productDetailPage.clickProductSize();
        productDetailPage.selectProductColor();
        Reports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC15-img3.jpg");
        Reports.test.addScreenCaptureFromPath("TC15-img3.jpg");
        jse.executeScript("scroll(0,600)");
        productDetailPage.clickAddToCartButton();
        Thread.sleep(6000);
        Reports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC15-img4.jpg");
        Reports.test.addScreenCaptureFromPath("TC15-img4.jpg");
        productDetailPage.clickCartCount();
        Thread.sleep(3000);
        cartPage=new CartPage(driver);
        cartPage.clearQuantityCart();
        cartPage.selectQuantityCart("0");
        cartPage.clickUpdateCartButton();
        Reports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC15-img5.jpg");
        Reports.test.addScreenCaptureFromPath("TC15-img5.jpg");
        Assert.assertEquals(productDetailPage.getCartCount(),"0");

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
