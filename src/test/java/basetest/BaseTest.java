package basetest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import repo.ExcelApiTest;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class BaseTest {

    public WebDriver driver;
    public ExtentHtmlReporter extentHtmlReporter;
    public ExtentReports extentReports;
    public ExtentTest extentTest;

    public Properties config = null;
    public FileInputStream fis = null;

    public ExcelApiTest eat = null;

    @BeforeSuite
    public void init() throws Exception
    {
        eat = new ExcelApiTest(System.getProperty("user.dir") + "/src/main/resources/TestData.xlsx");

        fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/config.properties");
        config = new Properties();

        config.load(fis);

        if(extentReports == null)
        {
            extentHtmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/src/main/resources/ATReport.html");
            extentReports = new ExtentReports();
            extentReports.attachReporter(extentHtmlReporter);

            extentReports.setSystemInfo("OS","Mac OS");
            extentReports.setSystemInfo("Environment","QA");
            extentReports.setSystemInfo("User Name","Krishna Sakinala");

            extentHtmlReporter.config().setChartVisibilityOnOpen(false);
            extentHtmlReporter.config().setDocumentTitle("Automation Report");
            extentHtmlReporter.config().setReportName("My Own Report");
            extentHtmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
            extentHtmlReporter.config().setTheme(Theme.DARK);
        }

        if(driver == null){
            if(config.getProperty("browser").equalsIgnoreCase("chrome")){
                System.setProperty("webdriver.chrome.driver","/KRISHNA VOLUME/Selenium/drivers/chromedriver");
                driver = new ChromeDriver();
            }else
            {
                System.setProperty("webdriver.gecko.driver","/KRISHNA VOLUME/Selenium/drivers/geckodriver");
                driver = new FirefoxDriver();
            }
            driver.get(config.getProperty("url"));
            driver.manage().window().maximize();
        }
    }

    public void verifyText(WebElement locator, String expected)
    {
        Assert.assertEquals(expected,locator.getText());
    }

    public static String capture(WebDriver driver,String screenshotName) throws Exception
    {
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String dest = System.getProperty("user.dir")+"/src/main/resources/Screenshots"+screenshotName+".png";
        File destination = new File(dest);
        FileUtils.copyFile(source, destination);

        return dest;
    }


    @AfterMethod
    public void getResult(ITestResult result) throws Exception
    {
        if(result.getStatus() == ITestResult.FAILURE){
            extentTest.fail("Test Failed.");
            extentTest.fail(result.getThrowable());
            String path = capture(driver,"screenshot");
            extentTest.fail("Find screenshot below.",MediaEntityBuilder.createScreenCaptureFromPath(path).build());
        }
        else if(result.getStatus() == ITestResult.SUCCESS)
        {
            extentTest.pass("Test Passed.");
        }else
        {
            extentTest.skip("Test Skipped.");
        }
    }

    @AfterSuite
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);

        extentReports.flush();

        if(driver != null){
            driver.quit();
        }
    }
}
