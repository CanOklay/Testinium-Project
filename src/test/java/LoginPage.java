import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LoginPage {

    public static final String LOGIN_URL = "https://www.n11.com/giris-yap";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    public static final String LOGIN_BUTTON = "loginButton";
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login (String username, String password){

        driver.navigate().to(LOGIN_URL);
        driver.findElement(By.id(EMAIL)).sendKeys(username);
        driver.findElement(By.id(PASSWORD)).sendKeys(password);
        driver.findElement(By.id(LOGIN_BUTTON)).click();

        //driver.findElement(By.className("radius")).click();

        // String title = driver.findElement(By.cssSelector(".example h2")).getText();;
    }
}
