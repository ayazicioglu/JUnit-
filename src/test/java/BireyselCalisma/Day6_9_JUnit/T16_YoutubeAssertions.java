package BireyselCalisma.Day6_9_JUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class T16_YoutubeAssertions extends TestBase {
        //1) Bir class oluşturun: YoutubeAssertions
        //2) https://www.youtube.com adresine gidin
        //3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin

    @Test
    public void titleTest(){
        //○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
        driver.get("https://www.youtube.com");
        String actualTitle= driver.getTitle();
        String expTitle="YouTube";
        Assert.assertEquals(expTitle,actualTitle);
    }

    @Test
    public void imageTest(){
        //○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        driver.get("https://www.youtube.com");
        WebElement imageElement= driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]"));
        Assert.assertTrue(imageElement.isDisplayed());
    }
    @Test
    public void searchBoxTest(){
        //○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        driver.get("https://www.youtube.com");
        WebElement searchBoxElement= driver.findElement(By.xpath("//input[@name='search_query']"));
        Assert.assertTrue(searchBoxElement.isEnabled());
    }
    @Test
    public void wrongTitleTest(){
        //○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        driver.get("https://www.youtube.com");
        String actualTitle= driver.getTitle();
        String expectedTitle="youtube";
        Assert.assertNotEquals(actualTitle,expectedTitle);
    }
}
