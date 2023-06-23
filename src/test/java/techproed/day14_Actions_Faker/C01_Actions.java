package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C01_Actions extends TestBase {
    @Test
    public void test01() {
        //techpro sayfasına gidelim
        driver.get("https://techproeducation.com");
        bekle(3);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        bekle(2);


        //sayfanın altına doğru gidelim
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN, Keys.PAGE_DOWN, Keys.PAGE_DOWN, Keys.PAGE_DOWN).perform();
        //actions.sendKeys(Keys.END).perform();
        bekle(3);


        //sayfanın üstüne doğru gidelim
        actions.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_UP).perform();
        //actions.sendKeys(Keys.HOME).perform();
    }

    @Test
    public void test02() {
        //techpro sayfasına gidelim
        driver.get("https://techproeducation.com");
        bekle(3);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        bekle(2);
        //sayfanın en altına doğru gidelim
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END);//perform() metodu kullanmadık. aşağıda build() yaparak iki action objesini bağladık
        bekle(3);


        //sayfanın en üstüne doğru gidelim
        actions.sendKeys(Keys.HOME).build().perform();
        //build() -->methodu action'lari birlestirmek icin kullanilan methoddur.Birden fazla olusturdugumuz action
        //objesini birbirine baglar
        //release() --> methodu mouse'u serbest birakir

    }

    @Test
    public void test03() {
        //techpro sayfasına gidelim
        driver.get("https://techproeducation.com");
        bekle(3);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        bekle(2);
        //sayfanın altına doğru gidelim
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0,3500).perform();
        /*
        scrollByAmount(0,1500) kartezyen koordinat sistemi olan yatay ve düsey yönleri
         x ve y olarak adlandirdigimiz sistemde x=0 ile y=+1500 arasinda
        gidecektir. pozitif(+) yön kuzey secilmistir
         */
        bekle(3);
        //sayfanın üstüne doğru gidelim
        actions.scrollByAmount(0,-3500).perform();
        bekle(3);

        actions.scrollToElement(driver.findElement(By.xpath("(//i[@class='fab fa-facebook'])[2]"))).perform();


    }
}
