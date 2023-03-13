package BireyselCalisma.Day6_9_JUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class T33_ActionsClassHomeWork extends TestBase {
    @Test
    public void test01(){
        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        //2- Hover over Me First" kutusunun ustune gelin
        WebElement homfElement=driver.findElement(By.xpath("//*[text()='Hover Over Me First!']"));
        Actions actions=new Actions(driver);
        //3- Link 1" e tiklayin
        WebElement link1Element=driver.findElement(By.xpath("(//*[text()='Link 1'])[1]"));
        actions.moveToElement(homfElement).click(link1Element).perform();
        bekle(3);

        //4- Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());

        //5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        //6- “Click and hold" kutusuna basili tutun
        WebElement cahElement= driver.findElement(By.id("click-box"));
        actions.clickAndHold(cahElement).perform();

        //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(cahElement.getText());

        //8- “Double click me" butonunu cift tiklayin
        WebElement dcmElement= driver.findElement(By.xpath("//*[text()='Double Click Me!']"));
        actions.doubleClick(dcmElement).perform();

        bekle(5);
    }
}
