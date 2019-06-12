import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class PizzaPage {

    WebDriver driver;
    WebSettings settings;

    public PizzaPage(WebDriver driver) {
        this.driver = driver;
        settings = new WebSettings(driver);
        settings.setUp();
    }

}
