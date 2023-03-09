package BireyselCalisma.Day5_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class T11_MavenClassWork {

    @Test
    public void test01(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1- https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");

        //2- arama kutusunu locate edelim
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));

        //3- “Samsung headphones” ile arama yapalim
        aramaKutusu.sendKeys("Samsung headphones"+ Keys.ENTER);

        //4- Bulunan sonuc sayisini yazdiralim
        WebElement aramaSonucYaziElement= driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        System.out.println(aramaSonucYaziElement.getText());

        //5- Ilk urunu tiklayalim
        driver.findElement(By.xpath("(//span[@class='rush-component'])[1]")).click();

        //6- Sayfadaki tum basliklari yazdiralim
        List<WebElement> tumSayfaWE=driver.findElements(By.xpath("//span[@class='a-size-base a-color-base']"));
        int sira=1;
        for (WebElement each:tumSayfaWE) {
            System.out.println(sira+"- "+each.getText());
            sira++;
        }
        driver.close();
    }
}
