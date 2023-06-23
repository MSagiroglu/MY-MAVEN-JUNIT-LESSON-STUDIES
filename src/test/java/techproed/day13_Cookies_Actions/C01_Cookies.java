package techproed.day13_Cookies_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import techproed.utilities.TestBase;

import java.util.Arrays;
import java.util.Set;

public class C01_Cookies extends TestBase {
    @Test
    public void test01() {
        //1-Amazon anasayfaya gidin
        driver.get("https://amazon.com");

        //2-tum cookie’leri listeleyin

        /*
            Cookie'leri listelemek istersek
                    driver.manage().getCookies() methodu ile bir Set ya da ArraList'e atarak listeyebiliriz
         */
        Arrays.stream(driver.manage().getCookies().toArray()).forEach(System.out::println);
        //Set<Cookie> cookies = driver.manage().getCookies();
        Set<Cookie> cookieSet= driver.manage().getCookies();
        int sayac=1;
        for (Cookie w:cookieSet) {
            System.out.println(sayac+".ci cookie :" +w);
            System.out.println(sayac+".ci cookieName :" +w.getName());// -->Sadece cookie lerin ismini alırız
            System.out.println(sayac+".ci cookieValue :" +w.getValue());// -->Sadece cookie lerin value larını alırız

            sayac++;
        }

        //3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        Assert.assertTrue(cookieSet.size() > 5);

        //4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String actualCookieValue = driver.manage().getCookieNamed("i18n-prefs").getValue();
        //getCookieNamed() methodu ile bize verilen cookie isminin getValue() methoduyla
        // gercek degerini actualCookieValue degiskenine assign ettik
        String expectedCookieValue = "USD";
        Assert.assertEquals(expectedCookieValue,actualCookieValue);

        // 5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
        Cookie cookie=new Cookie("en sevdiğim cookie","cikolatali");
        driver.manage().addCookie(cookie);
        //6-eklediginiz cookie’nin sayfaya eklendigini test edin
        cookieSet=driver.manage().getCookies();
        sayac=1;
        for (Cookie w:cookieSet) {
            System.out.println(sayac+". cookie = "+w+" name = "+w.getName()+" , value = "+w.getValue());
            sayac++;

        }
        Assert.assertEquals("cikolatali", driver.manage().getCookieNamed("en sevdiğim cookie").getValue());
        System.out.println("Cookie'lerin sayisi = "+cookieSet.size());
        System.out.println("Cookie'lerin sayisi = "+Arrays.stream(driver.manage().getCookies().toArray()).count());
        //7-ismi skin olan cookie'yi silin ve silindigini test edin
        int silinmedenOnce = cookieSet.size();
        System.out.println("S.O. : " + silinmedenOnce);
        driver.manage().deleteCookieNamed("skin");//-->ismi skin olan cookie`yi sildik.
        bekle(2);
        //Silindikten sonra cookieSet'e yine atama yapiyoruz aksi taktirde fail aliriz
        cookieSet = driver.manage().getCookies();
        for (Cookie each : cookieSet) {
            System.out.println(each);
        }
        int silindiktenSonra = cookieSet.size();
        System.out.println("S.S. : " + silindiktenSonra);
        Assert.assertEquals(1,(silinmedenOnce-silindiktenSonra));

        //8-tum cookie'leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();//-->Tüm cookie'leri sildik
        cookieSet = driver.manage().getCookies();//-->Tekrar cookieSet'i güncelledik
        Assert.assertTrue(cookieSet.isEmpty());//-->Ve cookieSet'in içinin boş olduğunu isEmpty() methoduyla test ettik
    }
}
