package BireyselCalisma.Day6_9_JUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class T25_HandleIFrame extends TestBase {

    @Test
    public void test01(){
        //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");

        //2) sayfadaki iframe sayısını bulunuz.
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        System.out.println("Sayfadaki frame sayisi: "+iframes.size());

        //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        WebElement youtubeFrameElement=driver.findElement(By.xpath("//iframe[@wmode='transparent']"));
        driver.switchTo().frame(youtubeFrameElement);
        driver.findElement(By.xpath("//button[@aria-label='Oynat']")).click();
        bekle(3);

        //4) ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().parentFrame();

        //5) ikinci iframe'deki (Jmeter Made Easy) linke
        //(https://www.guru99.com/live-selenium-project.html) tıklayınız
        WebElement ikinciFrameElement= driver.findElement(By.id("a077aa5e"));
        driver.switchTo().frame(ikinciFrameElement);
        driver.findElement(By.xpath("//a[@href='http://www.guru99.com/live-selenium-project.html']")).click();
        bekle(2);

    }
}
