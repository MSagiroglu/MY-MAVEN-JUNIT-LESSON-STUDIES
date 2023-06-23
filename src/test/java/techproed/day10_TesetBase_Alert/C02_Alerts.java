package techproed.day10_TesetBase_Alert;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C02_Alerts extends TestBase {
        /*
            Eğer bir sayfadaki bir buttona tıkladığımızda bir uyarı penceresi çıkıyorsa ve bu çıkan pencereye sağ klik
         yapıp locate alamıyorsak, bu bir js Alert'tür.
            js Alert'ü handle edebilmek için driver'ımızı o pencere geçirmemiz gerekir. Bunun için;
         driver objemizi kullanarak switchTo() methoduyla alert() methodunu kullanarak js alert'e geçiş yapmış oluruz
         accept() yada dismiss() methodlarıyla js Alert'ü onaylar yada iptal ederek kapatırız.
         */

    //--> Çalışmasını istemediğimiz test notasyonundan sonra (@Test) @Ignore notasyonu kullanırız
    @Test @Ignore
    public void ignore() {
        System.out.println("Bu Test Daha sonra yapilacak...");
    }

    @Test
    public void acceptAlert() {
        //Bir metod olusturun: acceptAlert
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının “You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
        driver.switchTo().//geçmek için kullanılan method
                alert().//alert'e geçmek için metod
                accept();//çıkan aler'e ok yada tamam butonuna tıklar
        bekle(2);
        WebElement resultMessage=driver.findElement(By.xpath("(//p)[2]"));
        String istenenYazi="You successfully clicked an alert";
        Assert.assertEquals(istenenYazi,resultMessage.getText());

    }
    @Test
    public void dismissAlert() {
        //Bir metod olusturun: dismissAlert
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        driver.findElement(By.xpath("(//button)[2]")).click();
        bekle(3);
        driver.switchTo().
                alert().
                dismiss();//js Alert'teki iptal tuşuna basar.
        //“successfuly” icermedigini test edin.
        WebElement resultMessage=driver.findElement(By.xpath("(//p)[2]"));
        String istenmeyenYazi="successfuly";
        Assert.assertFalse(resultMessage.getText().contains(istenmeyenYazi));

    }
    @Test
    public void sendKeysAlert() {
        //Bir metod olusturun: sendKeysAlert
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        driver.findElement(By.xpath("(//button)[3]")).click();
        //tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.switchTo().alert().sendKeys("mustafa");
        bekle(3);
        driver.switchTo().alert().accept();
        bekle(2);
        WebElement resultMessage=driver.findElement(By.xpath("(//p)[2]"));
        String beklenenYazi="mustafa";
        Assert.assertTrue(resultMessage.getText().contains(beklenenYazi));
    }
}
