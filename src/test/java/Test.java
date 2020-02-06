import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Test {
    public static final String BASKET_PRICE = "#newCheckout > div > div.checkoutContainer > div.left > div.cartUpdatePartContainer > section > table:nth-child(5) > tbody > tr > td.prodPrice > div.priceTag > div";
    public static final String LIST_PRICE = "newPrice";

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
        //www.n11.com sitesi açılır.
        LoginPage loginPage = new LoginPage(driver);

        //Ana sayfanın açıldığı kontrol edilir. Siteye login olunur.
        loginPage.login("testiniumproje@gmail.com", "xyzf09456");

        //Login işlemi kontrol edilir.
        String mainPageUrl= driver.getCurrentUrl();
        thread.sleep(2000);

        assertThat(mainPageUrl, is("https://www.n11.com/"));

        //Arama kutucuğuna bilgisayar kelimesi girilir.
        HomePage homePage = new HomePage(driver);
        homePage.search("dizüstü bilgisayar");

        //Arama sonuçları sayfasından 2.sayfa açılır.
        ProductListPage productListPage = new ProductListPage(driver);
        productListPage.nextPage();

        //2.sayfanın açıldığı kontrol edilir.
        String laptopSearchSecondPage = driver.getCurrentUrl();
        thread.sleep(2000);

        assertThat(laptopSearchSecondPage, is("https://www.n11.com/arama?q=diz%C3%BCst%C3%BC+bilgisayar&pg=2"));

        //Sonuca göre sergilenen ürünlerden rastgele bir ürün seçilir.
        productListPage.pickRandomProduct();
        WebElement productPrice = driver.findElement(By.className(LIST_PRICE));

        //Seçilen ürün sepete eklenir.
        ProductDetailPage productDetailPage = new ProductDetailPage(driver);
        productDetailPage.addBasket();
        WebElement basketPrice = driver.findElement(By.cssSelector(BASKET_PRICE));

        //Ürün†sayfasındaki fiyat ile sepette yer alan ürün fiyatının doğruluğu karşılaştırılır.
        if (basketPrice == productPrice) {
            return;
        }
        BasketPage basketPage = new BasketPage(driver);
        //basketPage.comparePrices();

        //Adet arttırılarak ürün adedinin 2 olduğu doğrulanır.
        basketPage.increaseNumber();
        String title3 = driver.findElement(By.name("quantity")).getAttribute("value");
        thread.sleep(2000);

        assertThat(title3, is("2"));

        //Ürün sepetten silinerek sepetin boş olduğu kontrol edilir.
        basketPage.deleteProducts();

        String title4 = driver.findElement(By.className("cartEmptyText")).getText();
        thread.sleep(2000);

        assertThat(title4, containsString("Sepetiniz Boş"));
    }

    @After
    public void teardown() {
        driver.close();
    }

}