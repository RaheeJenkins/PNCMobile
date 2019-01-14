package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends PageObject {

    public HomePage(ThreadLocal<AppiumDriver> mDriver) {
        super(mDriver);
    }

    @FindBy(id = "navSearchField")
    WebElement search_field;

    public HomePage type_into_search_field_with(String input) {
        wait.until(ExpectedConditions.visibilityOf(search_field));
        search_field.sendKeys(input);

        if (getParameter("platform").contains("IOS")) {

            search_field.click();
            getDriver().context("NATIVE_APP");
            getDriver().findElement(By.xpath("//*[@id='Search']")).click();
            getDriver().context("WEBVIEW_1");

        } else if (getParameter("platform").contains("Android")) {

            getDriver().getKeyboard().sendKeys(Keys.RETURN);

        } else {
            throw new UnsupportedOperationException("Unable to identify platform");
        }
        return this;
    }

    public BankingDropDownPage click_on_hamburger_icon() {
        return new BankingDropDownPage(driver).click_on_hamburger_icon();
    }

}
