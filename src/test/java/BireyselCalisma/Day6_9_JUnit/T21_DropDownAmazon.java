package BireyselCalisma.Day6_9_JUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class T21_DropDownAmazon extends TestBase {
    @Test
    public void test01(){
        //● https://www.amazon.com/ adresine gidin.
        driver.get(" https://www.amazon.com/");
        //- Test 1
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
        WebElement dropDownElement= driver.findElement(By.id("searchDropdownBox"));
        Select select=new Select(dropDownElement);
        int kategoriSayi=select.getOptions().size();
        Assert.assertEquals(45,kategoriSayi); //kategori sayısı sürekli değişiyor failed olabilir
    }
    @Test
    public void test02(){
        //● https://www.amazon.com/ adresine gidin.
        driver.get(" https://www.amazon.com/");
        //-Test 2
        WebElement dropDownElement= driver.findElement(By.id("searchDropdownBox"));
        Select select=new Select(dropDownElement);

        //1. Kategori menusunden Books secenegini secin
        select.selectByVisibleText("Books");

        //2. Arama kutusuna Java yazin ve aratin
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java"+ Keys.ENTER);

        //3. Bulunan sonuc sayisini yazdirin
        WebElement sonucYaziElement=driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        System.out.println(sonucYaziElement.getText());

        //4. Sonucun Java kelimesini icerdigini test edin
        String expectedIcerik="Java";
        String actualSonuc=sonucYaziElement.getText();
        Assert.assertTrue(actualSonuc.contains(expectedIcerik));
        bekle(2);

    }
}
