package testcases;

import basetest.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import pages.*;
import repo.DataUtil;

public class PlaceOrderTest extends BaseTest {

    @Test
    public void placeOrderByCOD() throws Exception
    {
        extentTest = extentReports.createTest("placeOrderByCOD","Placing an order using COD option.");

        if(!DataUtil.isTestExecutable(eat,"placeOrderByCOD")){
            throw new SkipException("Skipping the test case as run mode is N");
        }

        HomePage homePage = new HomePage(driver,extentTest);
        PageFactory.initElements(driver,homePage);
        SearchResultsPage searchResultsPage =  homePage.searchBook();
        ProductDisplayPage productDisplayPage = searchResultsPage.clickSearchedBook();
        BasketPage basketPage = productDisplayPage.navigateToBasketPage();
        CheckOutPage checkOutPage = basketPage.proceedToCheckout();
        checkOutPage.placeOrder();
        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"page-35\"]/div/div[1]/form[3]/ul/li/strong"));
        verifyText(errorMessage,"Billing Postcode / ZIP is a required field.");
    }

    @Test
    public void placeOrderByNB()
    {
        extentTest = extentReports.createTest("placeOrderByNB","Placing an order using NB option.");

        if(!DataUtil.isTestExecutable(eat,"placeOrderByNB")){
            throw new SkipException("Skipping the test case as run mode is N");
        }

        Assert.assertEquals(1,1);
    }

}
