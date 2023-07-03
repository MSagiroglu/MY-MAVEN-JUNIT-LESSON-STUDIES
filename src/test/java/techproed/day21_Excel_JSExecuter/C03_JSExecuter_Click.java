package techproed.day21_Excel_JSExecuter;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C03_JSExecuter_Click extends TestBase {
     /*
        Bir web sayfasında bazı webelementler oluşturulurken JAVASCRIPT kodlarıyla oluşturulmuş olabilir.
    Bu webelementleri handle edebilmek için JavaScriptExecutor arayüzünü kullanmamız gerekir.
    Bir webelement JavaScript kodları ile yazılmamış olsada javaScriptExecutor ile o webelementi handle edebiliriz.
    Normal bildiğimiz methodlardan daha yavaş çalışacağı için bildiğimiz methodlar işimizi görüyorsa onları kullanırız.
    <script> tagi ile oluşturulmuş olan web elementleri de js executor ile handle edebiliriz.
     */

    @Test
    public void test01() {
        //Amazon sayfasına gidiniz
        driver.get("https://amazon.com");
        bekle(3);

        //sell linkinin resmini alalım
        WebElement sellLinki = driver.findElement(By.xpath("//*[.='Sell']"));
        webElementResmi(sellLinki);

        //Sell linkine js executor kullanarak tıklayınız
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",sellLinki);

        //Başlığın Sell içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("Sell"));

        //Sayfanın resmini alalım
        tumSayfaResmi();
    }

    @Test
    public void test02() {
        //Amazon sayfasına gidiniz
        driver.get("https://amazon.com");
        bekle(3);

        //sell linkinin resmini alalım
        WebElement sellLinki = driver.findElement(By.xpath("//*[.='Sell']"));
        webElementResmi(sellLinki);

        //Sell linkine tıklayınız
        sellLinki.click();

        //Başlığın Sell içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("Sell"));

        //Sayfanın resmini alalım
        tumSayfaResmi();
    }

    @Test
    public void test03() {
        //Amazon sayfasına gidiniz
        driver.get("https://amazon.com");
        bekle(3);

        //sell linkinin resmini alalım
        driver.findElement(By.xpath("(//*[@class='a-button-inner'])[1]")).click();//-->uyarı kapatıldı
        WebElement sellLinki = driver.findElement(By.xpath("//*[.='Sell']"));
        webElementResmi(sellLinki);

        //Sell linkine js executor kullanarak tıklayınız
        click(sellLinki);

        //Başlığın Sell içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("Sell"));

        //Sayfanın resmini alalım
        tumSayfaResmi();

    }
}
