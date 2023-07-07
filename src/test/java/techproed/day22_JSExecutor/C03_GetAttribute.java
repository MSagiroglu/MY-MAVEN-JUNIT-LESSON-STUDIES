package techproed.day22_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C03_GetAttribute extends TestBase {

    @Test
    public void test01() {
        //  https://www.carettahotel.com/ a gidiniz
        driver.get("https://www.carettahotel.com/");
        bekle(2);
        WebElement gelismis=driver.findElement(By.xpath("//*[@id=\"details-button\"]"));
        gelismis.click();
        bekle(2);
        WebElement izin=driver.findElement(By.xpath("//*[@id=\"proceed-link\"]"));
        Actions actions=new Actions(driver);
        actions.moveToElement(izin).click().perform();
        //  Tarih kısmını JS ile locate ediniz.
        JavascriptExecutor js= (JavascriptExecutor) driver;
        WebElement tarih= (WebElement) js.executeScript("return document.getElementById('checkin_date')");//veya
        //WebElement tarih= (WebElement) js.executeScript("return document.querySelector('#checkin_date')");
        /*
        Java Script kodlarıyla yazılmış webelementleri bizim bildiğimiz findElement() methoduyla locate edemeyebiliriz.
        js executor kullanarak ister html ister java script ile yazılmış olsun bir webelementin locatini js executor
        ile alabiliriz. Yukarıdaki örnekte sayfadaki tarih webelementini js executor ile locate ettik.
         */
        tarih.clear();
        bekle(2);
        tarih.sendKeys("5/25/2023");
        //  Yazili metinleri alıp ve yazdırınız
        String idAttributeDegeri=js.executeScript("return document.getElementById('checkin_date').id").toString();
        String typeAttributeDegeri=js.executeScript("return document.getElementById('checkin_date').type").toString();
        String nameAttributeDegeri=js.executeScript("return document.getElementById('checkin_date').name").toString();
        String valueAttributeDegeri=js.executeScript("return document.getElementById('checkin_date').value").toString();
        System.out.println("idAttributeDegeri = " + idAttributeDegeri);
        System.out.println("typeAttributeDegeri = " + typeAttributeDegeri);
        System.out.println("nameAttributeDegeri = " + nameAttributeDegeri);
        System.out.println("valueAttributeDegeri = " + valueAttributeDegeri);
        /*
        Js executor ile attribute değerlerini yazdırabilmek için js ile locate ettiğimiz webelementin sonuna
        yukarıdaki örnekteki gibi hangi attributun değeri yazdırmak istersek sonuna attribute adını yazarız.
         */
    }

    @Test
    public void test02() {
        //https://www.priceline.com/ adresine gidiniz
        driver.get("https://www.priceline.com/");
        //Submit butonunun rengini Kirmizi yazınız
        WebElement button=driver.findElement(By.xpath("//*[text()='Find Your Hotel']"));
        //WebElement button2=driver.findElement(By.xpath("//*[@class=\"sc-dhKdcB gHFNRO sc-266892e-0 kULWIA\"]"));
        JavascriptExecutor js=(JavascriptExecutor) driver;
        //js.executeScript("arguments[0].style.background-color='red';",button2);
        js.executeScript("arguments[0].style.color='red';",button);

    }
    @Test
    public void test03() {
        //https://www.priceline.com/ adresine gidiniz
        driver.get("https://techproeducation.com/");
        //Submit butonunun rengini Kirmizi yazınız
        WebElement button=driver.findElement(By.xpath("(//*[@class=\"elementor-item elementor-item-active\"])[1]"));
        //WebElement button2=driver.findElement(By.xpath("//*[@class=\"sc-dhKdcB gHFNRO sc-266892e-0 kULWIA\"]"));
        bekle(2);
        JavascriptExecutor js=(JavascriptExecutor) driver;
        //js.executeScript("arguments[0].style.background-color='red';",button2);
        js.executeScript("arguments[0].style.color='red';",button);

    }
}
