package pages;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import repo.Locators;

public class SearchResultsPage extends BasePage{

    @FindBy(how = How.XPATH, using = Locators.SEARCH_RESULT_BOOKTITLE)
    public WebElement searchResultBookTitle;


    public SearchResultsPage(WebDriver driver, ExtentTest extentTest) {
        super(driver,extentTest);
    }

    public ProductDisplayPage clickSearchedBook()
    {
        searchResultBookTitle.click();
        ProductDisplayPage productDisplayPage = new ProductDisplayPage(driver,extentTest);
        PageFactory.initElements(driver,productDisplayPage);
        return productDisplayPage;
    }
}
