package pages;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import repo.Locators;

public class ProductDisplayPage extends BasePage{

    @FindBy(how = How.XPATH, using = Locators.ADDTO_BASKET_BUTTON)
    public WebElement addToBasketButton;

    @FindBy(how = How.XPATH, using = Locators.VIEW_BASKET_BUTTON)
    public WebElement viewBasketButton;

    public ProductDisplayPage(WebDriver driver, ExtentTest extentTest) {
        super(driver,extentTest);
    }

    public BasketPage navigateToBasketPage()
    {
        addToBasketButton.click();
        viewBasketButton.click();

        BasketPage basketPage = new BasketPage(driver,extentTest);
        PageFactory.initElements(driver,basketPage);
        return basketPage;
    }
}
