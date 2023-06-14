package practices.day04_practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import practices.utilities.TestBase;

public class C03_WindowHandle extends TestBase {
    @Test
    public void name() {
        // 1- https://www.amazon.com sayfasina gidelim
        driver.get("https://amazon.com");
        String amazonHandle=driver.getWindowHandle();
        // 2- url'in 'amazon' icerdigini test edelim
        assert driver.getCurrentUrl().contains("amazon");
        // 3- yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String bestbuyHandle=driver.getWindowHandle();
        // 4- title'in 'Best Buy' icerdigini test edelim
        assert driver.getTitle().contains("Best Buy");
        // 5- ilk sayfaya(amazon) donup sayfada java aratalım
        driver.switchTo().window(amazonHandle);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);
        // 6- arama sonuclarının 'Java' icerdigini test edelim
        assert driver.findElement(By.className("sg-col-inner")).getText().contains("Java");
        // 7- ikinci sayfaya(bestbuy) donelim
        driver.switchTo().window(bestbuyHandle);
        // 8- logonun gorundugunu test edelim,
        assert driver.findElement(By.xpath("(//img[@class='logo'])[1]")).isDisplayed();
    }
}
