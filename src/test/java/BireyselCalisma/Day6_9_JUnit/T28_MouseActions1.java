package BireyselCalisma.Day6_9_JUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class T28_MouseActions1 extends TestBase {
    @Test
    public void test01(){
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        String ilkSayfaWHD= driver.getWindowHandle();

        //3- Cizili alan uzerinde sag click yapin
        WebElement cizgiliElement= driver.findElement(By.id("hot-spot"));
        Actions actions=new Actions(driver);
        actions.contextClick(cizgiliElement).perform();

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        driver.switchTo().alert();
        String alertText=driver.switchTo().alert().getText();
        String expText="You selected a context menu";
        Assert.assertEquals(expText,alertText);

        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        //6- Elemental Selenium linkine tiklayalim
        WebElement eSelElement= driver.findElement(By.linkText("Elemental Selenium"));
        eSelElement.click();

        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        Set<String> tumWHD=driver.getWindowHandles();
        String ikinciSayfaWHD="";
        for (String each:tumWHD
        ) {
            if (!ilkSayfaWHD.equals(each)){
                ikinciSayfaWHD+=each;
            }
        }
        driver.switchTo().window(ikinciSayfaWHD);
        WebElement h1Element= driver.findElement(By.tagName("h1"));
        String h1TagText=h1Element.getText();
        expText="Elemental Selenium";
        Assert.assertEquals(expText,h1TagText);
    }
}
