package BireyselCalisma.Day5_Maven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class T14_MavenTekrarTesti {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");

        //2. Username kutusuna “standard_user” yazdirin
        WebElement usernameElement= driver.findElement(By.id("user-name"));
        usernameElement.sendKeys("standard_user");

        //3. Password kutusuna “secret_sauce” yazdirin
        WebElement passwordElement= driver.findElement(By.id("password"));
        passwordElement.sendKeys("secret_sauce");

        //4. Login tusuna basin
        WebElement loginButtonElement=driver.findElement(By.id("login-button"));
        loginButtonElement.click();

        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement ilkUrunElement=driver.findElement(By.id("item_4_title_link"));
        String ilkUrunIsim=ilkUrunElement.getText();
        ilkUrunElement.click();

        //6. Add to Cart butonuna basin
        WebElement addtoCartElement=driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addtoCartElement.click();

        //7. Alisveris sepetine tiklayin
        WebElement sepetElement=driver.findElement(By.className("shopping_cart_link"));
        sepetElement.click();

        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        WebElement cartElement=driver.findElement(By.className("inventory_item_name"));
       String urunKontrol= cartElement.getText();
       if (urunKontrol.equals(ilkUrunIsim)){
           System.out.println("Urun ekleme test PASSED");
       }else System.out.println("Urun ekleme test FAILED");

        //9. Sayfayi kapatin
        driver.close();
    }
}
