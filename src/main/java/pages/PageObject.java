package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class PageObject {

    protected ThreadLocal<AppiumDriver> driver;
    protected WebDriverWait wait;

    public PageObject(ThreadLocal<AppiumDriver> mDriver) {
        this.driver = mDriver;
        wait = new WebDriverWait(getDriver(), 20);
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    protected AppiumDriver getDriver() {
        return driver.get();
    }

    public void navigateTo(String url) {
        getDriver().navigate().to(url);
    }

    public String getTitle() {
        return getDriver().getTitle();
    }

    public String getParameter(String parameter) {
        return Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter(parameter);
    }

}
