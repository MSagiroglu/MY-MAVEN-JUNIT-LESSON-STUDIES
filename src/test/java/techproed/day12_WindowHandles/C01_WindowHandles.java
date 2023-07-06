package techproed.day12_WindowHandles;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import techproed.utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class C01_WindowHandles extends TestBase {
    @Test
    public void test01() { //Set<String> pencereler=driver.getWindowHandles(); ile çözüm
        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        //  ilk sayfasının Handle degerini alın yazdırın
        String ilkSayfaHandle = driver.getWindowHandle();
        System.out.println("İlk Sayfa Handle Değeri : "+ilkSayfaHandle);

        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        String expectedText = "Opening a new window";
        Assert.assertEquals(expectedText,actualText);

        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(expectedTitle,actualTitle);

        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click();//--> yeni bir sekme açıldı
        bekle(3);
        /*
    Bir button'a click yaptigimizda kontrolumuz disinda yeni bir sekme ya da pencere acilirsa , yeni acilan pencerenin
    handle degerini bilmedigim icin normal getWindowHandle ile driver'imi yeni pencereye geciremem. Bunu getWindowHandles()
    methoduyla acilan tum pencereleri bir Set'e assign edip , ilk actigimiz pencere degilse ikinci acilan yeni penceredir
    mantigiyla bir loop icinde cozebiliriz

 */
        Set<String> pencereler=driver.getWindowHandles();
        for (String w:pencereler) {
            System.out.println(w);
            if (!w.equals(ilkSayfaHandle)){
                driver.switchTo().window(w);
            }
        }
        //Lambda ile geçiş
        /*
        /*windowHandlesSeti.
           stream().
           filter(t->!t.equals(sayfa1Handle)).
           forEach(t-> System.out.println("2.Sayfa Handle değeri : "+t));
         */


        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        assert driver.getTitle().equals("New Window");
        String ikinciSayfaHandle = driver.getWindowHandle();
        System.out.println("İkinci Sayfa Handle Değeri : "+ikinciSayfaHandle);
        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        driver.switchTo().window(ilkSayfaHandle);
        String ilkSayfaActualTitle = driver.getTitle();
        String ilkSayfaExpectedTitle = "The Internet";
        Assert.assertEquals(ilkSayfaExpectedTitle,ilkSayfaActualTitle);

        bekle(2);

        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(ikinciSayfaHandle);
        bekle(2);

        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(ilkSayfaHandle);
        bekle(2);

    }

    @Test
    public void test02() {//List<String> pencereler=new ArrayList<>(driver.getWindowHandles()); ile çözüm
        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        //  ilk sayfasının Handle degerini alın yazdırın
        String ilkSayfaHandle = driver.getWindowHandle();
        System.out.println("İlk Sayfa Handle Değeri : "+ilkSayfaHandle);
        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        String expectedText = "Opening a new window";
        Assert.assertEquals(expectedText,actualText);
        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(expectedTitle,actualTitle);
        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click();//--> yeni bir sekme açıldı
        bekle(3);
        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        List<String> pencereler=new ArrayList<>(driver.getWindowHandles());
        /*
            getWindowHandles() methodunu kullanarak acilan tum pencerelerin handle degerlerini bir
            arraylist' e atadaik
        Index 0(sifir)'dan basladigi icin kontrolum disinda acilan pencere 1. index de oldugundan
         driver.switchTo().window(pencereler.get(1)); ile yeni acilan pencereye gecis yaptik
         */
        driver.switchTo().window(pencereler.get(1));
        assert driver.getTitle().equals("New Window");
        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        driver.switchTo().window(pencereler.get(0));
        assert driver.getTitle().equals("The Internet");
        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(pencereler.get(1));
        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(pencereler.get(0));
    }

    @Test
    public void test03() {//driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString()); ile çözüm
        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        String expectedText = "Opening a new window";
        Assert.assertEquals(expectedText,actualText);

        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(expectedTitle,actualTitle);

        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click();//--> Kontrolümüz dışında Yeni bir sekme açıldı
        bekle(3);

        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        //driver.switchTo().window(String.valueOf(driver.getWindowHandles().hashCode()));
        System.out.println(driver.getWindowHandles().toArray()[1].hashCode());
        System.out.println(driver.getWindowHandles().toArray()[1].toString());
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        String actualTitleNewWindow = driver.getTitle();
        String expectedTitleNewWindow = "New Window";
        Assert.assertEquals(expectedTitleNewWindow,actualTitleNewWindow);
    /*
        getWindowHandles() methodunu kullanarak açılan tüm pencerelerin handle değerlerini bir arraylist'e atadık.
    Index 0(sıfır)'dan başladığı için kontrolüm dışında açılan pencere 1. index de olduğundan
     driver.switchTo().window(pencereler.get(1)); ile yeni açılan penceye geçiş yaptık
     */

        bekle(2);
        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
        String ilkSayfaActualTitle = driver.getTitle();
        String ilkSayfaExpectedTitle = "The Internet";
        Assert.assertEquals(ilkSayfaExpectedTitle,ilkSayfaActualTitle);

        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        bekle(2);
        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
        bekle(2);
    }

    @Test
    public void test04() { // metodla çalışma
        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        String expectedText = "Opening a new window";
        Assert.assertEquals(expectedText,actualText);

        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(expectedTitle,actualTitle);

        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click();//--> Kontrolümüz dışında Yeni bir sekme açıldı
        bekle(3);

        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        switchToWindow1(1);
        String actualTitleNewWindow = driver.getTitle();
        String expectedTitleNewWindow = "New Window";
        Assert.assertEquals(expectedTitleNewWindow,actualTitleNewWindow);
    /*
        getWindowHandles() methodunu kullanarak açılan tüm pencerelerin handle değerlerini bir arraylist'e atadık.
    Index 0(sıfır)'dan başladığı için kontrolüm dışında açılan pencere 1. index de olduğundan
     driver.switchTo().window(pencereler.get(1)); ile yeni açılan penceye geçiş yaptık
     */

        bekle(2);
        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        switchToWindow1(0);
        String ilkSayfaActualTitle = driver.getTitle();
        String ilkSayfaExpectedTitle = "The Internet";
        Assert.assertEquals(ilkSayfaExpectedTitle,ilkSayfaActualTitle);

        //  ikinci sayfaya tekrar geçin.
        switchToWindow1(1);
        bekle(2);
        //  ilk sayfaya tekrar dönün.
        switchToWindow1(0);
        bekle(2);
    }
}
