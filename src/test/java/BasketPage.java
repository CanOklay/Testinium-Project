import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class BasketPage {

    public static final String BASKET_PRICE = "#newCheckout > div > div.checkoutContainer > div.left > div.cartUpdatePartContainer > section > table:nth-child(5) > tbody > tr > td.prodPrice > div.priceTag > div";
    public static final String LIST_PRICE = "newPrice";
    public static final String DELETE_BUTTON = "//*[@id=\"newCheckout\"]/div/div[1]/div[2]/div[1]/section/table[2]/tbody/tr/td[1]/div[3]/div[2]/span[1]";
    public static final String PLUS_BUTTON = "#newCheckout > div > div.checkoutContainer > div.left > div.cartUpdatePartContainer > section > table.productGroup > tbody > tr > td.prodPrice > div.spinnerField > div > span.spinnerUp.spinnerArrow";
    private WebDriver driver;
    Thread thread;

    public BasketPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void comparePrices() {
        WebElement basketPrice = driver.findElement(By.cssSelector(BASKET_PRICE));
        WebElement productPrice = driver.findElement(By.className(LIST_PRICE));
        if (basketPrice == productPrice) {
            return;
        }
    }

    public void increaseNumber() throws InterruptedException {
        driver.findElement(By.cssSelector(PLUS_BUTTON)).click();
        thread.sleep(2000);
    }

    public void deleteProducts() throws InterruptedException {
        driver.findElement(By.xpath(DELETE_BUTTON)).click();
        thread.sleep(2000);
    }
}
