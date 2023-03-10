package BireyselCalisma.Day6_9_JUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class T24_HandleIFrame extends TestBase {
    @Test
    public void test01(){
        //1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        //2 ) Bir metod olusturun: iframeTest
        iframeTest();
    }
    public void iframeTest(){

        //- “An IFrame containing….” textinin erisilebilir oldugunu test edin ve
        //konsolda yazdirin.
        //- Text Box’a “Merhaba Dunya!” yazin.
        //- TextBox’in altinda bulunan “Elemental Selenium” linkini textinin
        //gorunur oldugunu dogrulayin ve konsolda yazdirin

        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement textElement= driver.findElement(By.tagName("h3"));
        Assert.assertTrue(textElement.isDisplayed());
        System.out.println(textElement.getText());

        WebElement frameElement= driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(frameElement);
        bekle(2);
        WebElement frameYaziKutuElement=driver.findElement(By.id("tinymce"));
        frameYaziKutuElement.sendKeys("Merhaba Dunya!");
        driver.switchTo().parentFrame();

        WebElement elementelSeleniumElement= driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(elementelSeleniumElement.isDisplayed());
        System.out.println(elementelSeleniumElement.getText());
        bekle(2);
    }
}
