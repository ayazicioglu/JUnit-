package BireyselCalisma.Day6_9_JUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class T20_DropDown extends TestBase {

    @Test
    public void dropDownTest(){
        //● https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");

        //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement dropDownElement= driver.findElement(By.id("dropdown"));
        Select select=new Select(dropDownElement);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());

        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());

        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());

        //4.Tüm dropdown değerleri(value) yazdırın
        List<WebElement> optionList=select.getOptions();
        int sira=1;
        for (WebElement each:optionList
             ) {
            System.out.println(sira+"- "+each.getText());
            sira++;
        }
        //5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True ,degilse False yazdırın.
        int boyutDropDown=optionList.size();
        if (boyutDropDown==4){
            System.out.println("True");
        }else System.out.println("False");
    }
}
