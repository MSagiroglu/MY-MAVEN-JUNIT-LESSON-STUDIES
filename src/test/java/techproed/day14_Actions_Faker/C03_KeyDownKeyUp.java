package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C03_KeyDownKeyUp extends TestBase {
    @Test
    public void test01() {
        //Google anasayfasına gidelim
        driver.get("https://google.com");
        //arama kutusunda shift tusuna basılı olarak selenium yazdıralım ve shift tuşunu serbest bırakarak java yazdıralım
        WebElement aramaKutusu=driver.findElement(By.id("APjFqb"));
        Actions actions=new Actions(driver);
        actions.keyDown(aramaKutusu, Keys.SHIFT).//--> Arama Kutusunda shift tuşuna bastık
                sendKeys("selenium").//-->selenium metnini shift tuşuna basılı kaldığı için büyük yazdı
                keyUp(Keys.SHIFT).//--> shift tusunu serbest bıraktık
                sendKeys("-java",Keys.ENTER).//--> bu kismi shift'i serbest bıraktığımız için küçük yazdı
                perform();


    }
         /*
         mouse islemlerini kullanmak icin (pageup-down, double click, sag click, mouseu götür) actions kullaniriz.
         klavye islemlerinde actions a gerek yoktur
         */

    @Test
    public void test02() {
        //Google anasayfasına gidelim
        driver.get("https://google.com");

        //arama kutusunda shift tusuna basılı olarak selenim yazdıralım ve shift tuşunu serbest bırakarak java yazdıralım
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys(Keys.SHIFT,"selenium",Keys.SHIFT,"-java",Keys.ENTER);
    /*
    Mause işlemleri için actions class'ını kullanmamız gerekir. Fakat bir metin kutusundaki klavye işlemleri için
    actions class'ına kullanmadan sendKeys() methodu ile de istediğimiz bir metni büyük yazdırabilir,
    hatta bir den fazla klavye tuşlana bastırabiliriz. Yukardaki örnekte sendKeys() methodu ile Keys.SHIFT diyerek
    sonrasında yazdırmak istediğimiz metni küçük harfle yazmamıza rağmen büyük harflerle yazdırdı, tekrar Keys.SHIFT
    kullanarak shift tuşunu serbest bırakmış olduk
     */
    }

    @Test
    public void test03() {
        //google sayfasına gidelim
        driver.get("https://google.com");
        // Arama kutusuna "Selenium" yazın ve Enter tuşuna basın
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys("Selenium",Keys.ENTER);
        // Sayfayı bekleyin
        bekle(4);
        // Arattığımız kelimeyi arama kutusundan ctrl+x ile keselim
        driver.findElement(By.xpath("//*[@class='gLFyf']")).
                sendKeys(Keys.CONTROL,"a");//-->Metni kesebilmek için önce ctrl+a ile seçmemiz gerekir
        driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys(Keys.CONTROL,"x");
        //Tekrar google sayfasına gidip kestiğimiz kelimeyi ctrl+v ile yapıştırıp tekrar aratalım
        driver.navigate().to("https://google.com");
        aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys(Keys.CONTROL,"v",Keys.ENTER);
        driver.navigate().to("https://google.com");
        aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys("Selenium",Keys.CONTROL,"a",Keys.CONTROL,"x");
    }
}
