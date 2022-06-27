package testcases;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import library.Reports;
import library.SelectBrowser;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;


import java.io.IOException;
import java.time.Duration;

import static library.Reports.setUpReport;

public class SearchProductOnHomePageTest {

    WebDriver driver;

    // create the instance of Pages
    HomePage homePage;

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

    }

    //Test8 : Correct search results should show up for different types such as product name, brand name, or fuzzy search.
    @Test(priority = 2)
    public void matchSearchWordAndSearchResult() throws IOException {

        Reports.test = Reports.extent.createTest("matchSearchWordAndSearchResult", "Test Pass");
        homePage = new HomePage(driver);
        String searchText="baby shoes";
        Reports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC8-img1.jpg");
        Reports.test.addScreenCaptureFromPath("TC8-img1.jpg");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        homePage.searchTextBtn(searchText);
        homePage.submitS();
        Reports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC8-img2.jpg");
        Reports.test.addScreenCaptureFromPath("TC8-img2.jpg");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Reports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC8-img3.jpg");
        Reports.test.addScreenCaptureFromPath("TC8-img3.jpg");
        //Assert.assertTrue(homePage.getFirstSearchResultTxt().toLowerCase().contains(searchText));
        homePage.clearSearchTxt();


    }

    //Test9 : Without entering anything in the search box click on the Search button.
    @Test(priority = 1) //Test Case TC0009 --Without entering anything in the search box click on the Search button..
    public void verifySearchResultWithNullSearchText() throws IOException {

        Reports.test = Reports.extent.createTest("verifySearchResultWithNullSearchText", "Test Pass");
        homePage = new HomePage(driver);
        String searchText="";
        Reports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC9-img1.jpg");
        Reports.test.addScreenCaptureFromPath("TC9-img1.jpg");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        homePage.searchTextBtn(searchText);
        homePage.submitSearch();
        Reports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC9-img2.jpg");
        Reports.test.addScreenCaptureFromPath("TC9-img2.jpg");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //Assert.assertEquals(homePage.getSecondSearchResultTxt(),"No results found. Showing top popular products you might want to consider...");

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
