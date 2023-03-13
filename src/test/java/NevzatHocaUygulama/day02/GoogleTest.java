package NevzatHocaUygulama.day02;

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
import org.openqa.selenium.devtools.v85.animation.model.KeyframeStyle;

import java.time.Duration;

public class GoogleTest {

    // ilgili kurulumlari tamamlayalim
    WebDriver driver;
    String https="https://www";
   @Before
   public void setup(){
       WebDriverManager.chromedriver().setup();
       driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
   }
   @After
   public void teardown(){
       driver.quit();
   }

    @Test
    public void test01() {
        // Kullanici https://www.google.com adresine gider
        driver.get("https://www.google.com");

        // Kullanici cookies i kabul eder

        // Arama Kutusuna karsilastirma yapmak istedigi para birimlerini girer
        WebElement googleAramaKutusu=driver.findElement(By.xpath("//input[@class='gLFyf']"));
        googleAramaKutusu.sendKeys("dolar to euro"+ Keys.ENTER);

        // Para birimlerinin karsilastirmasini alir
        // Karsilastirilacak olan para biriminin 1.5 den kucuk oldugu test edilir
        WebElement sonucDegerElementi= driver.findElement(By.xpath("//span[@class='DFlfde SwHCTb']"));
        String actualSonuc= sonucDegerElementi.getText();
        actualSonuc=actualSonuc.replace(",","."); //mal google , ile yazdığı için . ile değiştirdim
        Assert.assertTrue(Double.parseDouble(actualSonuc)<1.5);
    }
}

