package pages;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import repo.Locators;

public class CheckOutPage extends BasePage{

    @FindBy(how = How.XPATH, using = Locators.FIRST_NAME_TEXTBOX)
    public WebElement firstNameTextbox;

    @FindBy(how = How.XPATH, using = Locators.LAST_NAME_TEXTBOX)
    public WebElement lastNameTextbox;

    @FindBy(how = How.XPATH, using = Locators.EMAIL_TEXTBOX)
    public WebElement eMailTextbox;

    @FindBy(how = How.XPATH, using = Locators.PHONE_TEXTBOX)
    public WebElement phoneTextbox;

    @FindBy(how = How.XPATH, using = Locators.COUNTRY_DROPDOWN)
    public WebElement countryDropdown;

    @FindBy(how = How.XPATH, using = Locators.ADDRESS_TEXTBOX)
    public WebElement addressTextbox;

    @FindBy(how = How.XPATH, using = Locators.CITY_TEXTBOX)
    public WebElement cityTextbox;

    @FindBy(how = How.XPATH, using = Locators.STATE_DROPDOWN)
    public WebElement stateDropdown;

    @FindBy(how = How.XPATH, using = Locators.STATE_SEARCH_TEXTBOX)
    public WebElement stateSearchTextbox;

    @FindBy(how = How.XPATH, using = Locators.ZIP_CODE_TEXTBOX)
    public WebElement zipcodeTextbox;

    @FindBy(how = How.XPATH, using = Locators.CASH_ON_DELIVERY_RADIOBUTTON)
    public WebElement cashOnDeliveryRadioButton;

    @FindBy(how = How.XPATH, using = Locators.PLACE_ORDER_BUTTON)
    public WebElement placeOrderButton;

    public CheckOutPage(WebDriver driver, ExtentTest extentTest) {
        super(driver,extentTest);
    }

    public void placeOrder()
    {
        firstNameTextbox.sendKeys("First Name");
        lastNameTextbox.sendKeys("Last Name");
        eMailTextbox.sendKeys("email@gmail.com");
        addressTextbox.sendKeys("Address");
        cityTextbox.sendKeys("City");
        zipcodeTextbox.sendKeys("123456");
        cashOnDeliveryRadioButton.click();
        placeOrderButton.click();

    }
}
