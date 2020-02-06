import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AddBasket {

    public static final String ADD_BASKET = "#contentProDetail > div > div.proDetailArea > div.proDetail > div.paymentDetail > div.btnHolder > a.btn.btnGrey.btnAddBasket";
    public static final String MY_BASKET = "myBasket";
    private WebDriver driver;
    Thread thread;

    public AddBasket(WebDriver driver) {
        this.driver = driver;
    }

    public void addBasket () throws InterruptedException {

        driver.findElement(By.cssSelector(ADD_BASKET)).click();
        thread.sleep(2000);

        driver.findElement(By.className(MY_BASKET)).click();
        thread.sleep(2000);

    }
}
