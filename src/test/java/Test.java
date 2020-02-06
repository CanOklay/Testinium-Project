import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Test {

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

        assertThat(mainPageUrl, is("https://www.n11.com/"));
        thread.sleep(2000);

        //Arama kutucuğuna bilgisayar kelimesi girilir.
        HomePage homePage = new HomePage(driver);
        homePage.search("dizüstü bilgisayar");
        /*String laptopSearchPageUrl = driver.getCurrentUrl();

        assertThat(laptopSearchPageUrl, is("https://www.n11.com/arama?q=diz%C3%BCst%C3%BC+bilgisayar"));*/

        //Arama sonuçları sayfasından 2.sayfa açılır.
        ProductListPage productListPage = new ProductListPage(driver);
        productListPage.nextPage();
        //2.sayfanın açıldığı kontrol edilir.
        String laptopSearchSecondPage = driver.getCurrentUrl();

        assertThat(laptopSearchSecondPage, is("https://www.n11.com/arama?q=diz%C3%BCst%C3%BC+bilgisayar&pg=2"));

        //Sonuca göre sergilenen ürünlerden rastgele bir ürün seçilir.
        productListPage.pickRandomProduct();

        //Seçilen ürün sepete eklenir.
        ProductDetailPage productDetailPage = new ProductDetailPage(driver);
        productDetailPage.addBasket();

        //
        BasketPage basketPage = new BasketPage(driver);
        basketPage.comparePrices();
        basketPage.increaseNumber();

        String title3 = driver.findElement(By.name("quantity")).getAttribute("value");

        assertThat(title3, is("2"));

        basketPage.deleteProducts();

        String title4 = driver.findElement(By.className("cartEmptyText")).getText();

        assertThat(title4, containsString("Sepetiniz Boş"));
    }

    @After
    public void teardown() {
        driver.close();
    }
}

