import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class Jtest {

    private HomePage hp;
    private PizzaPage pp;


    @Test
    public void hpOpen() {
        hp = new HomePage(new ChromeDriver());

        hp.getDriver().get("https://pizzasushiwok.ru/");

        //Авторизация
        hp.pressLogin();
        hp.pressAltButton();
        hp.loginAs("89165833338", "shuter13");
        hp.getSettings().setTimeout();
        pp = hp.pressPizzaHeadline();
        pp.selectPizza("Пицца Пепперони", "Тонкое", 30);

    }
}
