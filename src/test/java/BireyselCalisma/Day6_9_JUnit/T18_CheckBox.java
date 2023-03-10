package BireyselCalisma.Day6_9_JUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class T18_CheckBox extends TestBase {
    @Test
    public void test01(){
        //a. Verilen web sayfasına gidin.
        //https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        //b. Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement checkbox1Element= driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkbox2Element= driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

        //c. Checkbox1 seçili değilse onay kutusunu tıklayın
        if (!checkbox1Element.isSelected()){
        checkbox1Element.click();
        }

        //d. Checkbox2 seçili değilse onay kutusunu tıklayın
        if (!checkbox2Element.isSelected()){
            checkbox2Element.click();
        }
    }
}
