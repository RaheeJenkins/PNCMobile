package pages.banking;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.PageObject;

public class CheckingMainPage extends PageObject {

    public CheckingMainPage(ThreadLocal<AppiumDriver> mDriver) {
        super(mDriver);
    }

    @FindBy(xpath = "//a[text()='Find the Right Checking Account']")
    WebElement find_the_right_checking_account_button;

    public void click_on_find_the_right_checking_account_button() {
        wait.until(ExpectedConditions.visibilityOf(find_the_right_checking_account_button));
        find_the_right_checking_account_button.click();
    }

    public boolean verify_user_is_on_main_personal_checking_accounts_page() {
        wait.until(ExpectedConditions.visibilityOf(find_the_right_checking_account_button));
        if (find_the_right_checking_account_button.isDisplayed()) {
            return true;
        }
        return false;
    }

}
