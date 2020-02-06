import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProductListPage {

    public static final String VIEW = "view";
    public static final String COLUMN = "column";
    public static final String LINK = "plink";
    private WebDriver driver;
    Thread thread;

    public ProductListPage(WebDriver driver) {
        this.driver = driver;
    }

    public void nextPage () throws InterruptedException {

        driver.findElement(By.linkText("2")).click();
        thread.sleep(2000);

    }

    public void pickProduct () throws InterruptedException {

        WebElement pro = driver.findElement(By.id(VIEW));
        List<WebElement> elements = pro.findElements(By.className(COLUMN));

        WebElement plink = elements.get(2).findElement(By.className(LINK));
        plink.click();
        thread.sleep(2000);
    }
}
