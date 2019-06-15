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

    public WebSettings getSettings() {
        return settings;
    }

    public WebDriver getDriver() {
        return driver;
    }


    //Выбор пиццы по имени

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
        WebElement pizzaLenght;
        pizzaLenght = driver.findElement(By.xpath("//span[.='" + size + "см" + "']"));
        pizzaLenght.click();
        return new PizzaPage(driver);
    }

    //Нажатие на кнопку "В корзину"
    public void pressAddToCard() {
        driver.findElement(By.xpath("../../../..//a[.='+ в корзину']")).click();
    }



    //Выбор пиццы с параметрами.
    public PizzaPage selectPizza(String pizzaName, String dough, int size) {
        selectPizzaName(pizzaName);
        selectPizzaDough(dough);
        selectPizzaSize(size);
        return new PizzaPage(driver);
    }







    //Добавление Пицца в корзину по Имени
    public PizzaPage addToСart(String pizzaName){
        WebElement target;
        target = driver.findElement(By.xpath("//span[.='" + pizzaName + "']/../../../..//a[.='+ в корзину']"));
        target.click();
        return new PizzaPage(driver);
    }




}
