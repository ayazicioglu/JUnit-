package BireyselCalisma.Day1_2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class T03_WebDriverMethods {

    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //3. Amazon sayfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //4. Sayfa basligini(title) yazdirin
        System.out.println(driver.getTitle());

        //5. Sayfa basliginin “Amazon” icerdigini test edin
        String expectedIcerik="Amazon";
        String actualBaslik=driver.getTitle();
        if (actualBaslik.contains(expectedIcerik)){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

        //6. Sayfa adresini(url) yazdirin
        System.out.println(driver.getCurrentUrl());

        //7. Sayfa url’inin “amazon” icerdigini test edin.
        expectedIcerik="amazon";
        String actualUrl=driver.getCurrentUrl();
        if (actualUrl.contains(expectedIcerik)){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

        //8. Sayfa handle degerini yazdirin
        System.out.println(driver.getWindowHandle());

        //9. Sayfa HTML kodlarinda “alisveris” kelimesi gectigini test edin
        String HTMLsource=driver.getPageSource();
        expectedIcerik="alisveris";
        if (HTMLsource.contains(expectedIcerik)){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

        //10. Sayfayi kapatin.
        driver.close();
    }
}
