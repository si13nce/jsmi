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



    //Select pizza
    public HomePage addToCard(String title) {
        WebElement targetspan;
        targetspan = driver.findElement(By.xpath("//span[.='" + title + "']")).findElement(By.xpath("../../../..//a[.='+ в корзину']"));
        targetspan.click();
        return new HomePage(driver);
    }

}
