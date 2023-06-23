package techproed.day18_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import techproed.utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_TumSayfaResmi extends TestBase {
    /*
    Selenium'da tüm ekran görüntüsünü alabilmek için TakeScreenShot arayüzünden bir obje oluşturup driver'a
    eşitleriz.Arayüzler farklı olduğu için TypeCasting yaparız ve bu oluşturduğumuz obje ile getScreenShotAs()
    metodu ile sayfanın resmini alırız. Almış olduğumuz resmi projemizde nereye kaydedeceksek oranın ypolumu
    brlirtiriz.
     */
    @Test
    public void test01() throws IOException {
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        bekle(2);

        //Cikan reklami kapatalim
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //Ve ekran goruntusunu alalim.
        /*
        İlk olarak SS aldığımızda nereye kaydetmek iatiyorsak oranın yolunu belirtelim.
        İkinci olarak TakeScreenShot arayüzünden obje oluştururuz
        Üçüncü olarak FileUtils class'ından copyFile() metodu ile ts objemizi kullanarak
            getScreenShotAs metodu ile dosya yolunu belirteceğiz.

         */
        String dosyaYolu="src/test/java/tecproed/TumSayfaResmi/screenShot.png";//jpeg yapabilirdik
        TakesScreenshot ts= (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));


    } @Test
    public void test02() throws IOException {
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        bekle(2);
        //Çıkan reklamı kapatalım
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //Ve ekran görüntüsünü alalım
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File("ScreenShot/screenShot.png"));
    }

    @Test
    public void test03() throws IOException {
        /*
        Kaydettiğimiz ekran resmini her seferinde aynı dosya üzerine yazmaması için dosya isminden sonra
        String bir değişkene tarih formatı atayabiliriz.
         */
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        bekle(2);
        //Çıkan reklamı kapatalım
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        //Ve ekran görüntüsünü alalım
        /*
        SimpleDateFormat'ı kullanarak yeni bir tarih formatı oluşturup bir String'e assing ederiz.
        Ve bunu dosya isminden önce belirtiriz.
         */
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "src/test/java/techproed/TumSayfaResmi/screenShot" + tarih + ".jpeg";
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
    }


     @Test
     public void test04() throws IOException {
         //Techproeducation sayfasına gidelim
         driver.get("https://amazon.com");

         bekle(2);

         //Ve ekran görüntüsünü alalım

         String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
         String dosyaYolu = "src/test/java/techproed/TumSayfaResmi/screenShot" + tarih + ".jpeg";
         TakesScreenshot ts = (TakesScreenshot) driver;
         FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
     }




}
