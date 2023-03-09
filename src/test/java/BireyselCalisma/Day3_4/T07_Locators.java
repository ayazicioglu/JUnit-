package BireyselCalisma.Day3_4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class T07_Locators {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1- https://www.amazon.com/ sayfasına gidin.
        driver.get("https://www.amazon.com/");

        //2- Arama kutusuna “city bike” yazip aratin
        WebElement aramaKtusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKtusu.sendKeys("city bike"+ Keys.ENTER);

        //3- Görüntülenen sonuçların sayısını yazdırın
        WebElement sonucYaziElement= driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        System.out.println(sonucYaziElement.getText());

        //4- Listeden ilk urunun resmine tıklayın.
        WebElement ilkUrunElement= driver.findElement(By.xpath("//img[@data-image-index='1']"));
        ilkUrunElement.click();

        driver.close();
    }
}
