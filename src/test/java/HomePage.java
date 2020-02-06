import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import javax.print.DocFlavor;

public class HomePage {

    public static final String SEARCH = "searchData";
    public static final String SEARCH_BUTTON = "searchBtn";
    private WebDriver driver;
    Thread thread;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void search (String searchText) throws InterruptedException {

        driver.findElement(By.id(SEARCH)).sendKeys(searchText);
        thread.sleep(2000);

        driver.findElement(By.className(SEARCH_BUTTON)).click();
        thread.sleep(2000);
    }
}
