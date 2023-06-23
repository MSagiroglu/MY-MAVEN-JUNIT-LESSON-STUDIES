package techproed.day09_DropDownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C02_DropDown {
           /*
        DROPDOWN --> Altbasliklarin oldugu acilir menu listesidir.
        Dropdown'u handle(outomate) etmek icin
           1-Dropdoen menu ilk olarak locate ederiz
           2-Select objesi olustururuz
           3-Select objesinin dropdown menu webelementinin icerigine ve seceneklerine erisim saglamasi icin
           SELECT sinifina argumen olarak locate ettigimiz webelement'i koyariz
           SYNTAX:
                   Select select - new Select(ddm webelementi)
           4-Select class'i sadece <select> tagi ile olusturulmus dropdown menulere uygulanabilir
           5-Select objesi ddm'yu handle edebilmek icin 3 method kullanir
               -selectByVisibleText() --> Ddm deki elemente gorunur metin ile ulasmak icin kullanilir.
               -selectByIntex() --> Index ile ulasmak icin kullanilir(Index 0(sifir) dan baslar)
               -SelectByValue() --> Elementin degeri ile ulasmak icin kullanilir (option tag'larindaki deger ile)
          6-getoptions() -> Locate ettigimiz ddm'deki tum secenekleri bize verir.(Liste atip for loop ile yazdirabilirz)
          7-getFirstSelectedOption() --> Ddm'deki secili kalan secenegi bize verir. Birden fazla secenek secildigse,
          bu secilenlerin ilkini verir.
          8-Ddm'ye sendKeys() methodu ile de ddm menudeki seceneklerden birini kullanarak gonderebiliriz.
        */

    WebDriver driver;
            /*
        Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
        -3 farklı test methodu oluşturalım
            1.Method:
                a. Yil,ay,gün dropdown menu'leri locate ediniz
                b. Select objesi olustur
                c. Select object i kullaarak 3 farkli sekilde secim yapiniz
            2.Method:
                a. Tüm eyalet isimlerini yazdıralım
            3.Method:
                a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim

         */
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @Test
    public void test01() {
       // 1.Method:
       // a. Yil,ay,gün dropdown menu'leri locate ediniz
        WebElement yil=driver.findElement(By.xpath("(//select)[2]"));
        WebElement ay=driver.findElement(By.xpath("(//select)[3]"));
        WebElement gun=driver.findElement(By.xpath("(//select)[4]"));

       // b. Select objesi olustur
        Select select=new Select(yil);
        Select select2=new Select(ay);
        Select select3=new Select(gun);

       // c. Select object i kullaarak 3 farkli sekilde secim yapiniz
        select.selectByIndex(5);//index 0 'dan başlar 2018'i seçer.
        select2.selectByValue("6");// incele de select içinde option valuelerine göre july 6 değerini  seçilir.
        select3.selectByVisibleText("15");//görünen metne göre değer verilerek yapılır
    }

    @Test
    public void test02() {
       //2.Method:
       //a. Tüm eyalet isimlerini yazdıralım

        //1.yol
        WebElement eyaletler=driver.findElement(By.xpath("(//select)[5]"));
        Select select=new Select(eyaletler);
        select.getOptions().forEach(w-> System.out.println(w.getText()));//getOptions() ile tüm seçenekleri yazdırdık

        System.out.println("***********************");
        /*//2.yol
        List<WebElement> eyaletler2=driver.findElements(By.xpath("(//select)[5]"));
        eyaletler2.forEach(w-> System.out.println(w.getText()));
        */

    }

    @Test
    public void test03() {
      // 3.Method:
      // a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim
        WebElement eyaletler=driver.findElement(By.xpath("(//select)[5]"));
        Select select=new Select(eyaletler);
        String seciliOlanSecenek=select.getFirstSelectedOption().getText();
        System.out.println(seciliOlanSecenek);
        Assert.assertEquals("Select a State",seciliOlanSecenek);
        Assert.assertTrue(seciliOlanSecenek.contains("Select a State"));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
