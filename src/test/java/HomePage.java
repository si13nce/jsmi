import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebSettings settings;
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        settings = new WebSettings(driver);
        settings.setUp();
    }

    public WebSettings getSettings() {
        return settings;
    }

    public WebDriver getDriver() {
        return driver;
    }

    //Поля + Кнопки для авторизации.
    public final static By login_Button = By.xpath("/html/body/div[3]/div[1]/header/div[1]/div[2]/div[2]/ul/li[1]/div/span");
    public final static By login_Name = By.xpath("//*[@id=\"way_to_login\"]/input");
    public final static By login_Password = By.xpath("//*[@id=\"login-password\"]");
    public final static By submit_Button = By.xpath("//*[@id='login_form']/fieldset/div[2]/input");
    public final static By altlogin_Button = By.xpath("//*[@id=\"login_form\"]/fieldset/div[3]/a[1]");

    public final static By pizza_Headline = By.xpath("//span[.='Пиццы']");


    //Press Buttons


    public void pressLogin() {
        driver.findElement(login_Button).click();
    }

    public void pressAltButton() {
        driver.findElement(altlogin_Button).click();
    }

    public HomePage submitLogin() {
        driver.findElement(submit_Button).click();
        return new HomePage(driver);
    }


    //Enter words


    //Enter: "Login"
    public HomePage typeUsername(String username) {
        driver.findElement(HomePage.login_Name).sendKeys(username);
        return this;
    }


    //Enter: "Password"
    public HomePage typePassword(String password) {
        driver.findElement(HomePage.login_Password).sendKeys(password);
        return this;
    }


    //Enter: "Login" / "Password"
    public HomePage loginAs(String username, String password) {
        typeUsername(username);
        typePassword(password);
        return submitLogin();
    }

    //Выбор заголовка "Пиццы"
    public PizzaPage pressPizzaHeadline() {
        driver.findElement(pizza_Headline).click();
        return new PizzaPage(driver);
    }

}




