package BireyselCalisma.Day6_9_JUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class T29_MouseActions2 extends TestBase {
    @Test
    public void test01(){
        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");

        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        // 3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        WebElement dragElement= driver.findElement(By.id("draggable"));
        WebElement dropElement=driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        Actions actions=new Actions(driver);
        actions.dragAndDrop(dragElement,dropElement).perform();
        String dropMessage=dropElement.getText();
        String expected="Dropped!";
        bekle(3);
        Assert.assertEquals(expected,dropMessage);

    }
}
