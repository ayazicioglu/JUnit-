package TeamCalismalari;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_96syf extends TestBase {
    @Test
    public void test01(){
      //Verilen web sayfasına gidin.
        //https://facebook.com
        driver.get("https://facebook.com");

        //b. Cookies’i kabul edin

        //c. Create an account buton’una basin
        driver.findElement(By.xpath("//*[text()='Yeni hesap oluştur']")).click();

        //d. Radio button elementlerini locate edin ve size uygun olani secin
        WebElement isimKutusu=driver.findElement(By.xpath("(//input[@type='text'])[2]"));
        Faker faker=new Faker();
        Actions actions=new Actions(driver);
        bekle(2);

        actions.sendKeys(faker.name().firstName()).
                sendKeys(Keys.TAB).
                sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).
                sendKeys("abala@hotmail.com").
                sendKeys(Keys.TAB).
                sendKeys("abala@hotmail.com").sendKeys(Keys.TAB).
                sendKeys(faker.internet().password()).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys("12").sendKeys(Keys.TAB).
                sendKeys("Mar").sendKeys(Keys.TAB).
                sendKeys("2000").sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ARROW_RIGHT).click().
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                click().perform();
        bekle(5);

    }

}
