import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {

    public static final String SEARCH = "searchData";
    public static final String SEARCH_BUTTON = "searchBtn";
    private WebDriver driver;
    Thread thread;

    @FindBy(id = SEARCH)
    private WebElement search;

    @FindBy(className = SEARCH_BUTTON)
    private WebElement searchButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void search (String searchText) throws InterruptedException {
        this.search.sendKeys(searchText);
        thread.sleep(2000);

        this.searchButton.click();
        thread.sleep(2000);
    }
}
