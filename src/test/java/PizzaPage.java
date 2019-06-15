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
        WebElement pizzaSize;
//        pizzaSize = driver.findElement(By.xpath("//span[.='" + size + "см" + "']/../.."));
        pizzaSize = driver.findElement(By.xpath("//span[.='" + size + "см" + "']"));
        pizzaSize.click();
        return new PizzaPage(driver);
    }


    //Нажатие на кнопку "В корзину"
//    private void pressAddToCard() {
//        driver.findElement(By.xpath("../../../..//a[.='+ в корзину']")).click();
//    }


    //Выбор пиццы с параметрами.
//    private PizzaPage selectPizza(String pizzaName, String dough, int size) {
//        selectPizzaName(pizzaName);
//        selectPizzaDough(dough);
//        selectPizzaSize(size);
//        return new PizzaPage(driver);
//    }


//    //Добавление Пицца в корзину по Имени
//    public PizzaPage addToСart(String pizzaName){
//        WebElement target;
//        target = driver.findElement(By.xpath("//span[.='" + pizzaName + "']/../../../..//a[.='+ в корзину']"));
//        target.click();
//        return new PizzaPage(driver);
//    }


    //Выбираем Пиццу

    public PizzaPage takePizza() {
//        driver.findElement(By.xpath("//*[@id='item6']/div[3]/div[2]/div[2]/div[8]/div/a")).click();
        driver.findElement(By.xpath("//*[@data-bind='click: add2cart.bind($data, $element)']"));
        return new PizzaPage(driver);
    }


    public PizzaPage changePizza(String pizzaName, String dough, int size) {
        WebElement name;
        name = driver.findElement(By.xpath(".//span[.='" + pizzaName + "']"));
        name.isSelected();

        WebElement testo;
//        testo = driver.findElement(By.xpath("//a[.='" + dough + "']//../..//span[.='" + size + "см" + "']"));
        testo = driver.findElement(By.xpath("//a[.='" + dough + "']"));
        testo.click();

        WebElement razmer;
//        razmer = driver.findElement(By.xpath("//span[.='" + size + "см" + "']"));
//        razmer = driver.findElement(By.xpath("//a[.='" + dough + "']/../../..//div[@class='size active']/../..//span[.='" + size + "см" + "']/../.."));
        razmer = driver.findElement(By.xpath("//a[.='" + dough + "']/../../../../..//span[.='" + size + "см" + "']/../.."));
        razmer.click();

        return takePizza();

    }


//    public final static By low = By.xpath("//div[@class='size active']/../..//span[.='26см']/../..");
//    public final static By middle = By.xpath("//div[@class='size active']/../..//span[.='30см']/../..");
//    public final static By high = By.xpath("//div[@class='size active']/../..//span[.='40см']/../..");

}
