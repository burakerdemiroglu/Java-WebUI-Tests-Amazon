package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Amazon {

    WebDriver driver;
    WebDriverWait wait;


    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com.tr/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void test() throws InterruptedException {
        //ana sayfada oldugun  kontrol  edildi.
        WebElement searchControl = driver.findElement(By.id("nav-search-submit-button"));
        Assert.assertTrue(searchControl.isDisplayed());
        //çerezleri kabul et denildi.
        WebElement cookie = driver.findElement(By.id("sp-cc-accept"));
        cookie.click();
        //log ın basıldı.
        WebElement logIn = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        logIn.click();
        //e-mail kısmı dolduruldu
        WebElement logLetter = driver.findElement(By.xpath("//div/input[@type='email']"));
        logLetter.sendKeys("ornekmail@gmail.com");
        // devam et butonuna basıldı
        WebElement continu = driver.findElement(By.xpath("//span/input[@id='continue']"));
        continu.click();
        //şifre yazıldı.
        WebElement password = driver.findElement(By.xpath("//div/input[@type='password']"));
        password.sendKeys("orneksifre");
        //giriş yapıldı.
        WebElement logButton = driver.findElement(By.id("signInSubmit"));
        logButton.click();
        //giriş yapıldıgı kontrol edildi.
        WebElement logControl = driver.findElement(By.xpath("//div/span[contains(text(),'Yılmaz')]"));
        Assert.assertEquals("Yılmaz", logControl.getText());
        //alttaki işlemde mouse over yaparak tıklamadan menüyü gösterdik.
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(By.xpath("//div/span[contains(text(),'Yılmaz')]"));
        action.moveToElement(we).build().perform();
        //Liste oluşturana tıklar.
        WebElement newList = driver.findElement(By.xpath("//a/span[contains(text(),'Liste Oluşturun')]"));
        newList.click();
        //listeye isim yazılır.
        WebElement listName = driver.findElement(By.id("list-name"));
        listName.clear();
        listName.sendKeys("Virgosol Liste");
        //yapılına iştem okeylenir.
        WebElement listOke = driver.findElement(By.xpath("(//input[@class='a-button-input a-declarative'])[3]"));
        Thread.sleep(1000);
        listOke.click();
        Thread.sleep(1000);
        //Ana sayfaya gidldi.
        WebElement homePage = driver.findElement(By.id("nav-logo-sprites"));
        homePage.click();
        //tab satırından Bilgisayar seçildi.
        WebElement computer = driver.findElement(By.xpath("//a[contains(text(),'Bilgisayar')]"));
        computer.click();
        //Bilgisayar seçildigi kontrol edildi.
        WebElement computerLetter = driver.findElement(By.cssSelector(".pageBanner"));
        Assert.assertTrue(computerLetter.isDisplayed());
        //Arema alanına msi yazılır.
        WebElement searching = driver.findElement(By.id("twotabsearchtextbox"));
        searching.sendKeys("Msi");
        //yazım aratıldı.
        WebElement searchOke = driver.findElement(By.id("nav-search-submit-button"));
        searchOke.click();
        //sonuçlar sayfası onaylandı.
        WebElement result = driver.findElement(By.xpath("//div/span[contains(text(),'SONUÇLAR')]"));
        Assert.assertTrue(result.isDisplayed());
        //page 2 ye scroll edildi.
        WebElement twoPage = driver.findElement(By.cssSelector(".s-pagination-button[aria-label='2 sayfasına git']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", twoPage);
        twoPage.click();
        //page 2 de oldugu kontrol edildi:
        WebElement twoPageControl = driver.findElement(By.xpath("//div/span[contains(text(),'5.000 üzeri sonuç arasından 25-48 arası gösteriliyor. Aranan ürün:')]"));
        Assert.assertTrue(twoPageControl.isDisplayed());
        //2. ürün seçildi.
        WebElement twoProduct = driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[2]"));
        twoProduct.click();
        //listeye eklendi.
        WebElement listAdd = driver.findElement(By.id("add-to-wishlist-button"));
        listAdd.click();
        //virgosole eklendi.
        WebElement virgosolOke = driver.findElement(By.xpath("(//span[@class='a-size-small atwl-hz-dd-list-name a-nowrap'])[2]"));
        virgosolOke.click();
        //listelere görüntüleyine tıklandı.
        WebElement listView = driver.findElement(By.xpath("//span/a[contains(text(),'Listenizi Görüntüleyin')]"));
        listView.click();
        //ürünün varlıgı kontrol edildi.
        WebElement itemName = driver.findElement(By.xpath("//h2[@class='a-size-base']"));
        Assert.assertTrue(itemName.isDisplayed());
        //alışverriş listesine tıklandı.
        WebElement shoppingList = driver.findElement(By.xpath("(//div/span[contains(text(),'Alışveriş Listesi')])[1]"));
        shoppingList.click();
        //Listenın açıldıgı kontrol edildi.
        WebElement shoppingListControl = driver.findElement(By.id("profile-list-name"));
        Assert.assertTrue(shoppingListControl.isDisplayed());
        //virgosol listesi açıldı
        WebElement virgosolListView = driver.findElement(By.xpath("//span[contains(text(),'Virgosol Liste')]"));
        virgosolListView.click();
        //listedki ürün silindi.
        WebElement productDelete = driver.findElement(By.xpath("(//span[@class='a-button a-button-base a-button-small'])[3]"));
        productDelete.click();
        //Silindigi kontrol edildi.
        WebElement producDeleteControl = driver.findElement(By.xpath("//div[contains(text(),'Silindi')]"));
        Assert.assertTrue(producDeleteControl.isDisplayed());
        //üye çıkış işlemi yapılır.
        Actions act = new Actions(driver);
        WebElement exit2 = driver.findElement(By.xpath("//div/span[contains(text(),'Yılmaz')]"));
        act.moveToElement(exit2).build().perform();
        //Çıkış yap butonuna basılır.
        WebElement exitButton = driver.findElement(By.xpath("//span[contains(text(),'Çıkış Yap')]"));
        exitButton.click();
        //çıkış yapıldıgı kontrol edilir.
        WebElement exitControl = driver.findElement(By.xpath("//h1[@class='a-spacing-small']"));
        Assert.assertTrue(exitControl.isDisplayed());
    }


    @After
    public void teardown() {

        driver.close();

    }

}
