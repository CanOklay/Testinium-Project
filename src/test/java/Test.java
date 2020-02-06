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

        /*driver.navigate().to("https://www.n11.com/giris-yap");

        driver.findElement(By.id("email")).sendKeys("testiniumproje@gmail.com");
        thread.sleep(2000);

        driver.findElement(By.id("password")).sendKeys("xyzf09456");
        thread.sleep(2000);

        driver.findElement(By.id("loginButton")).click();

        //driver.findElement(By.className("radius")).click();

       // String title = driver.findElement(By.cssSelector(".example h2")).getText();;

        thread.sleep(2000);
        String title = driver.findElement(By.id("footerSeoContentSummary")).getText();

        assertThat(title, is("Online Alışverişin Adresi n11.com\n“Alışverişin uğurlu adresi” n11.com; Türkiye’deki başarılı online alışveriş siteleri arasında yer almaktadır. Yaşamın her alanındaki ihtiyaçlarınızı kolayca bulabileceğiniz n11.com’da 50.000’i aşkın mağazanın ürünü bulunmaktadır. İnternet alışveriş sitesi ve e-ticaret denildiğinde akla gelen ilk markalardan biri olmayı başaran n11.com’da onlarca farklı kategoride binlerce ürün beğeninize sunulmaktadır. Müşterilere güven ve kolaylık, mağazalara ise destek ve özen üzerine dayalı değer önerileri sunan n11.com’da siz de avantajlarla dolu internet alışverişi keyfi sürebilirsiniz.\nAradığınız Her Şeyi Bulabileceğiniz Bir İnternet Alışverişi Sitesi\nKişisel bakımınızdan araç bakımınıza, yaşam alanlarınızı düzenlemeden spor aktivitelerinize kadar hayatın pek çok alanında ihtiyacınız olacak tüm ürünleri internet alışverişinin ilk adresi n11.com’da bulabilirsiniz. Giyim & Ayakkabı, Elektronik, Ev & Yaşam, Anne & Bebek, Kozmetik & Kişisel Bakım, Mücevher & Saat, Spor & Outdoor, Kitap, Müzik, Film & Oyun, Bilet, Tatil & Eğlence ve Otomotiv & Motosiklet kategorilerimize göz atarak alacağınız ürünü inceleyebilir, fiyatlarını görebilir ve hemen kolayca sipariş edebilirsiniz.\nDevamını Göster ..."));
        //Search
        driver.findElement(By.id("searchData")).sendKeys("dizüstü bilgisayar");
        thread.sleep(2000);

        driver.findElement(By.className("searchBtn")).click();
        thread.sleep(2000);


        //2. sayfaya geçiş
        driver.findElement(By.linkText("2")).click();
        thread.sleep(2000);

        String currentUrl = driver.getCurrentUrl();

        assertThat(currentUrl, is("https://www.n11.com/arama?q=diz%C3%BCst%C3%BC+bilgisayar&pg=2"));

        //Random ürün
        WebElement pro = driver.findElement(By.id("view"));
        List<WebElement> elements = pro.findElements(By.className("column"));

        WebElement plink = elements.get(2).findElement(By.className("plink"));
        plink.click();
        thread.sleep(2000);*/

        /*String webElement;
        List<WebElement> products = driver.findElements(By.className("productName" , "productName bold"));
        ArrayList<Integer> productsNotEqualToZero = new ArrayList<Integer>();

        for(webElement:products){
            if(!webElement.getAttribute("quantity").equals("0")){


                productsNotEqualToZero.add(Integer.parseInt(webElement.getAttribute("quantity"));
            }
        }
        Random random = new Random();
        int result = random.nextInt(productsNotEqualToZero.size());
        products.get(result).click;*/


    //Sepete ekleme
        /*driver.findElement(By.cssSelector("#contentProDetail > div > div.proDetailArea > div.proDetail > div.paymentDetail > div.btnHolder > a.btn.btnGrey.btnAddBasket")).click();
        thread.sleep(2000);

        driver.findElement(By.className("myBasket")).click();
        thread.sleep(2000);

        String title1 = driver.findElement(By.id("js-goToPaymentBtn")).getText();

        assertThat(title1, is("Ödemeye Geç"));

        //Karşılaştırma
        WebElement basketPrice = driver.findElement(By.className("priceArea"));
        WebElement productPrice = driver.findElement(By.className("newPrice"));

        if (basketPrice == productPrice) {
            return;
        }


        //Sayı arttırma
        driver.findElement(By.xpath("//*[@id=\"newCheckout\"]/div/div[1]/div[2]/div[1]/section/table[2]/tbody/tr/td[3]/div[1]/div/span[1]")).click();
        thread.sleep(2000);

        String title2 = driver.findElement(By.id("quantity_126770942489")).getText();

        assertThat(title2, is("2"));

        //Ürünü sepetten silme
        driver.findElement(By.cssSelector("#newCheckout > div > div.checkoutContainer > div.left > div.cartUpdatePartContainer > section > table.productGroup > tbody > tr > td.prodDetail > div.prodInfo > div.prodAction > span.removeProd.svgIcon.svgIcon_trash")).click();
        thread.sleep(2000);

        String title3 = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[2]/div/div[1]/div[1]/h2"));

        assertThat(title3, is("Sepetiniz Boş"));*/

}

