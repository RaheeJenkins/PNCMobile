package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BankingDropDownPage extends PageObject {

    public BankingDropDownPage(ThreadLocal<AppiumDriver> mDriver) {
        super(mDriver);
    }

    @FindBy(xpath = "//*[@class='nav-toggle']")
    WebElement hamburger_icon;

    @FindBy(xpath = "//ul[@class='level-2  expanded']//span[contains(text(), 'Banking')]")
    WebElement banking_option;

    @FindBy(xpath = "//li/a[text()='Checking']")
    WebElement checking;

    @FindBy(xpath = "//li/a[text()='Savings']")
    WebElement savings;

    @FindBy(xpath = "//li/a[text()='Credit Cards']")
    WebElement credit_cards;

    public BankingDropDownPage click_on_hamburger_icon() {
        wait.until(ExpectedConditions.visibilityOf(hamburger_icon));
        hamburger_icon.click();
        return this;
    }

    public BankingDropDownPage click_on_banking_dropdown_menu() {
        wait.until(ExpectedConditions.visibilityOf(banking_option));
        banking_option.click();
        return this;
    }

    public BankingDropDownPage click_on_checking_option() {
        wait.until(ExpectedConditions.visibilityOf(checking));
        checking.click();
        return this;
    }

    public BankingDropDownPage click_on_savings_option() {
        wait.until(ExpectedConditions.visibilityOf(savings));
        savings.click();
        return this;
    }

    public BankingDropDownPage click_on_credit_cards_option() {
        wait.until(ExpectedConditions.visibilityOf(credit_cards));
        credit_cards.click();
        return this;
    }

}
