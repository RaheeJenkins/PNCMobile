package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SearchResultsPage extends PageObject {

    public SearchResultsPage(ThreadLocal<AppiumDriver> mDriver) {
        super(mDriver);
    }

    @FindBy(xpath = "//*[@class='results-returned-container cf']")
    WebElement results_returned;

    @FindBy(xpath = "//div[@class='search-content main left']//div[@class='result-item cf']")
    List<WebElement> search_results_items;

    public boolean verify_item_displayed(String input) {
        wait.until(ExpectedConditions.visibilityOf(results_returned));
        try {
            for (WebElement search_result_item : search_results_items) {
                if (search_result_item.getText().contains(input)) {
                    break;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
