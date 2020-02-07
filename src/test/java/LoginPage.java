import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    public static final String LOGIN_URL = "https://www.n11.com/giris-yap";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    public static final String LOGIN_BUTTON = "loginButton";

    private WebDriver driver;

    @FindBy(id = EMAIL)
    private WebElement email;

    @FindBy(id = PASSWORD)
    private WebElement password;

    @FindBy(id = LOGIN_BUTTON)
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        driver.navigate().to(LOGIN_URL);
        this.email.sendKeys(username);
        this.password.sendKeys(password);
        this.loginButton.click();
    }
}
