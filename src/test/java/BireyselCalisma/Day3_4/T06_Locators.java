package BireyselCalisma.Day3_4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class T06_Locators {
    public static void main(String[] args) {
        //1- Bir test class’i olusturun ilgili ayarlari yapin
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //2- https://www.automationexercise.com/ adresine gidin
        driver.get("https://www.automationexercise.com/");

        //3- Sayfada 147 adet link bulundugunu test edin.
        List<WebElement> linkElements=driver.findElements(By.tagName("a"));
        if (linkElements.size()==147){
            System.out.println("Link test PASSED");
        }else System.out.println("Link test FAILED, actual link: "+linkElements.size());

        //4- Products linkine tiklayin
        WebElement productElement= driver.findElement(By.xpath("//*[text()=' Products']"));
        productElement.click();
        driver.navigate().back();
        driver.navigate().forward();

        //5- special offer yazisinin gorundugunu test edin
        WebElement specialOfferElement=driver.findElement(By.id("sale_image"));
        if (specialOfferElement.isDisplayed()){
            System.out.println("Special Offer Test PASSED");
        }else System.out.println("Special Offer Test FAILED");

        //6- Sayfayi kapatin
        driver.close();
    }
}
