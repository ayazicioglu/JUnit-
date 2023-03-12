package BireyselCalisma.Day6_9_JUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class T30_MouseActions3 extends TestBase {
    @Test
    public void test01(){
        //1- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

        //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin mouse’u bu menunun ustune getirin
        WebElement acLiElement= driver.findElement(By.id("nav-link-accountList"));
        Actions actions=new Actions(driver);
        actions.moveToElement(acLiElement).perform();

        //3- “Create a list” butonuna basin
        WebElement createElement= driver.findElement(By.xpath("//*[text()='Create a List']"));
        actions.moveToElement(createElement).click().perform();

        //4- Acilan sayfada “Your Lists” yazisi oldugunu test edin
        WebElement yourListElement= driver.findElement(By.xpath("//*[@aria-level='1']"));
        String actualYazi=yourListElement.getText();
        String expIcerik="Your Lists";
        Assert.assertEquals(expIcerik,actualYazi);
    }
}
