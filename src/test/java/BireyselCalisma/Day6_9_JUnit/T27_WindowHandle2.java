package BireyselCalisma.Day6_9_JUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;
import java.util.Set;

public class T27_WindowHandle2 extends TestBase {
    @Test
    public void test01(){
        //● https://the-internet.herokuapp.com/windows adresine gidin.
          driver.get("https://the-internet.herokuapp.com/windows");
          String ilkSayfaWHD= driver.getWindowHandle();

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement openingElement= driver.findElement(By.tagName("h3"));
        String actualText=openingElement.getText();
        String expText="Opening a new window";
        Assert.assertEquals(expText,actualText);

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle=driver.getTitle();
        String expTitle="The Internet";
        Assert.assertEquals(expTitle,actualTitle);

        //● Click Here butonuna basın.
        WebElement clickHereElement= driver.findElement(By.linkText("Click Here"));
        clickHereElement.click();

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        Set<String> tumWHD=driver.getWindowHandles();
        String ikinciSayfaWHD="";
        for (String each:tumWHD
             ) {
            if (!ilkSayfaWHD.equals(each)){
                ikinciSayfaWHD+=each;
            }
        }
        driver.switchTo().window(ikinciSayfaWHD);
        actualTitle= driver.getTitle();
        expTitle="New Window";
        Assert.assertEquals(expTitle,actualTitle);

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        actualTitle=driver.getTitle();
        expTitle="New Window";
        Assert.assertEquals(expTitle,actualTitle);

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(ilkSayfaWHD);
        actualTitle=driver.getTitle();
        expTitle="The Internet";
        Assert.assertEquals(expTitle,actualTitle);

    }
}
