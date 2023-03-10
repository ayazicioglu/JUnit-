package BireyselCalisma.Day6_9_JUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class T23_BasicAuthentication extends TestBase {

    @Test
    public void test01(){
        //2- https://the-internet.herokuapp.com/basic_auth sayfasina gidin
        //3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        //Html komutu : https://username:password@URL
        //Username : admin
        //password : admin
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        bekle(2);
        //4- Basarili sekilde sayfaya girildigini dogrulayin
        WebElement girisBasariliYaziElemennt= driver.findElement(By.tagName("p"));
        Assert.assertTrue(girisBasariliYaziElemennt.isDisplayed());
    }
}
