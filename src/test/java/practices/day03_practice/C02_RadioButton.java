package practices.day03_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_RadioButton {
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test01() {
        // https://demo.guru99.com/test/radio.html adresine gidin
        driver.get("https://demo.guru99.com/test/radio.html");
        // radiobutton elementlerini locate edin
        WebElement radio01=driver.findElement(By.id("vfb-7-1"));
        WebElement radio02=driver.findElement(By.id("vfb-7-2"));
        WebElement radio03=driver.findElement(By.id("vfb-7-3"));
        // option2'yi secin
        radio02.click();
        // option2 elementlerinin secili oldugunu Test edin
        Assert.assertTrue(radio02.isSelected());
        // option1 elementlerinin secili olmadıgını test edin
        Assert.assertFalse(radio01.isSelected());
        // option3 elementlerinin secili olmadıgını test edin
        Assert.assertFalse(radio03.isSelected());
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
