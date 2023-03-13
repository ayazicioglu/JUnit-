package NevzatHocaUygulama.day03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import javax.swing.*;

public class kiwiTest extends TestBase {

    @Test
    public void kiwiTest() {
        //// https://www.kiwi.com/en/ sayfasina gidin
        driver.get("https://www.kiwi.com/en/");

        //// Cookies i reddedin
        driver.findElement(By.xpath("(//div[@class='ButtonPrimitiveContent__StyledButtonPrimitiveContent-sc-1nfggrh-0 iFkUjC'])[4]")).click();

        //// Sag ust kisimdan dil ve para birimi secenegini Turkiye ve TL olarak secin
        driver.findElement(By.xpath("//*[@data-test='RegionalSettingsButton']")).click();
        WebElement dropDownLanguageElement=driver.findElement(By.xpath("//select[@data-test='LanguageSelect']"));
        Select dilSecimi=new Select(dropDownLanguageElement);
        dilSecimi.selectByVisibleText("Türkçe");
        WebElement dropDownCurrencyElement=driver.findElement(By.xpath("//select[@data-test='CurrencySelect']"));
        Select paraTuru=new Select(dropDownCurrencyElement);
        paraTuru.selectByVisibleText("Turkish lira - TRY");

        driver.findElement(By.xpath("//*[text()='Save & continue']")).click();


        //// Sectiginiz dil ve para birimini dogrulayin
        Assert.assertTrue(driver.findElement(By.xpath("(//img[@alt='Türkçe'])[1]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='TRY']")).isDisplayed());

        //// Ucus secenegi olarak tek yon secelim
        driver.findElement(By.xpath("(//*[text()='Gidiş Dönüş'])[1]")).click();
        driver.findElement(By.xpath("(//*[text()='Tek Yön'])")).click();
        bekle(2);

        //// Kalkis ve varis boxlarini temizleyerek kalkis ve varis ulkesini kendimiz belirleyelim

        driver.findElement(By.xpath("//*[@data-test='PlacePickerInputPlace-close']")).click();
        Actions actions=new Actions(driver);
        actions.sendKeys("İstanbul").perform();
        bekle(2);
        driver.findElement(By.xpath("(//*[@aria-label='Add place'])[1]")).click();
        bekle(2);
        driver.findElement(By.xpath("//*[@data-test='SearchPlaceField-destination']")).click();
        actions.sendKeys("varsova").perform();
        bekle(2);
        driver.findElement(By.xpath("(//div[@data-test='PlacePickerRow-wrapper'])[1]")).click();
        bekle(4);

        //// Gidis tarihi kismina erisim saglayarak gidecegimiz gunu secelim ve booking i iptal edelim
        WebElement bookingEl= driver.findElement(By.xpath("//label[@class='Checkbox__StyledLabel-sc-y66hzm-5 fKLfkU']"));
        bookingEl.click();
        driver.findElement(By.xpath("//*[@name='search-outboundDate']")).click();
        bekle(10);
        WebElement tarih= driver.findElement(By.xpath("//div[@data-value='2023-03-16']"));
        actions.doubleClick(tarih).perform();
        bekle(5);

        driver.findElement(By.xpath("//div[text()='Ara']")).click();
        bekle(3);

        //// Sadece aktarmasiz ucuslar olarak filtreleme yapalim ve en ucuz secenegine tiklayalim
        driver.findElement(By.xpath("(//div[@class='Radio__StyledIconContainer-sc-1e6hy4x-1 cQMXav'])[1]")).click();
        bekle(3);
        driver.findElement(By.xpath("//span[text()='En ucuz']")).click();
        bekle(3);

        //// Filtreleme yaptigimiz en ucuz ucusun fiyatini getirerek 5000 tl den kucuk oldgunu dogurlayalim
        String actualFiyatStr=driver.findElement(By.xpath("(//div[@data-test='ResultCardPrice'])[1]")).
                getText().replaceAll("\\D","");
        int actualFiyat=Integer.parseInt(actualFiyatStr);
        System.out.println("actualFiyat = " + actualFiyat);
        Assert.assertTrue(actualFiyat<5000);

    }

}
