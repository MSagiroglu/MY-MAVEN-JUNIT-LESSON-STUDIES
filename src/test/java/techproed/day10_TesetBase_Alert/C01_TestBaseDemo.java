package techproed.day10_TesetBase_Alert;

import org.junit.Assert;
import org.junit.Test;
import techproed.utilities.TestBase;

public class C01_TestBaseDemo extends TestBase {




    @Test
        public void test01() {
            //Techproeducation sayfasına gidelim
            driver.get("https://techproeducation.com");
            //3 saniye bekle
            bekle(3);


            //Başlığın Bootcamp içerdiğini test edelim
            String actualTitle = driver.getTitle();
            String expectedTitle = "Bootcamp";
            Assert.assertTrue(actualTitle.contains(expectedTitle));
            //assert actualTitle.contains(expectedTitle);  -->actualTitle.contains(expectedTitle).assert

        }
}
