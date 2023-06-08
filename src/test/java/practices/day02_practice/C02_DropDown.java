package practices.day02_practice;

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
import java.util.List;

public class C02_DropDown {
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/");

    }

    @Test
    public void test01() {
        driver.navigate().refresh();
        // dropdown'dan "Baby" secenegini secin
        WebElement categories = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(categories);
        select.selectByVisibleText("Baby");
        // sectiginiz option'i yazdirin
        System.out.println(select.getFirstSelectedOption().getText());
        // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin
        List<WebElement> optionsList = select.getOptions();
        Assert.assertEquals(28, optionsList.size());
        System.out.println("optionsList.size() = " + optionsList.size());
        // dropdown'daki optionların tamamını yazdırın
        optionsList.forEach(w -> System.out.println(w.getText()));

    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
