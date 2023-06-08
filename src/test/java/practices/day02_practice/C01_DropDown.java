package practices.day02_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C01_DropDown {
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/");

    }

    @Test
    public void test01() {
        driver.navigate().refresh();
        WebElement categories=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        // dropdown'dan "Books" secenegini secin
        Select select=new Select(categories);
        // dropdown'dan "Books" secenegini secin
        select.selectByVisibleText("Books");
        // arama cubuguna "Java" aratın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);
        WebElement result=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println("result product count : "+result.getText().split(" ")[3]);

        // arama sonuclarinin Java icerdigini test edin
        Assert.assertTrue(result.getText().contains("Java"));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
