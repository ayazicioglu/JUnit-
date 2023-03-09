package BireyselCalisma.Day3_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class T09_GenelTekrar {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

        //3- Browseri tam sayfa yapin
        driver.manage().window().fullscreen();

        //4- Sayfayi “refresh” yapin
        driver.navigate().refresh();

        //5- Sayfa basliginin “Spend less” ifadesi icerdigini test edin
        String actualTitle=driver.getTitle();
        String expectedIcerik="Spend less";
        if (actualTitle.contains(expectedIcerik)){
            System.out.println("Title test PASSED");
        }else System.out.println("Title test FAILED");

        //6- Gift Cards sekmesine basin
        WebElement giftCardElement= driver.findElement(By.xpath("//*[@data-csa-c-content-id='nav_cs_gc']"));
        giftCardElement.click();

        //7- Birthday butonuna basin
        WebElement birtdayElement=driver.findElement(By.xpath("(//img[@alt='Birthday'])[2]"));
        birtdayElement.click();

        //8- Best Seller bolumunden ilk urunu tiklayin
        WebElement ilkUrunElement=driver.findElement(By.xpath("(//img[@alt='Amazon.com eGift Card'])[1]"));
        ilkUrunElement.click();

        //9- Gift card details’den 25 $’i secin
        driver.findElement(By.xpath("//button[@value='25']")).click();

        //10-Urun ucretinin 25$ oldugunu test edin
        String actualAmount=driver.findElement(By.id("gc-live-preview-amount")).getText();
        expectedIcerik="$25.00";
        if (actualAmount.equals(expectedIcerik)){
            System.out.println("Fiyat testi PASSED");
        }else System.out.println("Fiyat testi FAILED");

        //11-Sayfayi kapatin
        driver.close();
    }
}
