import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;


public class ProductListPage {

    public static final String VIEW = "view";
    public static final String COLUMN = "column";
    public static final String LINK = "plink";
    public static final String PAGE_TWO = "2";

    private WebDriver driver;
    Thread thread;

    @FindBy(linkText = PAGE_TWO)
    private WebElement pageTwo;

    @FindBy(id = VIEW)
    private WebElement view;

    @FindBy(id = COLUMN)
    private WebElement column;

    public ProductListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void nextPage() throws InterruptedException {
        this.pageTwo.click();
        thread.sleep(2000);
    }

    public void pickRandomProduct() throws InterruptedException {
        List<WebElement> elements = this.view.findElements(By.className(COLUMN));

        Random random = new Random();
        WebElement link = elements.get(random.nextInt(elements.size())).findElement(By.className(LINK));
        link.click();
        thread.sleep(2000);
    }
}
