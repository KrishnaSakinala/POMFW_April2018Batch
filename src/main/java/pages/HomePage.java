package pages;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import repo.Locators;

public class HomePage extends BasePage{

   @FindBy(how  = How.XPATH, using = Locators.SEARCH_TEXTBOX)
   public WebElement searchTextbox;

    public HomePage(WebDriver driver, ExtentTest extentTest) {
        super(driver,extentTest);
    }

    public SearchResultsPage searchBook()
    {
        searchTextbox.sendKeys("selenium");
        loginIntoReport("Entered search book in search box.");
        searchTextbox.sendKeys(Keys.ENTER);
        loginIntoReport("It hit enter to search.");
        SearchResultsPage searchResultsPage =  new SearchResultsPage(driver,extentTest);
        PageFactory.initElements(driver,searchResultsPage);
        return searchResultsPage;
    }
}
