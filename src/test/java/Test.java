import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Test {
    public static final String BASKET_PRICE = "#newCheckout > div > div.checkoutContainer > div.left > div.cartUpdatePartContainer > section > table:nth-child(5) > tbody > tr > td.prodPrice > div.priceTag > div";
    public static final String LIST_PRICE = "#contentProDetail > div > div.proDetailArea > div.proDetail > div.paymentDetail > div.price-cover > div > div.priceDetail > div > ins";

    private WebDriver driver;
    Thread thread;

    @Before
    public void setup() {
        String pathToChromeDriver = "lib/chromedriver";
        System.setProperty("webdriver.chrome.driver", pathToChromeDriver);
        driver = new ChromeDriver();
    }

    @org.junit.Test
    public void test() throws InterruptedException {
        //Opens www.n11.com site.
        LoginPage loginPage = new LoginPage(driver);

        //Checks that the login page is opened.
        loginPage.login("testiniumproje@gmail.com", "xyzf09456");

        //Checks that the login is successfully done.
        String mainPageUrl= driver.getCurrentUrl();
        thread.sleep(2000);

        assertThat(mainPageUrl, is("https://www.n11.com/"));

        //Writes 'laptop' to the search box.
        HomePage homePage = new HomePage(driver);
        homePage.search("bilgisayar");

        //Opens 2. page from the searched result page.
        ProductListPage productListPage = new ProductListPage(driver);
        productListPage.nextPage();

        //Checks that the second page is opened.
        String laptopSearchSecondPage = driver.getCurrentUrl();
        thread.sleep(2000);

        assertThat(laptopSearchSecondPage, is("https://www.n11.com/arama?q=bilgisayar&pg=2"));

        //Picks a random product among products that displayed in search result.
        productListPage.pickRandomProduct();
        String productPrice = driver.findElement(By.cssSelector(LIST_PRICE)).getText();

        //Adds the product to the basket.
        ProductDetailPage productDetailPage = new ProductDetailPage(driver);
        productDetailPage.addBasket();
        String basketPrice = driver.findElement(By.cssSelector(BASKET_PRICE)).getText();

        //Compares the price of product from the list and basket that have correct match.
        assertThat(productPrice, is(basketPrice));
        BasketPage basketPage = new BasketPage(driver);

        //Increases the amount of the product and checks if the amounts is 2 or not.
        basketPage.increaseNumber();
        String quantityCheck = driver.findElement(By.name("quantity")).getAttribute("value");
        thread.sleep(2000);

        assertThat(quantityCheck, is("2"));

        //Deletes the products from the basket and checks that the basket is empty.
        basketPage.deleteProducts();

        String cartEmptyCheck = driver.findElement(By.className("cartEmptyText")).getText();
        thread.sleep(2000);

        assertThat(cartEmptyCheck, containsString("Sepetiniz Boş"));
    }

    @After
    public void teardown() {
        driver.close();
    }
}