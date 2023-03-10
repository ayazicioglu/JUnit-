package BireyselCalisma.Day6_9_JUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class T15_Assertions extends TestBase {
    //2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
    @Test
    public void urlTest(){
        driver.get("https://www.bestbuy.com/");
        //○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
        String actualUrl= driver.getCurrentUrl();
        String expecetedUrl="https://www.bestbuy.com/";
        Assert.assertEquals(expecetedUrl,actualUrl);
    }
    @Test
    public void titleTest(){
        driver.get("https://www.bestbuy.com/");
        //○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        String actualTitle= driver.getTitle();
        String expectedTitle="Rest";
        Assert.assertFalse(actualTitle.contains(expectedTitle));
    }

    @Test
    public void logoTest(){
        driver.get("https://www.bestbuy.com/");
        //○ logoTest => BestBuy logosunun görüntülendigini test edin
        WebElement logoElement= driver.findElement(By.className("logo"));
        Assert.assertTrue(logoElement.isDisplayed());
    }
    @Test
    public void FrancaisLinkTest(){
        driver.get("https://www.bestbuy.com/");
        //○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        WebElement frButtonElement= driver.findElement(By.xpath("//button[@lang='fr']"));
        Assert.assertTrue(frButtonElement.isDisplayed());

    }
}
