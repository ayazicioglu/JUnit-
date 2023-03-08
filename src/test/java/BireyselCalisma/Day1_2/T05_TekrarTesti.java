package BireyselCalisma.Day1_2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class T05_TekrarTesti {
    public static void main(String[] args) {
       System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2. Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını
        //doğrulayın (verify), eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.

        driver.get("https://www.youtube.com");
        String actualTitle=driver.getTitle();
        String expectedIcerik="youtube";
        if (actualTitle.equals(expectedIcerik)){
            System.out.println("YouTube title test PASSED");
        }else System.out.println("YouTube title test FAILED, actual title: "+actualTitle);

        //3. Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa doğru URL'yi yazdırın.
        String actualUrl=driver.getCurrentUrl();
        expectedIcerik="youtube";
        if (actualUrl.contains(expectedIcerik)){
            System.out.println("YouTube URL test PASSED");
        }else System.out.println("YouTube URL test FAILED, actual URL: "+actualUrl);

        //4. Daha sonra Amazon sayfasina gidin https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com/");

        //5. Youtube sayfasina geri donun
        driver.navigate().back();

        //6. Sayfayi yenileyin
        driver.navigate().refresh();

        //7. Amazon sayfasina donun
        driver.navigate().forward();

        //8. Sayfayi tamsayfa yapin
        driver.manage().window().fullscreen();

        //9. Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın,
        //Yoksa doğru başlığı(Actual Title) yazdırın.
        actualTitle=driver.getTitle();
        expectedIcerik="Amazon";
        if (actualTitle.equals(expectedIcerik)){
            System.out.println("Amazon title test PASSED");
        }else System.out.println("Amazon title test FAILED, actual title: "+actualTitle);

        //10.Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse
        //doğru URL'yi yazdırın
        actualUrl=driver.getCurrentUrl();
        expectedIcerik="https://www.amazon.com/";
        if (actualUrl.equals(expectedIcerik)){
            System.out.println("Amazon URL test PASSED");
        }else System.out.println("Amazon URL test FAILED, actual URL: "+actualUrl);

        //11.Sayfayi kapatin
        driver.close();
    }
}
