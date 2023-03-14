package TeamCalismalari;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;


import java.util.Set;

public class C03 extends TestBase {
    @Test
    public void test(){
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //3- Cizili alan uzerinde sag click yapin
        WebElement cizgiliAlanElement=driver.findElement(By.id("hot-spot"));
        String ilkSayfaWHD=driver.getWindowHandle();
        Actions actions=new Actions(driver);
        actions.contextClick(cizgiliAlanElement).perform();

        bekle(1);

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String actualAlert=driver.switchTo().alert().getText();
        String expectedYazi="You selected a context menu";
        Assert.assertEquals(expectedYazi,actualAlert);

        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        //6- Elemental Selenium linkine tiklayalim
        driver.findElement(By.linkText("Elemental Selenium")).click();

        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        Set<String> tumWHD=driver.getWindowHandles();
        String ikinciWHD="";
        for (String each:tumWHD
             ) {
            if (!each.equals(ilkSayfaWHD)){
                ikinciWHD=each;
            }
        }
        driver.switchTo().window(ikinciWHD);

        String actualYazi=driver.findElement(By.tagName("h1")).getText();
        expectedYazi="Elemental Selenium";
        Assert.assertEquals(expectedYazi,actualYazi);


        bekle(2);
    }


}
