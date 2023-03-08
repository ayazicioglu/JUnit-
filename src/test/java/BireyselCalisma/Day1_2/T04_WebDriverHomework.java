package BireyselCalisma.Day1_2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class T04_WebDriverHomework {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2.ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin
        driver.get("https://www.facebook.com" +
                "");
        //(title) “facebook” oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.
        String actualTitle=driver.getTitle();
        String expectedIcerik="facebook";
        if (actualTitle.equals(expectedIcerik)){
            System.out.println("Title test PASSED");
        }else System.out.println("Title test FAILED, actual Title: "+actualTitle);

        //3.Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i yazdirin.
        String actualUrl=driver.getCurrentUrl();
        expectedIcerik="facebook";
        if (actualUrl.contains(expectedIcerik)){
            System.out.println("URL test PASSED");
        }else System.out.println("URL test FAILED, actual URL: "+actualUrl);

        //4.https://www.walmart.com/ sayfasina gidin.
        driver.navigate().to("https://www.walmart.com/");

        //5. Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        actualTitle=driver.getTitle();
        expectedIcerik="Walmart.com";
        if (actualTitle.contains(expectedIcerik)){
            System.out.println("Title test PASSED");
        }else System.out.println("Title test FAILED, actual Title: "+actualTitle);

        //6. Tekrar “facebook” sayfasina donun
        driver.navigate().back();

        //7. Sayfayi yenileyin
        driver.navigate().refresh();

        //8. Sayfayi tam sayfa (maximize) yapin
        driver.manage().window().maximize();

        //9.Browser’i kapatin
        driver.close();
    }
}
