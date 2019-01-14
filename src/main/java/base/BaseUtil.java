package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseUtil {

    private String CLOUD_URL = "https://sales.experitest.com:443/wd/hub";
    private String ACCESS_KEY = "eyJ4cC51IjoxMzg2NDQsInhwLnAiOjIsInhwLm0iOiJNVFV5TnpJM01EVTVPVFkwTmciLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE4NDkyNzg3MDMsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.bMME0KO9FuI-HFbFUq43vva3ZXLnA0IqNz1SX6VBJt4";

//    private String CLOUD_URL = "https://uscloud.experitest.com:443/wd/hub";
//    private String ACCESS_KEY = "eyJ4cC51IjoxMDQ0MjksInhwLnAiOjIsInhwLm0iOiJNVFV5TURJNE1UUTFNamswTmciLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE4NTI4OTM4MTksImlzcyI6ImNvbS5leHBlcml0ZXN0In0.LFWcGB-dTCgDPVfMsZ9zPM1zGVZ67r62kGXT2064WYg";

    public ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

    public AppiumDriver getDriver() {
        return driver.get();
    }

    @BeforeMethod
    @Parameters({"platform"})
    public void setUp(String platform, @Optional Method method) throws MalformedURLException {
        startMobileBrowser(platform, method);
    }

    private void startMobileBrowser(String platform, Method method) throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("accessKey", ACCESS_KEY);
        dc.setCapability("testName", method.getName());
        dc.setCapability("newSessionWaitTimeout", 300);

        if (platform.equalsIgnoreCase("Android")) {
//            dc.setCapability("deviceQuery", "@serialnumber='444d594132583398'");
            dc.setCapability("deviceQuery", "@os='android'");
            dc.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.CHROME);
            dc.setCapability("PNC", "PNC_Android_Web");
            driver.set(new AndroidDriver(new URL(CLOUD_URL), dc));
        } else if (platform.equalsIgnoreCase("IOS")) {
//            dc.setCapability("deviceQuery", "@serialnumber='65564f4c380fcc443cd2d05639ae750875b53ee3'");
            dc.setCapability("deviceQuery", "@os='ios'");
            dc.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.SAFARI);
            dc.setCapability("PNC", "PNC_IOS_Web");
            driver.set(new IOSDriver<>(new URL(CLOUD_URL), dc));
        }
        getDriver().rotate(ScreenOrientation.PORTRAIT);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        getDriver().quit();
        driver.remove();
    }

}

