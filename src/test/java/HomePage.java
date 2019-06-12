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

    //Поля + Кнопки для авторизации.

    public final static By login_Button = By.xpath("/html/body/div[4]/div[1]/header/div[1]/div[2]/div[2]/ul/li[1]/div");
    public final static By login_Name = By.xpath("//*[@id=\"way_to_login\"]/input");
    public final static By login_Password = By.xpath("//*[@id=\"login-password\"]");
    public final static By submit_Button = By.xpath("//*[@id='login_form']/fieldset/div[2]/input");
    public final static By altlogin_Button = By.xpath("//*[@id=\"login_form\"]/fieldset/div[3]/a[1]");
    public final static By pizza_Headline = By.xpath("//span[.='Пиццы']");


    public WebSettings getSettings() {
        return settings;
    }

    public WebDriver getDriver() {
        return driver;
    }


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
    public HomePage typePassword(String password) {
        driver.findElement(HomePage.login_Password).sendKeys(password);
        return this;
    }


    //Enter: "Password"
    public HomePage typeUsername(String username) {

        driver.findElement(HomePage.login_Name).sendKeys(username);
        return this;
    }


    //Enter: "Login" / "Password"
    public HomePage loginAs(String username, String password) {
        typeUsername(username);
        typePassword(password);
        return submitLogin();
    }

    //Выбор заголовка "Пиццы"
    public HomePage pressPizzaHeadline() {
        driver.findElement(pizza_Headline).click();
        return this;
    }


    //Выбор Пиццы
    public PizzaPage selectPizzaName(String pizzaName) {
        WebElement namePizza;
        namePizza = driver.findElement(By.xpath("//span[.='" + pizzaName + "']"));
        namePizza.isSelected();
        return new PizzaPage(driver);
    }

    //Выбрать из какого теста будет изготовлена Пицца
    public PizzaPage selectPizzaDough(String dough) {
        WebElement pizzaDough;
        pizzaDough = driver.findElement(By.xpath("//a[.='" + dough + "']"));
        pizzaDough.click();
        return new PizzaPage(driver);
    }

    //Выбор размера Пиццы
    public PizzaPage selectPizzaSize(int size) {
        WebElement pizzaLengh;
        pizzaLengh = driver.findElement(By.xpath("//span[.='" + size + "см" + "']"));
        pizzaLengh.click();
        return new PizzaPage(driver);
    }

    //Нажатие на кнопку "В корзину"
    public void pressAddToCard() {
        driver.findElement(By.xpath("../../../..//a[.='+ в корзину']")).click();
    }

    public PizzaPage selectPizza(String pizzaName, String dough, int size){
        selectPizzaName(pizzaName);
        selectPizzaDough(dough);
        selectPizzaSize(size);
//        pressAddToCard();
        return new PizzaPage(driver);
    }

}


