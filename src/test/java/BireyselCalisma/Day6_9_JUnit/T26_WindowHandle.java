package BireyselCalisma.Day6_9_JUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import utilities.TestBase;
import utilities.TestBaseClass;

public class T26_WindowHandle extends TestBase {

    @Test
    public void test01(){

    //● Amazon anasayfa adresine gidin.

        driver.get("https://www.amazon.com");

    //● Sayfa’nin window handle degerini String bir degiskene atayin
        String amazonWHD=driver.getWindowHandle();

    //● Sayfa title’nin “Amazon” icerdigini test edin
        String actualTitle=driver.getTitle();
        String expectedIcerik="Amazon";
        Assert.assertTrue(actualTitle.contains(expectedIcerik));

    //● Yeni bir tab olusturup, acilan tab’da wisequarter.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.wisequarter.com");

    //● Sayfa title’nin “Wise Quarter” icerdigini test edin
        String actualTitleWise=driver.getTitle();
        String expectedIcerikWise="Wise Quarter";
        Assert.assertTrue(actualTitleWise.contains(expectedIcerikWise));

    //● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.walmart.com");

    //● Sayfa title’nin “Walmart” icerdigini test edin
        String actualTitleWall=driver.getTitle();
        expectedIcerik="Walmart";
        Assert.assertTrue(actualTitleWall.contains(expectedIcerik));

    //● Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(amazonWHD);
        Assert.assertTrue(driver.getTitle().contains("Amazon"));
}
 }