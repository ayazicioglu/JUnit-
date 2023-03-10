package BireyselCalisma.Day6_9_JUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class T19_RadioButtons extends TestBase {

    @Test
    public void test01(){
        //a. Verilen web sayfasına gidin.
        //https://facebook.com
        driver.get("https://facebook.com");

        //b. Cookies’i kabul edin

        //c. Create an account buton’una basin
        WebElement createButtonElement= driver.findElement(By.xpath("(//a[@role='button'])[2]"));
        createButtonElement.click();

        //d. Radio button elementlerini locate edin ve size uygun olani secin
        WebElement kadinButonElement= driver.findElement(By.xpath("//input[@value='1']"));
        WebElement erkekButonElement= driver.findElement(By.xpath("//input[@value='2']"));
        WebElement ozelButonElement= driver.findElement(By.xpath("//input[@value='-1']"));

        erkekButonElement.click();

    }
}
