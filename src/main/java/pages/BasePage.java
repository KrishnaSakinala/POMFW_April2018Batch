package pages;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {

    public WebDriver driver;
    public ExtentTest extentTest;

    public BasePage(WebDriver driver, ExtentTest extentTest)
    {
        this.driver = driver;
        this.extentTest = extentTest;
    }

    public void verifyText()
    {

    }

    public void loginIntoReport(String logInfo){
        extentTest.info(logInfo);
    }

    public void waitUntilElementClickable(WebElement locator){
        WebDriverWait wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

}
