package BireyselCalisma.Day5_Maven;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class T13_MavenTekrarTesti {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

        //3- cookies uyarisini kabul ederek kapatin (TR de cikmiyor, yazmadim)

        //4- Sayfa basliginin “Google” ifadesi icerdigini test edin
        String actualBaslik=driver.getTitle();
        String expectedIcerik="Google";
        if (actualBaslik.contains(expectedIcerik)){
            System.out.println("Title test PASSED");
        }else System.out.println("Title test FAILED");

        //5- Arama cubuguna “Nutella” yazip aratin
        WebElement aramaKutusu= driver.findElement(By.className("gLFyf"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        //6- Bulunan sonuc sayisini yazdirin
        WebElement sonucYaziElement= driver.findElement(By.id("result-stats"));
        String actualSonucStr=sonucYaziElement.getText();
        System.out.println("actualSonucStr = " + actualSonucStr);

        //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        actualSonucStr=actualSonucStr.replaceAll("\\D","");
        double expectedSonuc=10000000;
        double actualSonuc=Double.parseDouble(actualSonucStr);

        if (actualSonuc>expectedSonuc){
            System.out.println("Sonuc testi PASSED");
        }else System.out.println("Sonuc testi FAILED");

        //8- Sayfayi kapatin
        driver.close();
    }
}
