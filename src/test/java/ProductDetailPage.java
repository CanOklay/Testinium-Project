import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProductDetailPage {

    public static final String ADD_BASKET = "#contentProDetail > div > div.proDetailArea > div.proDetail > div.paymentDetail > div.btnHolder > a.btn.btnGrey.btnAddBasket";
    public static final String MY_BASKET = "myBasket";

    private WebDriver driver;
    Thread thread;

    @FindBy(id = ADD_BASKET)
    private WebElement addBasket;

    @FindBy(id = MY_BASKET)
    private WebElement myBasket;

    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addBasket() throws InterruptedException {
        this.addBasket.click();
        thread.sleep(2000);

        this.myBasket.click();
        thread.sleep(2000);
    }
}
