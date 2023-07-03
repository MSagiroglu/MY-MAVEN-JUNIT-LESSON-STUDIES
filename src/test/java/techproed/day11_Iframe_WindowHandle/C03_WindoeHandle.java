package techproed.day11_Iframe_WindowHandle;

import org.junit.Test;
import org.openqa.selenium.WindowType;
import techproed.utilities.TestBase;

public class  C03_WindoeHandle extends TestBase {
    /*
        Eger sayfaya gittikten sonra yeni sekme yada yeni bir pencereyle baska sayfaya gittikten sonra
        tekrar ilk actiginiz sayfaya dnmek isterseniz, ilk sayfaya driver.get() methoduyla gittikten sonra
        String bir degisken handle degerini assign ederseniz tekrar ilk acilan sayfaya donmek istediginizde
        driver.switchTo().window(ilksayfaHandleDegeri) ile gecis yapabilirsiniz
         */
    @Test
    public void windowHandle() {
        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String techproWindowHandle=driver.getWindowHandle();

        //Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        assert driver.getTitle().equals("Techpro Education | Online It Courses & Bootcamps");

        //Window 2'de (yeni bir pencerede)https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);//-->Yeni bir pencereye driver'ı taşır
         //WindowType.TAB --> deseydik yeni bir sekme açardı
        driver.get("https://www.youtube.com");
        String youtubeWindowHandle=driver.getWindowHandle();

        //Window 3'te https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
        String linkedinWindowHandle=driver.getWindowHandle();
        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(techproWindowHandle);
        bekle(3);
        //youtube sayfasına geçiniz:
        driver.switchTo().window(youtubeWindowHandle);
        bekle(3);
        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(linkedinWindowHandle);
        bekle(3);

    }

    @Test
    public void test02() {
        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String techproWindowHandle=driver.getWindowHandle();

        //Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        assert driver.getTitle().equals("Techpro Education | Online It Courses & Bootcamps");

        //Window 2'de (yeni bir pencerede)https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);//-->Yeni bir pencereye driver'ı taşır
        //WindowType.TAB --> deseydik yeni bir sekme açardı
        driver.get("https://www.youtube.com");
        String youtubeWindowHandle=driver.getWindowHandle();

        //Window 3'te https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.linkedin.com");
        String linkedinWindowHandle=driver.getWindowHandle();
        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(techproWindowHandle);
        bekle(3);
        //youtube sayfasına geçiniz:
        driver.switchTo().window(youtubeWindowHandle);
        bekle(3);
        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(linkedinWindowHandle);
        bekle(3);
    }
}
