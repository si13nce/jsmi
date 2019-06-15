import Utils.UtilsSettings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class WebSettings {

    private WebDriver driver;
    private UtilsSettings utils = new UtilsSettings();
    private WebElement element;

    public WebSettings(WebDriver driver) {
        this.driver = driver;
    }


    @BeforeTest
    public void setUp() {
        System.setProperty(utils.getProperties().getProperty("driver"), utils.getProperties().getProperty("path.driver"));
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(0,TimeUnit.SECONDS);
    }

    @AfterTest
    public void setTimeout() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        element =( new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath("")));

    }

    public void close()    {
        driver.quit();
    }

}
