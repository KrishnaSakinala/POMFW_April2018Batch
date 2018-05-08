package pages;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import repo.Locators;

public class BasketPage extends BasePage{

    @FindBy(how = How.XPATH, using = Locators.COUPON_CODE_TEXTBOX)
    public WebElement couponCodeTextbox;

    @FindBy(how = How.XPATH, using = Locators.APPLY_COUPON_BUTTON)
    public WebElement applyCouponButton;

    @FindBy(how = How.XPATH, using = Locators.PROCEEDTO_CHECKOUT_BUTTON)
    public WebElement proceedToCheckoutButton;

    public BasketPage(WebDriver driver, ExtentTest extentTest) {
        super(driver,extentTest);
    }

    public CheckOutPage proceedToCheckout() throws InterruptedException {
        couponCodeTextbox.sendKeys("krishnasakinala");
        applyCouponButton.click();
        Thread.sleep(5000);
        //waitUntilElementClickable(proceedToCheckoutButton);
        proceedToCheckoutButton.click();

        CheckOutPage checkOutPage = new CheckOutPage(driver,extentTest);
        PageFactory.initElements(driver,checkOutPage);
        return checkOutPage;
    }
}
