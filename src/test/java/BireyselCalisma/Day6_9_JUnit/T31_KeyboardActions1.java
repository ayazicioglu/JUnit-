package BireyselCalisma.Day6_9_JUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class T31_KeyboardActions1 extends TestBase {
    @Test
    public void test01(){
        //2- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");

        //3- Arama kutusuna actions method’larine kullanarak Samsung A71 yazdirin ve
        // Enter’a basarak arama yaptirin
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        Actions actions=new Actions(driver);
        actions.sendKeys(aramaKutusu,"Samsung A71").sendKeys(Keys.ENTER).perform();

        //4- aramanin gerceklestigini test edin
        WebElement aramaSonucYaziElement= driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        String aramaSonucYazisi=aramaSonucYaziElement.getText();
        Assert.assertTrue(aramaSonucYazisi.contains("Samsung A71"));
    }
}
