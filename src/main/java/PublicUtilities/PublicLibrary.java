package PublicUtilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class PublicLibrary {
    public static WebDriver driver;
    private WebElement element;

    /**
     * @param browser Type of Browser
     */
    public void setUp(String browser)  {
        if(browser.trim().equalsIgnoreCase(Constant.chromeBrowser))
        {
            System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
            driver=new ChromeDriver();
        }
        else if(browser.trim().equalsIgnoreCase(Constant.firfoxBrowser))
        {
            System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver.exe");
            driver=new FirefoxDriver();
        }
        else
        {
            System.out.println("Wrong Browser Type");
        }
    }

    /**
     * Method to Maximize the Browser
     */
    public void maximizeBrowser()
    {
        driver.manage().window().maximize();
    }

    /**
     * Method to close the Browser
     */
    public void quitBrowser()
    {
        driver.quit();
    }

    /**
     * @param url Application URL
     */
    public void navigateToUrl(String url)
    {
        implicitWait(Constant.shortWait);
        driver.get(url);
    }

    /**
     * @param locatorValue element Locator value
     * Method to click the element
     */
    public void clickElement(By locatorValue)
    {

        element=driver.findElement(locatorValue);
        if(element.isEnabled() && element.isDisplayed())
        {
            explicitWait(Constant.longWait,element);
            element.click();
        }
    }

    /**
     * Method to Enter the Text
     * @param locatorValue Element Locator Value
     * @param textValue String to be entered
     */
    public void setText(By locatorValue,String textValue)
    {
        element=driver.findElement(locatorValue);
        if(element.isEnabled() && element.isDisplayed())
        {
            explicitWait(Constant.shortWait,element);
            element.sendKeys(textValue);
        }
    }

    /**
     * @param waitTime Wait Time in seconds
     */
    public void implicitWait(long waitTime)
    {
        driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
    }

    /**
     * @param waitTime Wait time in seconds
     * @param element element value
     */
    public void explicitWait(long waitTime,WebElement element)
    {
        WebDriverWait wait=new WebDriverWait(driver,waitTime);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
