import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
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


        LoginPage login = new LoginPage(driver);
        login.login("testiniumproje@gmail.com", "xyzf09456");

        thread.sleep(2000);
        String title = driver.findElement(By.id("footerSeoContentSummary")).getText();

        assertThat(title, is("Online Alışverişin Adresi n11.com\n“Alışverişin uğurlu adresi” n11.com; Türkiye’deki başarılı online alışveriş siteleri arasında yer almaktadır. Yaşamın her alanındaki ihtiyaçlarınızı kolayca bulabileceğiniz n11.com’da 50.000’i aşkın mağazanın ürünü bulunmaktadır. İnternet alışveriş sitesi ve e-ticaret denildiğinde akla gelen ilk markalardan biri olmayı başaran n11.com’da onlarca farklı kategoride binlerce ürün beğeninize sunulmaktadır. Müşterilere güven ve kolaylık, mağazalara ise destek ve özen üzerine dayalı değer önerileri sunan n11.com’da siz de avantajlarla dolu internet alışverişi keyfi sürebilirsiniz.\nAradığınız Her Şeyi Bulabileceğiniz Bir İnternet Alışverişi Sitesi\nKişisel bakımınızdan araç bakımınıza, yaşam alanlarınızı düzenlemeden spor aktivitelerinize kadar hayatın pek çok alanında ihtiyacınız olacak tüm ürünleri internet alışverişinin ilk adresi n11.com’da bulabilirsiniz. Giyim & Ayakkabı, Elektronik, Ev & Yaşam, Anne & Bebek, Kozmetik & Kişisel Bakım, Mücevher & Saat, Spor & Outdoor, Kitap, Müzik, Film & Oyun, Bilet, Tatil & Eğlence ve Otomotiv & Motosiklet kategorilerimize göz atarak alacağınız ürünü inceleyebilir, fiyatlarını görebilir ve hemen kolayca sipariş edebilirsiniz.\nDevamını Göster ..."));

        HomePage homePage = new HomePage(driver);
        homePage.search("dizüstü bilgisayar");
        String currentPage = driver.getCurrentUrl();

        assertThat(currentPage, is("https://www.n11.com/arama?q=diz%C3%BCst%C3%BC+bilgisayar"));

        ProductListPage productListPage = new ProductListPage(driver);
        productListPage.nextPage();

        String currentPage2 = driver.getCurrentUrl();

        assertThat(currentPage2, is("https://www.n11.com/arama?q=diz%C3%BCst%C3%BC+bilgisayar&pg=2"));

        productListPage.pickProduct();

        AddBasket addBasket = new AddBasket(driver);
        addBasket.addBasket();

        String title2 = driver.findElement(By.id("js-goToPaymentBtn")).getText();

        assertThat(title2, is("Ödemeye Geç"));

        Basket basket = new Basket(driver);
        basket.comparePrices();
        basket.increaseNumber();

        String title3 = driver.findElement(By.id("quantity_126770942489")).getText();

        assertThat(title3, is("2"));

        basket.deleteProducts();

        String title4 = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[2]/div/div[1]/div[1]/h2"));

        assertThat(title4, is("Sepetiniz Boş"));


    }

    @After
    public void teardown() {

        driver.close();
    }
}

