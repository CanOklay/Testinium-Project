import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Basket {

    public static final String BASKET_PRICE = "priceArea";
    public static final String LIST_PRICE = "newPrice";
    public static final String PLUS_BUTTON = "//*[@id=\"newCheckout\"]/div/div[1]/div[2]/div[1]/section/table[2]/tbody/tr/td[3]/div[1]/div/span[1]";
    public static final String DELETE_BUTTON = "#newCheckout > div > div.checkoutContainer > div.left > div.cartUpdatePartContainer > section > table.productGroup > tbody > tr > td.prodDetail > div.prodInfo > div.prodAction > span.removeProd.svgIcon.svgIcon_trash";
    private WebDriver driver;
    Thread thread;

    public Basket(WebDriver driver) {
        this.driver = driver;
    }


    public void comparePrices () {

        WebElement basketPrice = driver.findElement(By.className(BASKET_PRICE));
        WebElement productPrice = driver.findElement(By.className(LIST_PRICE));

        if (basketPrice == productPrice) {
            return;
        }
    }

    public void increaseNumber() throws InterruptedException {

        driver.findElement(By.xpath(PLUS_BUTTON)).click();
        thread.sleep(2000);

    }

    public void deleteProducts() throws InterruptedException {

        driver.findElement(By.cssSelector(DELETE_BUTTON)).click();
        thread.sleep(2000);

    }
}
